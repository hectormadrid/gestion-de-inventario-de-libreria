package com.zxuru.model;

import javax.swing.*;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(boleta, cliente.boleta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boleta);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "boleta=" + boleta +
                '}';
    }
}
