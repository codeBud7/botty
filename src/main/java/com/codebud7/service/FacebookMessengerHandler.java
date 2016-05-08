package com.codebud7.service;

import com.codebud7.model.FacebookMessengerMessage;
import com.codebud7.properties.MessengerProperties;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.Map;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by s.puskeiler on 07.05.16.
 */
@Service
public class FacebookMessengerHandler
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FacebookMessengerHandler.class);

    private final static String ACCESS_TOKEN = "access_token";

    private final MessengerProperties messengerProperties = ConfigFactory.create(MessengerProperties.class, System.getenv());


    public void sendMessage(final String text, final Map<String, Long> recipient)
    {
        final FacebookMessengerMessage facebookMessengerMessage = makeFacebookMessengerMessage(text, recipient);
        execute(facebookMessengerMessage);
    }


    private FacebookMessengerMessage makeFacebookMessengerMessage(final String text, final Map<String, Long> recipient)
    {
        return new FacebookMessengerMessage.Builder()
            .withMessage(text)
            .withRecipient(recipient)
            .build();
    }


    private void execute(final FacebookMessengerMessage facebookMessengerMessage)
    {
        LOGGER.debug(this.messengerProperties.getApiEndpoint());
        LOGGER.debug(this.messengerProperties.getPageAccessToken());

        try
        {
            final Headers headers = Unirest.post(this.messengerProperties.getApiEndpoint())
                .header("Content-Type", "application/json")
                .queryString(ACCESS_TOKEN, this.messengerProperties.getPageAccessToken())
                .body(facebookMessengerMessage.toJson())
                .asJson()
                .getHeaders();

            LOGGER.debug(headers.toString());
        }
        catch (final UnirestException e)
        {
            LOGGER.error(e.toString());
        }
    }
}
