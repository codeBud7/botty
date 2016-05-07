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
        stringBuilder.append(getObject());
        for (final MessengerBotEntry messengerBotEntry : getEntry())
        {
            stringBuilder.append(messengerBotEntry.getId());
            stringBuilder.append(messengerBotEntry.getTime());
            for (final MessengerBotEntryMessaging messengerBotEntryMessaging : messengerBotEntry.getMessaging())
            {
                stringBuilder.append(messengerBotEntryMessaging.getRecipient());
                stringBuilder.append(messengerBotEntryMessaging.getSender());
                stringBuilder.append(messengerBotEntryMessaging.getTimestamp());

                final MessengerBotEntryMessagingMessage messengerBotEntryMessagingMessage = messengerBotEntryMessaging.getMessage();
                stringBuilder.append(messengerBotEntryMessagingMessage.getMid());
                stringBuilder.append(messengerBotEntryMessagingMessage.getSeq());
                stringBuilder.append(messengerBotEntryMessagingMessage.getText());
            }
        }

        return stringBuilder.toString();
    }
}
