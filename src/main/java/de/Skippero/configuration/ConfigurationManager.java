package de.Skippero.configuration;

/*

Projekt: BradlynnArts-Twitch-Bot
Package: de.Skippero.configuration
Created by Skippero
on 28.02.2023 , 19:40

*/

import de.Skippero.data.DataBaseCredentials;

public class ConfigurationManager {

    public DataBaseCredentials GetDataBaseCredentials() {
        return new DataBaseCredentials("",0,"","","");
    }

}
