package com.codebud7.model.response;

import java.util.Map;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class MessengerBotRecipient
{
    private Map<String, Long> recipient;
    private Map<String, String> message;


    public Map<String, Long> getRecipient()
    {
        return this.recipient;
    }


    public void setRecipient(final Map<String, Long> recipient)
    {
        this.recipient = recipient;
    }


    public Map<String, String> getMessage()
    {
        return this.message;
    }


    public void setMessage(final Map<String, String> message)
    {
        this.message = message;
    }
}
