package com.cooltee.mgt.controller;

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

    /**
     * the json data required
     * @return result
     */
    @RequestMapping("/spring")
    @ResponseBody
    public Map<String, String> json(){
        Map<String, String> resuct = new HashMap<>();
        resuct.put("hello", "world");
        return resuct;
    }
}
