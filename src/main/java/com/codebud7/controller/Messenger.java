package com.codebud7.controller;

import com.codebud7.model.FacebookMessengerCallback;
import com.codebud7.properties.MessengerProperties;
import com.codebud7.service.ConversationService;
import com.google.common.base.Preconditions;
import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
    private static final String NOT_AUTHORIZED = "NOT AUTHORIZED";
    private static final Logger LOGGER = LoggerFactory.getLogger(Messenger.class);

    private final MessengerProperties messengerProperties = ConfigFactory.create(MessengerProperties.class);

    @Autowired
    private ConversationService conversationService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private void info()
    {
    }


    @RequestMapping(value = "/webhook", method = RequestMethod.GET)
    @ResponseBody
    private String verify(
        @RequestParam(name = "hub.mode") final String hubMode,
        @RequestParam(name = "hub.challenge") final String hubChallenge,
        @RequestParam(name = "hub.verify_token") final String hubToken)
    {
        if (hubToken.equals(this.messengerProperties.getVerifyToken()))
        {
            LOGGER.info("verify for mode {}", hubMode);
            return hubChallenge;
        }
        else
        {
            LOGGER.info("access denied for {}, {}, {}", hubMode, hubChallenge, hubToken);
            return NOT_AUTHORIZED;
        }
    }


    @RequestMapping(value = "/webhook", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    private void receive(@RequestBody final FacebookMessengerCallback facebookMessengerCallback)
    {
        Preconditions.checkNotNull(facebookMessengerCallback);

        final FacebookMessengerCallback.FacebookMessengerCallbackType facebookMessengerCallbackType = facebookMessengerCallback.getType();
        if (FacebookMessengerCallback.FacebookMessengerCallbackType.RECEIVED.equals(facebookMessengerCallbackType))
        {
            this.conversationService.communicateWithRecipient(facebookMessengerCallback.getMessageText(), facebookMessengerCallback.getSender());
        }

        LOGGER.info("Resolved message with callback type {}", facebookMessengerCallbackType);
    }
}
