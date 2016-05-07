package com.codebud7.model.request;

import java.util.List;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class MessengerBotEntry
{
    private Long id;
    private Long time;
    private List<MessengerBotEntryMessaging> messaging;


    public Long getId()
    {
        return this.id;
    }


    public void setId(final Long id)
    {
        this.id = id;
    }


    public Long getTime()
    {
        return this.time;
    }


    public void setTime(final Long time)
    {
        this.time = time;
    }


    public List<MessengerBotEntryMessaging> getMessaging()
    {
        return this.messaging;
    }


    public void setMessaging(final List<MessengerBotEntryMessaging> messaging)
    {
        this.messaging = messaging;
    }
}
