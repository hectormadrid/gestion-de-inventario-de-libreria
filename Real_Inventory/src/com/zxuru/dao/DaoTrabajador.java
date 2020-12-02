package com.zxuru.dao;

import com.zxuru.model.Cliente;
import com.zxuru.model.Trabajador;
import com.zxuru.Conexion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoTrabajador {

    private Conexion myCon;

    public DaoTrabajador(Conexion myCon) {
        this.myCon = myCon;
    }

    public Trabajador getLogin(String id) {
        String sql = "SELECT * FROM trabajador WHERE rut = '" + id + "'";
        Trabajador oUsu = new Trabajador(id, null, null);
        try {
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                oUsu.setRut(resultSet.getString(1));
                oUsu.setNombre(resultSet.getString(2));
                oUsu.setContra(resultSet.getString(4));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oUsu;
    }

    public List<Trabajador> getWorkers() {
        String sql = "SELECT * FROM trabajador;";
        List<Trabajador> list = new ArrayList<>();

        Connection con = myCon.getCon();
        try (Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // fila por fila
                String rut = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                String apell = resultSet.getString(3);
                Trabajador trab = new Trabajador(rut, nombre, apell);
                list.add(trab);
            }
            statement.close();
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public Trabajador findUser(int id){
        String sql = "SELECT COUNT(trabajador.rut) FROM trabajador WHERE rut ='"+id+"'";
        Trabajador oTraba = new Trabajador(null,null,null);
        try{
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                oTraba.setRut(resultSet.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oTraba;
    }

    public void despedirWorker(String rut) {
        String sql = "delete from trabajador where rut = '" + rut + "';";
        try {
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void contrataWorker(String rut, String nombre, String apellido, String contra) {
        String sql = "INSERT INTO trabajador VALUES ('" + rut + "','" + nombre + "','" + apellido + "','" + contra + "',null,null)";
        try {
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR " + throwables, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
