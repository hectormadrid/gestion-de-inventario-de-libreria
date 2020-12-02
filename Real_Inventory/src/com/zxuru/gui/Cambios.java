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

public class Cambios extends JFrame {

    private DefaultTableModel tableModel;

    private Conexion myCon;
    private DaoArticulo daoArt;
    private JPanel panel1;
    private JTable table1;
    private JButton refrescarButton;
    private JButton activarArticuloButton;
    private JButton retrocederButton;
    private JButton desactivarArticuloButton;

    public Cambios() {
        super("Cambios a las listas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel1);
        setSize(new Dimension(400, 500));
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
        tableModel.addColumn("Rut_proveedor");
        tableModel.addColumn("Activo");

        refreshTable();

        retrocederButton.addActionListener(e -> {
            this.dispose();
            new Menu().setVisible(true);
        });

        activarArticuloButton.addActionListener(e -> {
            var opt = JOptionPane.showInputDialog("Ingrese ID\nA activar");
            daoArt.activateArt(Integer.parseInt(opt));
            refreshTable();
        });

        desactivarArticuloButton.addActionListener(e -> {
            var opt = JOptionPane.showInputDialog("Ingrese ID\nA activar");
            daoArt.deactivateArt(Integer.parseInt(opt));
            refreshTable();
        });
    }

    public void refreshTable() {
        List<Articulo> tarjList = daoArt.getAll();
        String activo = null;

        for (int i = tableModel.getRowCount(); i > 0; i--) {
            tableModel.removeRow(i - 1);
        }

        for (Articulo t : tarjList) {
            if (t.getActive() == 0)
                activo = "No";
            else if (t.getActive() == 1)
                activo = "Si";
            String[] val = new String[]{String.valueOf(t.getId()), t.getNombre(), String.valueOf(t.getCantidad()), String.valueOf(t.getPrecio()), t.getRut_proveedor(), activo};
            tableModel.addRow(val);
        }
    }
}
