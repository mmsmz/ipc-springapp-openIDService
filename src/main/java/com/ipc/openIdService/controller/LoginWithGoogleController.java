package com.ipc.openIdService.controller;

import com.ipc.openIdService.dto.ResponseDto;
import com.ipc.openIdService.service.LoginWithGoogle;
import com.ipc.openIdService.util.CommonConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("oIService")
public class LoginWithGoogleController {

    /**
     * The Logger
     */
    final Logger logger = LoggerFactory.getLogger(LoginWithGoogleController.class);

    @Autowired
    LoginWithGoogle loginWithGoogle;

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World";
    }


    @GetMapping("/restricted")
    public String restricted(@AuthenticationPrincipal OAuth2User principal){
        return principal.getAttribute("email").toString();
    }
    
    @GetMapping("/loginWithGoogle")
    public RedirectView loginWithGoogle(RedirectAttributes attributes, @AuthenticationPrincipal OAuth2User principal) {
        //attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        //attributes.addAttribute("attribute", "redirectWithRedirectView");

        String email = principal.getAttribute("email").toString();
        String urlpath = loginWithGoogle.loginWithGoogle(email);

        return new RedirectView(urlpath);
    }


    // GET: getuserid API (@RequestParam String email) return userId
    @GetMapping(value = "/getUserId", produces = "application/json")
    public ResponseEntity<ResponseDto> getUserId(@RequestParam String email) {
        logger.info("Inside the Get User Id method Start");

        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(CommonConstant.SUCCESS);
        responseDto.setData(loginWithGoogle.getUserId(email));

        logger.info("Inside the Get User Id method End");
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }




}
