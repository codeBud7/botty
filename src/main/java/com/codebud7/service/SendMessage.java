package com.codebud7.service;

import com.codebud7.model.response.MessengerBotRecipient;
import com.codebud7.properties.MessengerProperties;
import com.mashape.unirest.http.Headers;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
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

    private final static String ACCESS_TOKEN = "access_token";

    private MessengerProperties messengerProperties = ConfigFactory.create(MessengerProperties.class, System.getenv());


    public void execute(final MessengerBotRecipient messengerBotRecipient) throws UnirestException
    {
        LOGGER.debug(this.messengerProperties.getApiEndpoint());
        LOGGER.debug(this.messengerProperties.getPageAccessToken());
        LOGGER.info(messengerBotRecipient.toJson());

        final Headers headers = Unirest.post(this.messengerProperties.getApiEndpoint())
            .header("Content-Type", "application/json")
            .queryString(ACCESS_TOKEN, this.messengerProperties.getPageAccessToken())
            .body(messengerBotRecipient.toJson())
            .asJson()
            .getHeaders();

        LOGGER.info(headers.toString());
    }
}
