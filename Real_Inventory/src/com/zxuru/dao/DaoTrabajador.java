package com.zxuru.dao;

import com.zxuru.model.Trabajador;
import com.zxuru.persistence.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoTrabajador {

    private Conexion myCon;

    public Trabajador getLogin(String id){
        String sql = "SELECT * FROM usuario WHERE rut = '"+ id +"'";
        Trabajador oUsu = new Trabajador(id,null,null);
        try{
            Connection con = myCon.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                oUsu.setRut(resultSet.getString(1));
                oUsu.setNombre(resultSet.getString(2));
                oUsu.setApellido(resultSet.getString(3));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oUsu;
    }
}
