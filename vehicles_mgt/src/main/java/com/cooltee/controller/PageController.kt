package com.cooltee.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * controller of pages
 * Created by Daniel on 2017/5/20.
 */
@Controller
@RequestMapping("/page")
class PageController {

    @RequestMapping("/welcome")
    fun welcome(): String {
        return "page/welcome"
    }
}