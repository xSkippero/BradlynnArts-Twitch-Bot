package de.Skippero;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;

/*

Projekt: BradlynnArts-Twitch-Bot
Package: de.Skippero
Created by Skippero
on 27.02.2023 , 23:45

*/

public class Core {

    public static void main(String[] args)  {

        if (args.length < 1) {
            System.err.println("Missing Token on Parameter 1 (Index 0)");
            System.exit(1);
        }

        String token = args[0];
        OAuth2Credential credential = new OAuth2Credential("twitch", token);

        TwitchClient twitchClient = TwitchClientBuilder.builder()
                .withEnableChat(true)
                .withEnableHelix(true)
                .withChatAccount(credential)
                .build();

        twitchClient.getChat().sendMessage("xskippero","Hello World");

    }

}
