package com.zxuru.gui;

import com.zxuru.model.Trabajador;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
    private JPanel panel1;
    private JPanel pnlPrin;
    private JButton listaProductosButton;
    private JButton cambiarProductosButton;

    public  Menu(){
        super("");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        add(panel1);
        setSize(new Dimension(400,500));
        pack();

        listaProductosButton.addActionListener(e -> {
            this.dispose();
            SwingUtilities.invokeLater(() -> new Principal());
        });
        cambiarProductosButton.addActionListener(e -> {
            this.dispose();
            SwingUtilities.invokeLater(() -> new Cambios());
        });
    }


}
