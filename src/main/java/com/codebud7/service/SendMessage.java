package com.codebud7.service;

import com.codebud7.model.response.MessengerBotRecipient;
import com.codebud7.properties.MessengerProperties;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by s.puskeiler on 07.05.16.
 */
@Service
public class SendMessage
{
    private static Logger LOGGER = LoggerFactory.getLogger(SendMessage.class);

    private MessengerProperties messengerProperties = ConfigFactory.create(MessengerProperties.class, System.getenv());


    public void execute(final MessengerBotRecipient messengerBotRecipient) throws UnirestException
    {
        Unirest.post(this.messengerProperties.getApiEndpoint())
            .queryString("access_token", this.messengerProperties.getPageAccessToken())
            .field("recipient", messengerBotRecipient.getRecipient())
            .field("message", messengerBotRecipient.getMessage())
            .asJson();

        try
        {
            Unirest.shutdown();
        }
        catch (final IOException e)
        {
            LOGGER.error(e.toString());
        }
    }
}
