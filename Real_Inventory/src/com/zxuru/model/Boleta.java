package com.zxuru.model;

import java.util.Objects;

public class Boleta {
    private Integer id;
    private String rutCli;
    private Integer articulos;
    private String cantArt;
    private String fecha;
    private int total;
    private int formaPago;

    public Boleta() {
    }

    public Boleta(Integer id, String rutCli, Integer articulos, String cantArt, String fecha, int total, int formaPago) {
        this.id = id;
        this.rutCli = rutCli;
        this.articulos = articulos;
        this.cantArt = cantArt;
        this.fecha = fecha;
        this.total = total;
        this.formaPago = formaPago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRutCli() {
        return rutCli;
    }

    public void setRutCli(String rutCli) {
        this.rutCli = rutCli;
    }

    public Integer getArticulos() {
        return articulos;
    }

    public void setArticulos(Integer articulos) {
        this.articulos = articulos;
    }

    public String getCantArt() {
        return cantArt;
    }

    public void setCantArt(String cantArt) {
        this.cantArt = cantArt;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boleta boleta = (Boleta) o;
        return total == boleta.total &&
                formaPago == boleta.formaPago &&
                Objects.equals(id, boleta.id) &&
                Objects.equals(rutCli, boleta.rutCli) &&
                Objects.equals(articulos, boleta.articulos) &&
                Objects.equals(cantArt, boleta.cantArt) &&
                Objects.equals(fecha, boleta.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rutCli, articulos, cantArt, fecha, total, formaPago);
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "id=" + id +
                ", rutCli='" + rutCli + '\'' +
                ", articulos=" + articulos +
                ", cantArt='" + cantArt + '\'' +
                ", fecha='" + fecha + '\'' +
                ", total=" + total +
                ", formaPago=" + formaPago +
                '}';
    }
}
