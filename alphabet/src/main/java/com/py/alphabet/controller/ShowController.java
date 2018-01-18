package com.py.alphabet.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.py.utility.FileUtils;
import com.py.utility.StringUtils;

/**
 * Created by panfenghui on 2017/10/26.
 */
@Controller
public class ShowController {


    /**
     * http://localhost:8081/alphabet/show
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    @ResponseBody
    public String show() throws Exception {

    	String str = StringUtils.lower("bbbb");
//    	str = OuterUtils.getContent();
    	str = StringUtils.convert(str);
    	List<String> thisProjectMsgList = FileUtils.readFromClassPath("message/alphabet.txt");//加载本项目的内容
    	List<String> utilProjectMsgList = FileUtils.readFromClassPath("message/utility.txt");//加载utility项目的内容
    	
    	str+="\n\r<br/>";
    	for (String msg : thisProjectMsgList) {
			str+=msg;
		}
    	
    	str+="\n\r<br/>";
    	for (String msg : utilProjectMsgList) {
    		str+=msg;
    	}
    	
        return str;
    }

}
