package com.zxuru.model;

import javax.swing.*;

public class Articulo {
    private Integer id;
    private String nombre;
    private Integer cantidad;
    private Integer precio;
    private String rut_proveedor;

    public Articulo(Integer id, String nombre, Integer cantidad, Integer precio, String rut_proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.rut_proveedor = rut_proveedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if (!id.equals(null))
            this.id = id;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo id","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.equals(null))
            this.nombre = nombre;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo nombre","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        if (!cantidad.equals(null))
            this.cantidad = cantidad;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo cantidad","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        if (!precio.equals(null))
            this.precio = precio;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo precio","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    public String getRut_proveedor() {
        return rut_proveedor;
    }

    public void setRut_proveedor(String rut_proveedor) {
        if (!rut_proveedor.equals(null))
            this.rut_proveedor = rut_proveedor;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo rut_proveedor","ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
