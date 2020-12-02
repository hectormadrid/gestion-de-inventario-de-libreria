package com.zxuru.dao;

import com.zxuru.Conexion;
import com.zxuru.model.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoCliente {

    private Conexion myCon;
    public DaoCliente(Conexion myCon){
        this.myCon = myCon;
    }

    public Cliente findUser(int id){
        String sql = "SELECT COUNT(cliente.rut) FROM cliente WHERE rut ='"+id+"'";
        Cliente oCli = new Cliente(null,null,null,null);
        try{
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                oCli.setRut(resultSet.getString(1));
                System.out.println(oCli.getRut());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oCli;
    }
}
