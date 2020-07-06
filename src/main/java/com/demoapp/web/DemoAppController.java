package com.demoapp.web;

import com.demoapp.model.FileResponse;
import com.demoapp.service.ApplicationService;
import com.demoapp.util.DemoUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>Hello, Demo App!</h1>
 * The Demo App program implements an application that
 * showcases "Recursive Directory Listing" and  "File Properties" for given inputs from the web app.
 * <p>
 * This Controller class exposes 2 RESTful Services for WebApp.
 *
 *
 * @author  SivaShankar Pulluri
 * @version 1.0
 * @since   2020-07-06
 */

@RestController
@RequestMapping("/demo")
public class DemoAppController {

    private ApplicationService applicationService;

    @Autowired
    public void setApplicationService(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    /**
     * This method is used to add two integers. This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     * @param filePath This is the paramter for filePath
     * @return FileResponse This returns FileResponse Object for JSON response.
     */
    @RequestMapping("/file")
    public FileResponse fileDetails(@RequestParam(value = "filePath") String filePath) {
        FileResponse response = new FileResponse();
        if (filePath == null || filePath.equals(""))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Required values for filePath");
        File file = new File(filePath);
        DemoUtil.setFileResponse(response, file);
        return response;
    }

    /**
     * This method is used to add two integers. This is
     * a the simplest form of a class method, just to
     * show the usage of various javadoc Tags.
     * @param directory This is the paramter for directory
     * @return Map<String, List<FileResponse>>  This returns Map Object for JSON response.
     */
    @GetMapping("/files")
    public Map<String, List<FileResponse>> getDirectoryMap(@RequestParam("directory") String directory) {
        Map<String, List<FileResponse>> responseMap = new HashMap<>();
        FileResponse response = new FileResponse();
        List<FileResponse> fileResponseList = new ArrayList<>();

        // File object
        if (directory == null || directory.equals(""))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Required values for directory");

        File maindir = new File(directory);
        if (maindir.exists() && maindir.isDirectory()) {
            // array for files and sub-directories
            // of directory pointed by maindir
            File filesOnlyArr[] = DemoUtil.getOnlyFiles(maindir);
            File directoriesOnlyArr[] = DemoUtil.getOnlySubDirectories(maindir);

            for (File file : filesOnlyArr) {
                if (file != null) {
                    response = new FileResponse();
                    DemoUtil.setFileResponse(response, file);
                    fileResponseList.add(response);
                }
            }
            responseMap.put(maindir.getPath(), fileResponseList);
            for (File file : directoriesOnlyArr) {
                if (file != null) {
                    DemoUtil.traverseDirectoryRecursive(file, responseMap);
                }
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Directory Not Found");
        }
        return responseMap;
    }
}