package com.zxuru.gui;

import com.zxuru.persistence.ConexionStandar;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame{
    private JPanel pnlPrin;
    private JPanel panel1;
    private JButton borrarButton;
    private JButton entrarButton;
    private JTextField rutTxt;
    private JButton salirButton;
    private JButton ingresarButton;
    private ConexionStandar con;
    StringBuilder sb;

    public LogIn(ConexionStandar con){
        super("Login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        add(pnlPrin);
        pack();

        this.con = con;



        borrarButton.addActionListener(e -> {
            rutTxt.setText(null);
        });

        entrarButton.addActionListener(this::loginButton);
    }

    private void loginButton(ActionEvent actionEvent){
        var code = rutTxt.getText();

    }

    private void addNumber(StringBuilder sb, String nb){
        sb.append(nb);
        rutTxt.setText(String.valueOf(sb));
    }
}
