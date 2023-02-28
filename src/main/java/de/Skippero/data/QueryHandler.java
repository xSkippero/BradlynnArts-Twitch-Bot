package de.Skippero.data;

/*

Projekt: BradlynnArts-Twitch-Bot
Package: de.Skippero.data
Created by Skippero
on 28.02.2023 , 19:38

*/

import de.Skippero.Core;
import de.Skippero.configuration.ConfigurationManager;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class QueryHandler {

    private final List<Connection> connections = new ArrayList<>();
    private final DataBaseCredentials credentials;

    public QueryHandler() {
        ConfigurationManager configurationManager = Core.getInstance().getConfigurationManager();
        this.credentials = configurationManager.GetDataBaseCredentials();
        Connection con = getConnection();

        if (con != null) {
            connections.add(con);
            System.out.println("[" + new Date().toGMTString() + "] Successfully established SQL Connection");
            createTables();
        } else {
            System.out.println("[" + new Date().toGMTString() + "] Could not established SQL Connection, exiting with Error code 1");
            System.exit(1);
        }
    }

    public ResultSet ExecuteQuerySync(String statement) {
        try {
            Connection con = getConnection();
            if (con == null) {
                return null;
            }
            Statement stm = con.createStatement();
            connections.add(con);
            autoClose(con);
            return stm.executeQuery(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void ExecuteUpdateSync(String statement) throws SQLException {
        Connection con = getConnection();
        if (con == null) {
            return;
        }
        Statement stm = con.createStatement();
        connections.add(con);
        autoClose(con);
        stm.executeUpdate(statement);
    }

    public void CloseConnections() {
        connections.forEach(con -> {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private Connection getConnection() {
        String address = "jdbc:mysql://" + credentials.getHost() + ":" + credentials.getPort() + "/" + credentials.getDatabase();
        try {
            return DriverManager.getConnection(address, credentials.getUser(), credentials.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void createTables() {
        System.out.println("[" + new Date().toGMTString() + "] Creating Tables if not exits");
        try {
            ExecuteUpdateSync("CREATE TABLE IF NOT EXISTS foobar(id bigint PRIMARY KEY AUTO_INCREMENT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void autoClose(Connection con) {
        Timer timer = new Timer("Timer" + UUID.randomUUID());
        TimerTask task = new TimerTask() {
            public void run() {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                connections.remove(con);
            }
        };
        timer.schedule(task, 5000);
    }

}
