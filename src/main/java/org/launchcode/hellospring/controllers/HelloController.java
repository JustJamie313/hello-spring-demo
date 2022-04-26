package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

//    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }
    @GetMapping("goodbye/{name}")
    @ResponseBody
    public String goodbyeWithPathParam(@PathVariable String name) {
        return "Goodbye, " +name+"!";
    }
    // Handle requests of the form /hello?name=LaunchCode
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "redirect:/goodbye/"+name;
    }
}
