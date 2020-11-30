package com.zxuru.model;

public class Trabajador extends UsuarioBase{
    private String entrada;
    private String salida;

    public Trabajador(String rut, String nombre, String apellido) {
        super(rut, nombre, apellido);
        this.entrada = entrada;
        this.salida = salida;
    }

}
