package com.cooltee.controller;

import com.cooltee.dao.entity.User;
import com.cooltee.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * The json Controller
 * Created by Daniel on 2017/2/12.
 */
@Controller
@RequestMapping("/json")
public class MainJsonController {

    @Autowired
    private UserService userService;

    /**
     * the json data required
     * @return result
     */
    @RequestMapping("/user")
    @ResponseBody
    public Map<String, String> json(){
        //Map<String, String> result = userService.getUserInfo();
        return null;
    }
}
