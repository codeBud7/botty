package com.codebud7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by s.puskeiler on 07.05.16.
 */
@Controller
public class Messenger
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    String info()
    {
        return "Hello World!";
    }
}
