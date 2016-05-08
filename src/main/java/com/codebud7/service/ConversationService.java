package com.codebud7.service;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by s.puskeiler on 08.05.16.
 */
@Service
public class ConversationService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationService.class);

    @Autowired
    private FacebookMessengerHandler facebookMessengerHandler;


    public void communicateWithRecipient(final String message, final Map<String, Long> recipient)
    {
        LOGGER.info("Recipient {} says {}", recipient, message);

        this.facebookMessengerHandler.sendMessage(createAnswer(message), recipient);
    }


    private String createAnswer(final String message)
    {
        switch (message)
        {
            case "What is love?":
                return "Baby don't hurt me.";

            case "Hundi":
                return "Wau Wau";

            default:
                return "Ich bin leider nicht sicher, was du meinst...";
        }
    }
}
