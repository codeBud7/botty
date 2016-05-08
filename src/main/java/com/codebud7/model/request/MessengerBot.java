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


    @Override
    public String toString()
    {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("object:" + getObject());
        for (final MessengerBotEntry messengerBotEntry : getEntry())
        {
            stringBuilder.append("id:" + messengerBotEntry.getId());
            stringBuilder.append("time:" + messengerBotEntry.getTime());
            for (final MessengerBotEntryMessaging messengerBotEntryMessaging : messengerBotEntry.getMessaging())
            {
                stringBuilder.append("recipient:" + messengerBotEntryMessaging.getRecipient());
                stringBuilder.append("sender:" + messengerBotEntryMessaging.getSender());
                stringBuilder.append("timestamp:" + messengerBotEntryMessaging.getTimestamp());

                final MessengerBotEntryMessagingMessage messengerBotEntryMessagingMessage = messengerBotEntryMessaging.getMessage();
                if (messengerBotEntryMessagingMessage != null)
                {
                    if (messengerBotEntryMessagingMessage.getMid() != null)
                    {
                        stringBuilder.append("mid:" + messengerBotEntryMessagingMessage.getMid());
                    }
                    if (messengerBotEntryMessagingMessage.getSeq() != null)
                    {
                        stringBuilder.append("seq:" + messengerBotEntryMessagingMessage.getSeq());
                    }
                    if (messengerBotEntryMessagingMessage.getText() != null)
                    {
                        stringBuilder.append("text:" + messengerBotEntryMessagingMessage.getText());
                    }
                }
            }
        }

        return stringBuilder.toString();
    }
}
