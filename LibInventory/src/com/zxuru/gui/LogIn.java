package com.zxuru.gui;

import com.zxuru.persistence.ConexionStandar;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame{
    private JPanel pnlPrinc;
    private JPanel panel1;
    private JButton entrarButton;
    private JButton salirButton;
    private JTextField rutxt;
    private ConexionStandar con;
    StringBuilder sb;

    public LogIn(ConexionStandar con){
        super("Login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        add(pnlPrinc);
        pack();

        this.con = con;

        salirButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,"Bye bye","Adius",JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        });

        entrarButton.addActionListener(this::loginButton);
    }

    private void loginButton(ActionEvent actionEvent){
        var code = rutxt.getText();

    }
}
