package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.*;
import java.util.List;

public class Operacije {

    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void prikaziRezultate(JLabel lblRezultat) {
        try (Session session = sessionFactory.openSession()) {
            List<Zaposleni> zaposleni = session.createQuery("FROM Zaposleni").list();
            StringBuilder rezultat = new StringBuilder();
            for (Zaposleni zaposlen : zaposleni) {
                rezultat.append("ID: ").append(zaposlen.getId())
                        .append(", Ime: ").append(zaposlen.getIme())
                        .append(", Godine: ").append(zaposlen.getGodine())
                        .append(", Adresa: ").append(zaposlen.getAdresa())
                        .append(", Prihod: ").append(zaposlen.getPrihod())
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void unosPodataka(String ime, int godine, String adresa, Double prihod) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Zaposleni zaposlen = new Zaposleni();
            zaposlen.setIme(ime);
            zaposlen.setGodine(godine);
            zaposlen.setAdresa(adresa);
            zaposlen.setPrihod(prihod);
            session.save(zaposlen);
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void izmenaPodataka(int id, String novoIme, int noveGodine, String novaAdresa, Double noviPrihod) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Zaposleni zaposlen = session.get(Zaposleni.class, id);
            if (zaposlen != null) {
                zaposlen.setIme(novoIme);
                zaposlen.setGodine(noveGodine);
                zaposlen.setAdresa(novaAdresa);
                zaposlen.setPrihod(noviPrihod);
                session.update(zaposlen);
                transaction.commit();
            } else {
                System.out.println("Nije pronadjen zaposleni sa datim ID-jem.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void brisanjePodataka(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Zaposleni person = session.get(Zaposleni.class, id);
            if (person != null) {
                session.delete(person);
                transaction.commit();
            } else {
                System.out.println("Nije pronađen zaposleni sa datim ID-jem.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoId(JLabel lblRezultat, int id) {
        try (Session session = sessionFactory.openSession()) {
            Zaposleni person = session.get(Zaposleni.class, id);
            if (person != null) {
                StringBuilder rezultat = new StringBuilder();
                rezultat.append("ID: ").append(person.getId())
                        .append(", Ime: ").append(person.getIme())
                        .append(", Godine: ").append(person.getGodine())
                        .append(", Adresa: ").append(person.getAdresa())
                        .append(", Prihod: ").append(person.getPrihod())
                        .append("<br>");
                lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
            } else {
                lblRezultat.setText("Nije pronađen zaposleni sa datim ID-jem.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoImenu(JLabel lblRezultat, String ime) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE ime LIKE :ime", Zaposleni.class);
            query.setParameter("ime", "%" + ime + "%");
            List<Zaposleni> zaposleni = query.list();
            StringBuilder rezultat = new StringBuilder();
            for (Zaposleni zaposlen : zaposleni) {
                rezultat.append("ID: ").append(zaposlen.getId())
                        .append(", Ime: ").append(zaposlen.getIme())
                        .append(", Godine: ").append(zaposlen.getGodine())
                        .append(", Adresa: ").append(zaposlen.getAdresa())
                        .append(", Prihod: ").append(zaposlen.getPrihod())
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoGodinama(JLabel lblRezultat, int godine) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE godine = :godine", Zaposleni.class);
            query.setParameter("godine", godine);
            List<Zaposleni> zaposleni = query.list();
            StringBuilder rezultat = new StringBuilder();
            for (Zaposleni zaposlen : zaposleni) {
                rezultat.append("ID: ").append(zaposlen.getId())
                        .append(", Ime: ").append(zaposlen.getIme())
                        .append(", Godine: ").append(zaposlen.getGodine())
                        .append(", Adresa: ").append(zaposlen.getAdresa())
                        .append(", Prihod: ").append(zaposlen.getPrihod())
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoAdresi(JLabel lblRezultat, String adresa) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE adresa LIKE :adresa", Zaposleni.class);
            query.setParameter("adresa", "%" + adresa + "%");
            List<Zaposleni> zaposleni = query.list();
            StringBuilder rezultat = new StringBuilder();
            for (Zaposleni zaposlen : zaposleni) {
                rezultat.append("ID: ").append(zaposlen.getId())
                        .append(", Ime: ").append(zaposlen.getIme())
                        .append(", Godine: ").append(zaposlen.getGodine())
                        .append(", Adresa: ").append(zaposlen.getAdresa())
                        .append(", Prihod: ").append(zaposlen.getPrihod())
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoPrihodu(JLabel lblRezultat, Double prihod) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE prihod = :prihod", Zaposleni.class);
            query.setParameter("prihod", prihod);
            List<Zaposleni> zaposleni = query.list();
            StringBuilder rezultat = new StringBuilder();
            for (Zaposleni zaposlen : zaposleni) {
                rezultat.append("ID: ").append(zaposlen.getId())
                        .append(", Ime: ").append(zaposlen.getIme())
                        .append(", Godine: ").append(zaposlen.getGodine())
                        .append(", Adresa: ").append(zaposlen.getAdresa())
                        .append(", Prihod: ").append(zaposlen.getPrihod())
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
