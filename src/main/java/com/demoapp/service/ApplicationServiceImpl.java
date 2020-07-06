package com.demoapp.service;

import com.demoapp.exception.ApplicationNotFoundException;
import com.demoapp.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Optional;

/**
 * <h1>Hello, Demo App!</h1>
 * The Demo App program implements an application that
 * showcases "Recursive Directory Listing" and  "File Properties" for given inputs from the web app.
 * <p>
 * This is ServiceImplementation class for 2 RESTful Services for WebApp.
 *
 *
 * @author  SivaShankar Pulluri
 * @version 1.0
 * @since   2020-07-06
 */

@Service
public class ApplicationServiceImpl implements ApplicationService {
    ApplicationRepository applicationRepository = new ApplicationRepository();

    @Override
    public List<File> listFiles(String directory) {
        return (List<File>) applicationRepository.listFiles(directory);
    }

    @Override
    public File findFile(String filePath) {
        Optional<File> optionalFile = applicationRepository.findFile(filePath);

        if (optionalFile.isPresent())
            return optionalFile.get();
        else
            throw new ApplicationNotFoundException("File Not Found");
    }


}
