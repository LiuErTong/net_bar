package com.netbarsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RouteController {

    @RequestMapping({"/","/login"})
    public String login(){
        return "Login";
    }

    @RequestMapping({"/index"})
    public String index(){
        return "Index";
    }

    @RequestMapping({"/pet"})
    public String pet(){
        return "Pet";
    }

    @RequestMapping("/{htmlPath}")
    public String htmlRoute(@PathVariable String htmlPath){
        return htmlPath;
    }

}
