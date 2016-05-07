package com.codebud7.model.request;

import java.util.List;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class MessengerBot
{
    private String object;
    private List<MessengerBotEntry> entry;


    public String getObject()
    {
        return this.object;
    }


    public void setObject(final String object)
    {
        this.object = object;
    }


    public List<MessengerBotEntry> getEntry()
    {
        return this.entry;
    }


    public void setEntry(final List<MessengerBotEntry> entry)
    {
        this.entry = entry;
    }
}
