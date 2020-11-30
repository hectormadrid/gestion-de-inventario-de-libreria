package com.zxuru.model;

import javax.swing.*;

public class Trabajador extends UsuarioBase{
    private String entrada;
    private String salida;

    public Trabajador(String rut, String nombre, String apellido, String entrada, String salida) {
        super(rut, nombre, apellido);
        this.entrada = entrada;
        this.salida = salida;
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
}