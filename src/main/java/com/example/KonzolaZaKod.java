package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class KonzolaZaKod extends JFrame {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private JTextArea textArea;
    private JTextArea inputArea;
    private JScrollPane scrollPane;

    private boolean infoMode = false;
    private String previousText;

    public KonzolaZaKod() {
        setTitle("Konzola za kod");
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        JPanel topPanel = new JPanel(new BorderLayout());
        JButton infoButton = new JButton("Info");
        infoButton.addActionListener(e -> {
            if (!infoMode) {
                previousText = textArea.getText();
                String infoText = "Primeri za unos HQL upita:\n" +
                        "SELECT p FROM Person p WHERE p.adresa = 'Cacak'\n\n" +
                        "Ovaj primer vrsi upit koji trazi sve zaposlene sa adresom 'Cacak'.\n" +
                        "Umesto 'Cacak', mozete koristiti bilo koju vrednost iz vase baze podataka.\n"+
                        "Za upit za ime, godine ili prigod, zameniti sa p.adresa i traziti odgovarajuci podatak.\n" +
                        "Unos novog zaposlenog vrsimo na sledeci nacin:\n " +
                        "INSERT INTO Zaposleni VALUES (ime, godine, adresa, prihod)\n" +
                        "Izmenu podataka vrsimo na sledeci nacin:\n" +
                        "UPDATE Zaposleni SET (Unesite naziv polja podataka koji menjate = novi podatak) WHERE id=(Unesite id)\n" +
                        "Brisanje zaposlenog vrsimo na sledeci nacin:\n" +
                        "DELETE FROM Zaposleni WHERE id = (Unesite id)";
                textArea.setText(infoText);
                infoMode = true;
                infoButton.setText("Nazad");
            } else {
                textArea.setText(previousText);
                infoMode = false;
                infoButton.setText("Info");
            }
        });
        topPanel.add(infoButton, BorderLayout.WEST);

        JButton executeButton = new JButton("Izvrsi");
        executeButton.addActionListener(e -> {

                String input = inputArea.getText();
                if (input.equalsIgnoreCase("exit")) {
                    dispose();
                    return;
                }

                try (Session session = sessionFactory.openSession()) {
                    Transaction transaction = session.beginTransaction();

                    Query query = session.createQuery(input);
                    List<Zaposleni> persons = query.list();

                    for (Zaposleni person : persons) {
                        // Ispis rezultata u JTextArea
                        textArea.append("ID: " + person.getId() + "\n");
                        textArea.append("Ime: " + person.getIme() + "\n");
                        textArea.append("Godine: " + person.getGodine() + "\n");
                        textArea.append("Adresa: " + person.getAdresa() + "\n");
                        textArea.append("Prihod: " + person.getPrihod() + "\n");
                        textArea.append("\n");

                        // Ispis rezultata na standardnom izlazu
                        System.out.println("ID: " + person.getId());
                        System.out.println("Ime: " + person.getIme());
                        System.out.println("Godine: " + person.getGodine());
                        System.out.println("Adresa: " + person.getAdresa());
                        System.out.println("Prihod: " + person.getPrihod());
                        System.out.println();
                    }
                } catch (Exception ex) {
                    textArea.append("Doslo je do greske prilikom izvrsavanja Hibernate koda:\n");
                    textArea.append(ex.getMessage() + "\n");
                }

                inputArea.setText("");
            });

        topPanel.add(executeButton, BorderLayout.CENTER);

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        inputArea = new JTextArea(5, 20);
        JScrollPane inputScrollPane = new JScrollPane(inputArea);
        getContentPane().add(inputScrollPane, BorderLayout.SOUTH);

        textArea.requestFocusInWindow();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        textArea.append("Dobrodosli u konzolu za unos koda Hibernate-a.\n");
        textArea.append("Unesite svoj Hibernate kod u polje ispod:\n");

        inputArea.requestFocusInWindow();

        setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KonzolaZaKod::new);
    }
}
