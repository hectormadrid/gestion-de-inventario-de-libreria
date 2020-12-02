package com.zxuru.gui;

import com.zxuru.Conexion;
import com.zxuru.dao.DaoArticulo;
import com.zxuru.dao.DaoCliente;
import com.zxuru.dao.DaoTrabajador;
import com.zxuru.model.Articulo;
import com.zxuru.model.Cliente;
import com.zxuru.model.Trabajador;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class Cambios extends JFrame {

    private DefaultTableModel tableModel;
    private DefaultTableModel tablemodel1;
    private DefaultTableModel tablemodel2;

    private Conexion myCon;
    private DaoArticulo daoArt;
    private DaoCliente daoCliente;
    private DaoTrabajador daoTrabajador;
    private JPanel panel1;
    private JTable table1;
    private JButton refrescarButton;
    private JButton activarArticuloButton;
    private JButton retrocederButton;
    private JButton desactivarArticuloButton;
    private JTabbedPane tabbedPane1;
    private JTable table2;
    private JTable table3;
    private JButton despedirButton;
    private JButton contratarButton;

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
        daoCliente = new DaoCliente(myCon);
        daoTrabajador = new DaoTrabajador(myCon);

        tableModel = new DefaultTableModel();
        table1.setModel(tableModel);

        tableModel.addColumn("ID");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Precio");
        tableModel.addColumn("Rut_proveedor");
        tableModel.addColumn("Activo");

        tablemodel1 = new DefaultTableModel();
        table2.setModel(tablemodel1);

        tablemodel1.addColumn("Rut");
        tablemodel1.addColumn("Nombre");
        tablemodel1.addColumn("Apellido");
        tablemodel1.addColumn("Boleta");

        tablemodel2 = new DefaultTableModel();
        table3.setModel(tablemodel2);

        tablemodel2.addColumn("Rut");
        tablemodel2.addColumn("Nombre");
        tablemodel2.addColumn("Apellido");

        refreshTable();

        retrocederButton.addActionListener(e -> {
            this.dispose();
            new Menu().setVisible(true);
        });

        refrescarButton.addActionListener(e -> {
            refreshTable();
        });

        contratarButton.addActionListener(e -> {
            var rot = JOptionPane.showInputDialog(null, "Ingrese su rut");
            var cant = daoTrabajador.findUser(Integer.parseInt(rot));

            if (cant.getRut().equals("0")) {
                var rut = rot;
                var name = JOptionPane.showInputDialog(null, "Ingrese su nombre");
                var ape = JOptionPane.showInputDialog(null, "Ingrese su apellido");
                var contra = JOptionPane.showInputDialog(null, "Ingrese su contraseña");

                daoTrabajador.contrataWorker(rut, name, ape,contra);

            } else {
                JOptionPane.showMessageDialog(null,"El trabajador ya esta ingresado","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });

        activarArticuloButton.addActionListener(e -> {
            var opt = JOptionPane.showInputDialog("Ingrese ID\nA activar");
            daoArt.activateArt(Integer.parseInt(opt));
            refreshTable();
        });

        desactivarArticuloButton.addActionListener(e -> {
            var opt = JOptionPane.showInputDialog("Ingrese ID\nA desactivar");
            daoArt.deactivateArt(Integer.parseInt(opt));
            refreshTable();
        });

        despedirButton.addActionListener(e -> {
            var opt = JOptionPane.showInputDialog("Ingrese ID de trabajador a funar");
            daoTrabajador.despedirWorker(opt);
            refreshTable();
        });
    }

    public void refreshTable() {
        List<Articulo> tarjList = daoArt.getAll();
        List<Cliente> clienteList = daoCliente.selectCliente();
        List<Trabajador> trabajadorList = daoTrabajador.getWorkers();

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

        for (int i = tablemodel1.getRowCount(); i > 0; i--) {
            tablemodel1.removeRow(i - 1);
        }

        for (Cliente c : clienteList){
            String[] val = new String[]{c.getRut(),c.getNombre(),c.getApellido(), String.valueOf(c.getBoleta())};
            tablemodel1.addRow(val);
        }

        for (int i = tablemodel2.getRowCount(); i > 0; i--) {
            tablemodel2.removeRow(i - 1);
        }

        for (Trabajador c : trabajadorList){
            String[] val = new String[]{c.getRut(),c.getNombre(),c.getApellido()};
            tablemodel2.addRow(val);
        }
    }
}
