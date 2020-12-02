package com.zxuru.model;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Trabajador extends UsuarioBase{
    private String entrada;
    private String salida;
    private String contra;

    public Trabajador(String rut, String nombre, String apellido) {
        super(rut, nombre, apellido);
    }

    public Trabajador(String rut, String nombre, String apellido, String entrada, String salida, String contra) {
        super(rut, nombre, apellido);
        this.entrada = entrada;
        this.salida = salida;
        this.contra = contra;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        if (!entrada.isEmpty())
            this.entrada = entrada;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo entrada","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        if (!salida.isEmpty())
            this.salida = salida;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo salida","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        if (!contra.isEmpty())
            this.contra = contra;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo contraseña","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}