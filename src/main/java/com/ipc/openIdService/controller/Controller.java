package com.ipc.openIdService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class Controller {


    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/restricted")
    public String restricted(){
        return "to see this text you need to be logged in!!";

    }
    
    @GetMapping("/redirectWithRedirectView")
    public RedirectView redirectWithUsingRedirectView(
      RedirectAttributes attributes) {
        //attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        //attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("http://localhost:8090/fazith#");
    }
}
