package com.example;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.text.Document;
import java.awt.*;


public class Prozor {
    public static void prikaziRezultate(JLabel lblRezultat){
        OperacijeApp.prikaziRezultate(lblRezultat);
    }
    public static void Prozor() {
        JFrame frame = new JFrame("Prozor");
        frame.setLayout(null);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        panel.setSize(800, 800);

        JLabel lblIme = new JLabel("Ime:");
        lblIme.setBounds(10, 10, 150, 50);
        JLabel lblGodine = new JLabel("Godine:");
        lblGodine.setBounds(10, 70, 150, 50);
        JLabel lblAdresa = new JLabel("Adresa:");
        lblAdresa.setBounds(10, 130, 150, 50);
        JLabel lblPrihod = new JLabel("Prihod:");
        lblPrihod.setBounds(10, 190, 150, 50);
        JLabel lblFiltriranje = new JLabel("Filtriranje");
        lblFiltriranje.setBounds(10, 250, 150, 50);
        JTextField tfIme = new JTextField();
        tfIme.setBounds(200, 10, 150, 50);
        JTextField tfGodine = new JTextField();
        tfGodine.setBounds(200, 70, 150, 50);
        JTextField tfAdresa = new JTextField();
        tfAdresa.setBounds(200, 130, 150, 50);
        JTextField tfPrihod = new JTextField();
        tfPrihod.setBounds(200, 190, 150, 50);
        JTextField tfKriterijum = new JTextField("Unesite podatak");
        tfKriterijum.setBounds(210, 260, 150, 30);
        JButton btnPregled = new JButton("Pregled zaposlenog");
        btnPregled.setBounds(370, 10, 150, 30);
        JButton btnUnos = new JButton("Unos zaposlenog");
        btnUnos.setBounds(370, 70, 150, 30);
        JButton btnIzmena = new JButton("Izmena zaposlenog");
        btnIzmena.setBounds(370, 130, 150, 30);
        JButton btnBrisanje = new JButton("Brisanje zaposlenog");
        btnBrisanje.setBounds(370, 190, 150, 30);
        JLabel lblRezultat = new JLabel();
        lblRezultat.setBackground(Color.GRAY);
        lblRezultat.setBounds(10, 210, 400, 400);
        lblRezultat.setSize(400, 400);
        JTextField tfId = new JTextField("unesite ID");
        tfId.setBounds(540, 190, 80, 30);
        tfId.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                tfId.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });

        FocusListener textFieldsFocusListener = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getSource();
                source.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        };

        tfIme.addFocusListener(textFieldsFocusListener);
        tfGodine.addFocusListener(textFieldsFocusListener);
        tfAdresa.addFocusListener(textFieldsFocusListener);
        tfPrihod.addFocusListener(textFieldsFocusListener);
        tfKriterijum.addFocusListener(textFieldsFocusListener);

        final JLabel finalLbRezultat = lblRezultat;
        btnPregled.addActionListener(e -> {
            Prozor.prikaziRezultate(finalLbRezultat);
        });

        btnUnos.addActionListener(e -> {
            String ime = tfIme.getText();
            int godine = Integer.parseInt(tfGodine.getText());
            String adresa = tfAdresa.getText();
            Double prihod = Double.parseDouble(tfPrihod.getText());
            OperacijeApp.unosPodataka(ime, godine, adresa, prihod);
        });

        btnBrisanje.addActionListener(e -> {
            int id = Integer.parseInt(tfId.getText());
            OperacijeApp.brisanjePodataka(id);
        });

        btnIzmena.addActionListener(e -> {
            int id = Integer.parseInt(tfId.getText());
            String novoIme = tfIme.getText();
            int noveGodine = Integer.parseInt(tfGodine.getText());
            String novaAdresa = tfAdresa.getText();
            Double noviPrihod = Double.parseDouble(tfPrihod.getText());
            OperacijeApp.izmenaPodataka(id, novoIme, noveGodine, novaAdresa, noviPrihod);
        });

        JComboBox jcbFilter = new JComboBox();
        jcbFilter.addItem("id");
        jcbFilter.addItem("ime");
        jcbFilter.addItem("godine");
        jcbFilter.addItem("adresa");
        jcbFilter.addItem("prihod");

        jcbFilter.setBounds(100, 260, 100, 30);
        jcbFilter.addActionListener(e -> {
            String selectionOption = (String) jcbFilter.getSelectedItem();
            switch (selectionOption) {
                case "id":
                    tfKriterijum.setDocument(new IntegerDocument());
                    break;
                case "ime":
                case "godine":
                    tfKriterijum.setDocument(new IntegerDocument());
                    break;
                case "adresa":
                    tfKriterijum.setDocument(new TextDocument());
                    break;
                case "prihod":
                    tfKriterijum.setDocument(new DoubleDocument());
                    break;
            }
        });

        Document doc = new TextDocument();
        tfKriterijum.setDocument(doc);

        JButton btnPretraga = new JButton("Pretraga");
        btnPretraga.setBounds(380, 260, 150, 30);

        btnPretraga.addActionListener(e -> {
            String selectionOption = (String) jcbFilter.getSelectedItem();
            String kriterijum = tfKriterijum.getText().trim();
            switch (selectionOption) {
                case "id":
                    try {
                        int id = Integer.parseInt(kriterijum);
                        OperacijeApp.prikaziRezultatePoId(lblRezultat, id);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "ID mora biti ceo broj.", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "ime":
                    String ime = tfKriterijum.getText();
                    OperacijeApp.prikaziRezultatePoImenu(lblRezultat, ime);
                    break;
                case "godine":
                    try {
                        int godine = Integer.parseInt(kriterijum);
                        OperacijeApp.prikaziRezultatePoGodinama(lblRezultat, godine);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Godine moraju biti ceo broj.", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "adresa":
                    OperacijeApp.prikaziRezultatePoAdresi(lblRezultat, kriterijum);
                    break;
                case "prihod":
                    try {
                        Double prihod = Double.parseDouble(kriterijum);
                        OperacijeApp.prikaziRezultatePoPrihodu(lblRezultat, prihod);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Prihod mora biti broj.", "Greska", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        });

            JTextField textField = new JTextField(25);
            JButton btnInfo = new JButton("Info");
            btnInfo.setBounds(540, 150, 70, 30);
            btnInfo.setToolTipText("Informacija o unosu ID-a");
            btnInfo.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                    "Unesite ID zaposlenog za brisanje ili izmenu podataka.", "Informacija",
                    JOptionPane.INFORMATION_MESSAGE));

        JButton btnIzlaz = new JButton("Izlaz");
        btnIzlaz.setBounds(650,650,70,30);
        btnIzlaz.addActionListener(e -> System.exit(0));



        panel.add(lblIme);
        panel.add(tfIme);
        panel.add(lblGodine);
        panel.add(tfGodine);
        panel.add(lblAdresa);
        panel.add(tfAdresa);
        panel.add(lblPrihod);
        panel.add(tfPrihod);
        panel.add(lblFiltriranje);
        panel.add(tfKriterijum);
        panel.add(btnPregled);
        panel.add(btnUnos);
        panel.add(btnIzmena);
        panel.add(btnBrisanje);
        panel.add(lblRezultat);
        panel.add(tfId);
        panel.add(jcbFilter);
        panel.add(btnPretraga);
        panel.add(textField);
        panel.add(btnInfo);
        panel.add(btnIzlaz);

        frame.add(panel);
        frame.setVisible(true);
    }

}
