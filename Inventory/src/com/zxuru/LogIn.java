package com.zxuru;

//import com.zxuru.persistence.ConexionStandar;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame{
    private JPanel pnlPrin;
    private JPanel panel1;
    private JButton borrarButton;
    private JButton entrarButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a7Button;
    private JButton a0Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton a5Button;
    private JButton a6Button;
    private JTextField rutTxt;
    //private ConexionStandar con;
    StringBuilder sb;

    public LogIn(/*ConexionStandar con*/){
        super("Login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        add(pnlPrin);
        pack();

        //this.con = con;



        a1Button.addActionListener(e -> {
            var nb = "1";
            addNumber(sb,nb);
        });
        a2Button.addActionListener(e -> {
            var nb = "2";
            addNumber(sb,nb);
        });
        a3Button.addActionListener(e -> {
            var nb = "3";
            addNumber(sb,nb);
        });
        a4Button.addActionListener(e -> {
            var nb = "4";
            addNumber(sb,nb);
        });
        a5Button.addActionListener(e -> {
            var nb = "5";
            addNumber(sb,nb);
        });
        a6Button.addActionListener(e -> {
            var nb = "6";
            addNumber(sb,nb);
        });
        a7Button.addActionListener(e -> {
            var nb = "7";
            addNumber(sb,nb);
        });
        a8Button.addActionListener(e -> {
            var nb = "8";
            addNumber(sb,nb);
        });
        a9Button.addActionListener(e -> {
            var nb = "9";
            addNumber(sb,nb);
        });
        a0Button.addActionListener(e -> {
            var nb = "0";
            addNumber(sb,nb);
        });

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
