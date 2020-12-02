package com.zxuru.dao;

import com.zxuru.Conexion;
import com.zxuru.model.Articulo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoArticulo {

    private Conexion myCon;

    public DaoArticulo(Conexion myCon) {
        this.myCon = myCon;
    }

    public List<Articulo> getAll() {
        String sql = "SELECT * FROM articulo";
        List<Articulo> list = new ArrayList<>();

        Connection con = myCon.getCon();
        try (Statement statement = con.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) { // fila por fila
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Integer cant = resultSet.getInt(3);
                Integer price = resultSet.getInt(4);
                String rutProv = resultSet.getString(5);
                Integer activ = resultSet.getInt(6);
                Articulo art = new Articulo(id, name, cant, price,rutProv,activ);
                list.add(art);
            }
            statement.close();
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Collections.EMPTY_LIST;
    }

    public Articulo getID(String name){
        Articulo oArt = new Articulo();
        String sql = "SELECT id,precio FROM articulo WHERE nombre='"+name+"'";
        Connection con = myCon.getCon();
        try (Statement statement = con.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                oArt.setId(resultSet.getInt(1));
                oArt.setPrecio(resultSet.getInt("precio"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return oArt;
    }

    public void activateArt(int id){
        String sql = "CALL activar_producto("+id+")";
        try{
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    public void deactivateArt(int id){
        String sql = "CALL desactivar_producto("+id+")";
        try{
            Connection con = myCon.getCon();
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }


}

