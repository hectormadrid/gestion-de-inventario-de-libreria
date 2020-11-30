package model;

import javax.swing.*;

public class UsuarioBase {
    private String rut;
    private String nombre;
    private String apellido;

    public UsuarioBase(String rut, String nombre, String apellido) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        if (!rut.isEmpty())
            this.rut = rut;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo boleta","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.isEmpty())
            this.nombre = nombre;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo boleta","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (!apellido.isEmpty())
            this.apellido = apellido;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo boleta","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
