package com.cooltee.mgt.controller;

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

    /**
     * jsp page
     * @return spring.jsp
     */
    @RequestMapping("/spring")
    public String jsonPage(){
        return "spring";
    }

}
