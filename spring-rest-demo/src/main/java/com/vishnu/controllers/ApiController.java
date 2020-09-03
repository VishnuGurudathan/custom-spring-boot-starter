package com.vishnu.controllers;

import com.vishnu.service.Countable;
import com.vishnu.service.TrackTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API Controller for demo
 *
 * @author : vishnu.g
 * created on : 02/Sep/2020
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @GetMapping
    @TrackTime
    @Countable
    public String helloWorld() {
        return "Hello world !!!";
    }
}
