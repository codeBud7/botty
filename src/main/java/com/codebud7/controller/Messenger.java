package com.codebud7.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    String verify(final HttpServletRequest request)
    {
        try
        {
            LOGGER.info(request.toString());

            final Map<String, String[]> paramMap = request.getParameterMap();

            for (final Map.Entry<String, String[]> set : paramMap.entrySet())
            {
                LOGGER.info(String.valueOf(set));
            }
        }
        catch (final Exception ex)
        {
            LOGGER.error(ex.toString());
        }
        return "failed";
    }
}
