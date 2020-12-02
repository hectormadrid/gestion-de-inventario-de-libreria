package com.zxuru.model;

import javax.swing.*;
import java.util.Objects;

public class Articulo {
    private Integer id;
    private String nombre;
    private Integer cantidad;
    private Integer precio;
    private String rut_proveedor;
    private Integer active;

    public Articulo() {
    }

    public Articulo(Integer id, String nombre, Integer cantidad, Integer precio, String rut_proveedor, Integer active) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.rut_proveedor = rut_proveedor;
        this.active = active;
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

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
        if (!active.equals(null))
            this.active = active;
        else
            JOptionPane.showMessageDialog(null,"Error ingreso nulo active","ERROR",JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(id, articulo.id) &&
                Objects.equals(nombre, articulo.nombre) &&
                Objects.equals(cantidad, articulo.cantidad) &&
                Objects.equals(precio, articulo.precio) &&
                Objects.equals(rut_proveedor, articulo.rut_proveedor) &&
                Objects.equals(active, articulo.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, cantidad, precio, rut_proveedor, active);
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", rut_proveedor='" + rut_proveedor + '\'' +
                ", active=" + active +
                '}';
    }
}
