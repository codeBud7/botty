package com.codebud7.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by s.puskeiler on 07.05.16.
 */
@Controller
public class Messenger
{

    private static final Logger LOGGER = LoggerFactory.getLogger(Messenger.class);

    private static final String FBMESSENGERBOT_VERIFY_TOKEN = "foo";


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    void info()
    {
    }


    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    @ResponseBody
    String verify(
        @RequestParam(name = "hub.mode") final String hubMode,
        @RequestParam(name = "hub.challenge") final String hubChallenge,
        @RequestParam(name = "hub.verify_token") final String hubToken)
    {
        return hubChallenge;
    }
}
