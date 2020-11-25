package com.zxuru;

import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCobalt2IJTheme;
import com.formdev.flatlaf.intellijthemes.FlatDarkPurpleIJTheme;

import javax.swing.*;

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

        SwingUtilities.invokeLater(() -> new LogIn());
    }
}
