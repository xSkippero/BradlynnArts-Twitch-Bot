package de.Skippero.data;

/*

Projekt: BradlynnArts-Twitch-Bot
Package: de.Skippero.data
Created by Skippero
on 28.02.2023 , 19:49

*/

import lombok.Getter;

@Getter
public class DataBaseCredentials {

    public DataBaseCredentials(String host, int port, String database, String user, String password) {
        this.host = host;
        this.port = port;
        this.database = database;
        this.user = user;
        this.password = password;
    }

    private final String host;
    private final int port;
    private final String database;
    private final String user;
    private final String password;

}
