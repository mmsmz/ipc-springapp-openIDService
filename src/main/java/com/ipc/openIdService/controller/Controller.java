package com.ipc.openIdService.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    public String restricted(@AuthenticationPrincipal OAuth2User principal){
        return principal.getAttribute("email").toString();

    }
    
    @GetMapping("/loginwithgoogle")
    public RedirectView redirectWithUsingRedirectView(
      RedirectAttributes attributes) {
        //attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        //attributes.addAttribute("attribute", "redirectWithRedirectView");
        return new RedirectView("http://localhost:4200/contact-us");
    }
}
