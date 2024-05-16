package com.example;
import javax.swing.*;


public class HibernateMeni extends JFrame {
    public HibernateMeni() {
        setTitle("Hibernate Meni");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(300, 300);


        JButton btnKonzolnaApp = new JButton("Konzolna aplikacija");
        btnKonzolnaApp.setBounds(50, 10, 200, 30);
        JButton btnGUI = new JButton("GUI");
        btnGUI.setBounds(50, 50, 200, 30);
        JButton btnKonzolaZaKod = new JButton("Konzola za unos koda");
        btnKonzolaZaKod.setBounds(50, 90, 200, 30);

        btnKonzolnaApp.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Izabrali ste konzolnu aplikaciju");
            new KonzolnaAppHibernate();
        });

        btnGUI.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Izabrali ste GUI");
            new HibernateGUI();
        });

        btnKonzolaZaKod.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Izabrali ste konzolu za unos koda");
            pokreniKonzoluZaKod();
        });

        panel.add(btnKonzolnaApp);
        panel.add(btnGUI);
        panel.add(btnKonzolaZaKod);

        add(panel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HibernateMeni meni = new HibernateMeni();
            meni.setVisible(true);
        });
    }

    private void pokreniKonzoluZaKod() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Konzola za unos koda Hibernate-a");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 300);

            KonzolaZaKod konzola = new KonzolaZaKod();
            frame.add(konzola);

            frame.setVisible(true);
        });
    }
}
