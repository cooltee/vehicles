package com.cooltee.controller;

import com.cooltee.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * the page Controller
 * Created by Daniel on 2017/2/11.
 */
@Controller
@RequestMapping("/page")
public class MainPageController {

    @Autowired
    private UserService userService;

    /**
     * jsp page
     * @return spring.jsp
     */
    @RequestMapping("/spring")
    public String jsonPage(){
        return "spring";
    }


    @RequestMapping("/welcome")
    public String welcome(){
        return "page/welcome";
    }

}
