package com.zxuru.dao;

import com.zxuru.model.Trabajador;
import com.zxuru.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoTrabajador {

    private Conexion myCon;
    public DaoTrabajador(Conexion myCon){
        this.myCon = myCon;
    }

    public Trabajador getLogin(String id){
        String sql = "SELECT * FROM trabajador WHERE rut = '"+ id +"'";
        Trabajador oUsu = new Trabajador(id,null,null);
        try{
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
}
