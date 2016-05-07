package com.codebud7.model.request;

import java.util.Map;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class MessengerBotEntryMessaging
{
    private Map<String, Long> sender;
    private Map<String, Long> recipient;
    private Long timestamp;
    private MessengerBotEntryMessagingMessage message;


    public Map<String, Long> getSender()
    {
        return this.sender;
    }


    public void setSender(final Map<String, Long> sender)
    {
        this.sender = sender;
    }


    public Map<String, Long> getRecipient()
    {
        return this.recipient;
    }


    public void setRecipient(final Map<String, Long> recipient)
    {
        this.recipient = recipient;
    }


    public Long getTimestamp()
    {
        return this.timestamp;
    }


    public void setTimestamp(final Long timestamp)
    {
        this.timestamp = timestamp;
    }


    public MessengerBotEntryMessagingMessage getMessage()
    {
        return this.message;
    }


    public void setMessage(final MessengerBotEntryMessagingMessage message)
    {
        this.message = message;
    }
}
