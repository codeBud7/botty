package com.codebud7.model.response;

import java.util.Map;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class MessengerBotRecipient
{
    private Map<String, Long> recipient;
    private Map<String, String> message;


    public String getRecipient()
    {
        return "'id':'" + this.recipient.get("id") + "'";
    }


    public void setRecipient(final Map<String, Long> recipient)
    {
        this.recipient = recipient;
    }


    public String getMessage()
    {
        return "'text':'" + this.message.get("text") + "'";
    }


    public void setMessage(final Map<String, String> message)
    {
        this.message = message;
    }


    public String toJson()
    {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("'recipient':{" + getRecipient() + "},");
        stringBuilder.append("'message':{" + getMessage() + "}");
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
