package com.demoapp.exception;

/**
 * <h1>Hello, Demo App!</h1>
 * The Demo App program implements an application that
 * showcases "Recursive Directory Listing" and  "File Properties" for given inputs from the web app.
 * <p>
 * This is Exception class for 2 RESTful Services for WebApp.
 *
 *
 * @author  SivaShankar Pulluri
 * @version 1.0
 * @since   2020-07-06
 */

public class ApplicationNotFoundException extends RuntimeException {
    public ApplicationNotFoundException(String exception) {
        super(exception);
    }
}
