package com.codebud7.model.request;

/**
 * Created by s.puskeiler on 07.05.16.
 */
public class MessengerBotEntryMessagingMessage
{
    private String mid;
    private Long seq;
    private String text;


    public String getMid()
    {
        return this.mid;
    }


    public void setMid(final String mid)
    {
        this.mid = mid;
    }


    public Long getSeq()
    {
        return this.seq;
    }


    public void setSeq(final Long seq)
    {
        this.seq = seq;
    }


    public String getText()
    {
        return this.text;
    }


    public void setText(final String text)
    {
        this.text = text;
    }
}
