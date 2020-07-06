package com.demoapp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <h1>Hello, Demo App!</h1>
 * The Demo App program implements an application that
 * showcases "Recursive Directory Listing" and  "File Properties" for given inputs from the web app.
 * <p>
 * Main Controller class to display homepage for WebApp.
 *
 *
 * @author  SivaShankar Pulluri
 * @version 1.0
 * @since   2020-07-06
 */
@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message:test}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", this.message);
        return "welcome";
    }

}