package com.demoapp.util;

import com.demoapp.model.FileResponse;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoUtil {
    public static void traverseDirectoryRecursive(File subdirectory, Map<String, List<FileResponse>> responseMap) {
        FileResponse response = new FileResponse();
        List<FileResponse> fileResponseList = new ArrayList<>();

        // terminate condition
        if (subdirectory == null || subdirectory.isFile())
            return;

        File filesOnlyArr[] = getOnlyFiles(subdirectory);
        File directoriesOnlyArr[] = getOnlySubDirectories(subdirectory);

        if (filesOnlyArr != null) {
            for (File file : filesOnlyArr) {
                if (file != null) {
                    response = new FileResponse();
                    setFileResponse(response, file);
                    fileResponseList.add(response);
                }
            }
        }
        responseMap.put(subdirectory.getPath(), fileResponseList);

        // recursion for sub-directories in subdirectory
        for (File file : directoriesOnlyArr) {
            if (file != null) {
                traverseDirectoryRecursive(file, responseMap);
            }
        }
    }

    public static File[] getOnlyFiles(File directory) {
        File[] files = directory.listFiles();
        File[] results = new File[directory.listFiles().length];
        int i = 0;
        for (File file : files) {
            if (file.isFile()) {
                results[i] = file;
            }
        }
        return results;
    }

    public static File[] getOnlySubDirectories(File directory) {

        File[] files = directory.listFiles();
        File[] results = new File[directory.listFiles().length];
        int i = 0;
        for (File file : files) {
            if (file.isDirectory()) {
                results[i] = file;
            }
        }
        return results;
    }

    public static void setFileResponse(FileResponse response, File file) {
        response.setFilePath(file.getPath());
        response.setDirectory(file.isDirectory());
        response.setFileSize(FileUtils.byteCountToDisplaySize(file.length()));
        response.setFileName(file.getName());
        response.setExecutable(file.canExecute());
        response.setWritable(file.canWrite());
        response.setReadable(file.canRead());
    }
}
