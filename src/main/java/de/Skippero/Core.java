package de.Skippero;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import de.Skippero.configuration.ConfigurationManager;
import de.Skippero.data.QueryHandler;

/*

Projekt: BradlynnArts-Twitch-Bot
Package: de.Skippero
Created by Skippero
on 27.02.2023 , 23:45

*/

public class Core {

    protected static ConfigurationManager configurationManager;
    protected static QueryHandler queryHandler;

    public static void main(String[] args)  {
        configurationManager = new ConfigurationManager();
        //queryHandler = new QueryHandler();

        //OAuth2Credential credential = new OAuth2Credential("twitch", token);

        /*TwitchClient twitchClient = TwitchClientBuilder.builder()
                .withEnableChat(true)
                .withEnableHelix(true)
                .withChatAccount(credential)
                .build();

        twitchClient.getChat().sendMessage("xskippero","Hello World");
        */
    }

    public static ConfigurationManager getConfigurationManager() {
        return configurationManager;
    }

    public static QueryHandler getQueryHandler() {
        return queryHandler;
    }

}
