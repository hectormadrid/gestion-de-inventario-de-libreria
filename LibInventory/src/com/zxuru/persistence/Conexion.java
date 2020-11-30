package com.zxuru.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion implements ConexionStandar{
    private String ip;
    private String username;
    private String passwd;
    private String database;
    private int port;
    private Connection con;

    public Conexion(String ip, String username, String passwd, String database, int port) throws SQLException {
        this.ip = ip;
        this.username = username;
        this.passwd = passwd;
        this.database = database;
        this.port = port;


        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = String.format("jdbc:mariadb://%s:%d/%s",ip,port,database);
        con = DriverManager.getConnection(url, username, passwd);

    }

    @Override
    public Connection getConnection() {
        return con;
    }
}