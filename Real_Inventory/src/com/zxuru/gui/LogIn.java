package com.zxuru.gui;

import com.zxuru.dao.DaoTrabajador;
import com.zxuru.model.Trabajador;
import com.zxuru.persistence.ConexionStandar;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class LogIn extends JFrame{
    private JPanel pnlPrin;
    private JTextField rutxt;
    private JButton cerrarButton;
    private JButton entrarButton;
    private ConexionStandar con;

    private DaoTrabajador daoTrab;

    public LogIn(ConexionStandar con) {
        super("Login");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,500);
        add(pnlPrin);
        pack();

        this.con = con;


        entrarButton.addActionListener(this::loginButton);
    }

    private void loginButton(ActionEvent actionEvent){
        var code = rutxt.getText().trim().toLowerCase();

        Trabajador trabajador = new Trabajador(null,null,null);

        if (code.isEmpty()){
            JOptionPane.showMessageDialog(this,"Campo rut vacio");
        }else{
            if ()
        }
    }
}
