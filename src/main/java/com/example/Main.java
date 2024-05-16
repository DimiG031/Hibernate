package com.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Opcija");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        panelOdabira(panel);

        frame.setVisible(true);
    }

    public static void panelOdabira(JPanel panel) {
        JLabel label = new JLabel("Odaberite opciju:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JButton btnApp = new JButton("Aplikacija");
        btnApp.setBounds(10, 50, 150, 25);
        panel.add(btnApp);

        JButton btnHibernate = new JButton("Hibernate");
        btnHibernate.setBounds(10, 80, 150, 25);
        panel.add(btnHibernate);

        btnApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pokreniApp();
            }
        });

        btnHibernate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pokreniHibernate();
            }
        });
    }

    private static void pokreniApp() {
        Konekcija.uspostaviKonekciju();
        Prozor.Prozor();
    }

    private static void pokreniHibernate() {
        HibernateMeni meni = new HibernateMeni();
        meni.setVisible(true);
    }
}


