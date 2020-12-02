package com.zxuru.dao;

import com.zxuru.Conexion;
import com.zxuru.model.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oCli;
    }

    public void insertCliente(String rut,String name,String ape){
        String sql = "INSERT INTO cliente VALUES('"+rut+"','"+name+"','"+ape+"',null);";
        try {
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR " + throwables,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Cliente> selectCliente(){
        String sql = "SELECT * FROM cliente";
        List<Cliente> list = new ArrayList<>();

        Connection con = myCon.getCon();
        try (Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // fila por fila
                String rut = resultSet.getString(1);
                String nombre = resultSet.getString(2);
                String ape = resultSet.getString(3);
                Integer boleta = resultSet.getInt(4);
                Cliente clie = new Cliente(rut, nombre, ape, boleta);
                list.add(clie);
            }
            statement.close();
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }
}
