package com.zxuru.gui;

import com.zxuru.Conexion;
import com.zxuru.dao.DaoTrabajador;
import com.zxuru.model.Trabajador;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LogIn extends JFrame {

    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;

    private Conexion myCon;
    private DaoTrabajador daoTrabajador;

    public LogIn(){
        super("Inicio sesion");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel1);
        setSize(new Dimension(400,500));
        pack();

        String ip = "localhost";
        String db = "libreria";
        String user = "root";
        String password = "";

        try {
            myCon = new Conexion(ip, user, password, db);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error de conexión:" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        daoTrabajador = new DaoTrabajador(myCon);

        ingresarButton.addActionListener(e -> {
            Trabajador oUsu;
            var rut = textField1.getText();
            var pass = passwordField1.getText();
            oUsu = daoTrabajador.getLogin(rut);

            try{
                if (rut.isEmpty() || rut.isBlank())
                    throw new Exception();
                if (rut.equals(oUsu.getRut()) && pass.equals(oUsu.getContra())){
                    this.dispose();
                    new Menu().setVisible(true);
                    JOptionPane.showMessageDialog(null,"Bienvenido al menu\n"+oUsu.getNombre().toUpperCase()+"");
                }else{
                    JOptionPane.showMessageDialog(null,"DATOS INVALIDOS\nRevisar rut y contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
                    clear();
                }
            } catch (Exception exc){
                exc.printStackTrace();
                clear();
            }
        });
    }

    public void clear(){
        textField1.setText(null);
        passwordField1.setText(null);
        textField1.grabFocus();
    }
}
