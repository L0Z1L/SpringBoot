package com.Controller;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class UserController {
    @RequestMapping("/users")
    public String s(){

        System.out.println("123456");
        log.info("123456");
        log.debug("123456");
        return "Hello world";
    }




}
