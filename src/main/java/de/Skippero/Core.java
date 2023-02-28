package de.Skippero;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import de.Skippero.configuration.ConfigurationManager;

/*

Projekt: BradlynnArts-Twitch-Bot
Package: de.Skippero
Created by Skippero
on 27.02.2023 , 23:45

*/

public class Core {

    private static Core core;
    private final ConfigurationManager configurationManager;

    {
        core = this;
        configurationManager = new ConfigurationManager();
    }

    public static void main(String[] args)  {

        //OAuth2Credential credential = new OAuth2Credential("twitch", token);

        /*TwitchClient twitchClient = TwitchClientBuilder.builder()
                .withEnableChat(true)
                .withEnableHelix(true)
                .withChatAccount(credential)
                .build();

        twitchClient.getChat().sendMessage("xskippero","Hello World");
        */
    }

    public static Core getInstance() {
        return core;
    }

    public ConfigurationManager getConfigurationManager() {
        return this.configurationManager;
    }

}
