package com.codebud7.properties;

import org.aeonbits.owner.Config;

/**
 * Created by s.puskeiler on 07.05.16.
 */
@Config.Sources("classpath:messenger.properties")
public interface MessengerProperties extends Config
{
    @Key("verify.token")
    @DefaultValue("foo")
    String getVerifyToken();

    @Key("page.access.token")
    String getPageAccessToken();

    @Key("api.endpoint")
    @DefaultValue("https://graph.facebook.com/v2.6/me/messages")
    String getApiEndpoint();
}
