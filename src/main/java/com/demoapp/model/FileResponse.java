package com.demoapp.model;

/**
 * <h1>Hello, Demo App!</h1>
 * The Demo App program implements an application that
 * showcases "Recursive Directory Listing" and  "File Properties" for given inputs from the web app.
 * <p>
 * This is POJO class for response used in 2 RESTful Services for WebApp.
 *
 *
 * @author  SivaShankar Pulluri
 * @version 1.0
 * @since   2020-07-06
 */

public class FileResponse {
    private String fileName;
    private String filePath;
    private Boolean isDirectory;
    private String fileSize;
    private Boolean isReadable;
    private Boolean isWritable;
    private Boolean isExecutable;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Boolean getDirectory() {
        return isDirectory;
    }

    public void setDirectory(Boolean directory) {
        isDirectory = directory;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Boolean getReadable() {
        return isReadable;
    }

    public void setReadable(Boolean readable) {
        isReadable = readable;
    }

    public Boolean getExecutable() {
        return isExecutable;
    }

    public void setExecutable(Boolean executable) {
        isExecutable = executable;
    }

    public Boolean getWritable() {
        return isWritable;
    }

    public void setWritable(Boolean writable) {
        isWritable = writable;
    }
}
