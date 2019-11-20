package com.imooc.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;
import org.slf4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@ApiIgnore
@RestController
public class HelloController {
    final  static Logger LOGGER =LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/hello")
    public Object hello(){
        LOGGER.debug("debug:hello");
        LOGGER.debug("info:hello");
        LOGGER.debug("warn:hello");
        LOGGER.debug("error:hello");


        return "hello world";
    }

    @GetMapping("/setSession")
    public  Object setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userInfo","new user");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("usrInfo");
        //session.removeAttribute("usrInfo");
       return "ok";
    }
}
