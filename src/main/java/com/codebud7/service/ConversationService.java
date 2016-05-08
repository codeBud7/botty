package com.codebud7.service;

import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
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
        switch (message.toLowerCase())
        {
            case "what is love":
                return "Baby dont hurt me.";

            case "danke":
                return ":-)";

            case "hundi":
                return "Wau Wau";

            case "uhrzeit":
                return "Es ist " + getCurrentTime();

            default:
                return "Ich bin leider nicht sicher, was du meinst...";
        }
    }


    public String getCurrentTime()
    {
        return new SimpleDateFormat("HH:mm:ss.SSS").format(DateTime.now(DateTimeZone.forTimeZone(TimeZone.getTimeZone("EUROPE/BERLIN"))).toDate());
    }
}
