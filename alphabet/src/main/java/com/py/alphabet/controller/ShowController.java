package com.py.alphabet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.py.utility.StringUtils;

/**
 * Created by panfenghui on 2017/10/26.
 */
@Controller
public class ShowController {


    @RequestMapping("/show")
    @ResponseBody
    public String show() throws Exception {

    	String str = StringUtils.lower("JavaScript");
        return str;
    }

}
