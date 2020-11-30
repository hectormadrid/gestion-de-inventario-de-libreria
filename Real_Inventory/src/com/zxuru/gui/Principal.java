package com.zxuru.gui;

import com.zxuru.model.Trabajador;

import javax.swing.*;
import java.awt.*;

public class Principal extends JFrame {
    private LogIn log;
    private Trabajador trab;
    private JPanel panel1;
    private JList list1;

    private DefaultListModel listModel;

    public Principal(LogIn logi, Trabajador trab){
        super("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add();
        setSize(new Dimension(400,500));
        pack();
        log = logi;
        this.trab = trab;

        listModel = new DefaultListModel();
        list1.setModel(listModel);


    }

    public void refreshTable(){
        listModel.removeAllElements();


    }
}
