package com.zxuru.gui;

import com.zxuru.Conexion;
import com.zxuru.dao.DaoArticulo;
import com.zxuru.model.Articulo;
import com.zxuru.model.Trabajador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class Principal extends JFrame {
    private Trabajador trab;
    private JPanel panel1;
    private JList list1;
    private JTable table1;
    private JButton agregarArticuloALaButton;
    private JButton retrocederButton;
    private JTabbedPane tabbedPane1;
    private JComboBox comboBox1;
    private JTextField textField1;

    private DefaultListModel listModel;
    private DefaultTableModel tableModel;
    private DefaultComboBoxModel comboBoxModel;

    private Conexion myCon;
    private DaoArticulo daoArt;

    public Principal(){
        super("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel1);
        setSize(new Dimension(500,600));
        pack();

        String ip = "localhost";
        String db = "libreria";
        String user = "root";
        String password = "";

        try {
            myCon = new Conexion(ip, user, password, db);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,
                    "Error de conexión:" + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        daoArt = new DaoArticulo(myCon);

        tableModel = new DefaultTableModel();
        table1.setModel(tableModel);

        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Precio");

        comboBoxModel = new DefaultComboBoxModel();
        comboBox1.setModel(comboBoxModel);

        refreshTable();

        agregarArticuloALaButton.addActionListener(e -> {
            addArtic();
        });

        retrocederButton.addActionListener(e -> {
            this.dispose();
            new Menu().setVisible(true);
        });
    }

    public void addArtic(){
        try{
            var combo = comboBox1.getSelectedItem();
            Integer cant = Integer.valueOf(textField1.getText());

            var id = daoArt.getID(String.valueOf(combo));
            var identifi = id.getId();
            var price = id.getPrecio();
            var total = price * cant;

            tableModel.addRow(new String[]{String.valueOf(identifi), (String) combo, String.valueOf(cant), String.valueOf(total)});
        } catch (Exception exc){
            JOptionPane.showMessageDialog(null,"No ingreso cantidad","ERROR",JOptionPane.ERROR_MESSAGE);
            textField1.setText(null);
            textField1.grabFocus();
        }

    }

    public void refreshTable() {

        List<Articulo> tarjList = daoArt.getAll();

        comboBoxModel.removeAllElements();
        for (int i = tableModel.getRowCount(); i > 0; i--) {
            tableModel.removeRow(i - 1);
        }

        for (Articulo t : tarjList) {
            if (t.getActive()==1){
                comboBoxModel.addElement(t.getNombre());
            }
        }
    }
}
