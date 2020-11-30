package com.zxuru.model;

import javax.swing.*;

public class Proveedor extends UsuarioBase{
    private Integer fono;
    private String correo;

    public Proveedor(String rut, String nombre, String apellido, Integer fono, String correo) {
        super(rut, nombre, apellido);
        this.fono = fono;
        this.correo = correo;
    }

    public Integer getFono() {
        return fono;
    }

    public void setFono(Integer fono) {
        if (!fono.equals(null))
            this.fono = fono;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo fono","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (!correo.isEmpty())
            this.correo = correo;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo correo","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
