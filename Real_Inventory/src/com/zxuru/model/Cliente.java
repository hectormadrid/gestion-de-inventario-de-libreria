package com.zxuru.model;

import javax.swing.*;

public class Cliente extends UsuarioBase{
    private Integer boleta;

    public Cliente(String rut, String nombre, String apellido, Integer boleta) {
        super(rut, nombre, apellido);
        this.boleta = boleta;
    }

    public Integer getBoleta() {
        return boleta;
    }

    public void setBoleta(Integer boleta) {
        if (!boleta.equals(null))
            this.boleta = boleta;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo boleta","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
