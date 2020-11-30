package com.zxuru;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;
import persistence.Conexion;
import persistence.ConexionStandar;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        FlatDarkPurpleIJTheme.install();
        try {
            UIManager.setLookAndFeel( new FlatDarkPurpleIJTheme());
        }catch (Exception ex){
            System.err.println( "Failed to initialize LaF" );
        }

        UIManager.put( "Button.arc", 999 );
        UIManager.put( "Component.arc", 999 );
        UIManager.put( "ProgressBar.arc", 999 );
        UIManager.put( "TextComponent.arc", 999 );
        try {
            ConexionStandar con = new Conexion(
                    "localhost",
                    "root",
                    "",
                    "libreria",
                    3306);

            SwingUtilities.invokeLater(() -> new LogIn(con));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null,"Can't connect to DB exiting");
            System.exit(1);
        }


    }
}
