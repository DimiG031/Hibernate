package com.example;
import javax.swing.*;
import java.sql.*;

public class OperacijeApp {

    public static void prikaziRezultate(JLabel lblRezultat) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM zaposleni");

            StringBuilder rezultat = new StringBuilder();
            while (rs.next()) {
                rezultat.append("ID: ").append(rs.getInt("id"))
                        .append("Ime: ").append(rs.getString("ime"))
                        .append(", Godine: ").append(rs.getInt("godine"))
                        .append(", Adresa: ").append(rs.getString("adresa"))
                        .append(", Prihod: ").append(rs.getDouble("prihod"))
                        .append("<br>").append("\n");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
            System.out.println(rezultat);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void unosPodataka(String ime, int godine, String adresa, Double prihod) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO zaposleni (ime, godine, adresa, prihod) VALUES (?, ?, ?, ?)");
            pst.setString(1, ime);
            pst.setInt(2, godine);
            pst.setString(3, adresa);
            pst.setDouble(4, prihod);
            pst.executeUpdate();
            System.out.println("Uspesno ste dodali podatke");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void izmenaPodataka(int id, String novoIme, int noveGodine, String novaAdresa, Double noviPrihod) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("UPDATE zaposleni SET ime=?, godine=?, adresa=? , prihod=? WHERE id=?");
            pst.setString(1, novoIme);
            pst.setInt(2, noveGodine);
            pst.setString(3, novaAdresa);
            pst.setDouble(4, noviPrihod);
            pst.setInt(5, id);
            pst.executeUpdate();
            System.out.println("Uspesno ste izmenili podatke");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void brisanjePodataka(int id) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("DELETE FROM zaposleni WHERE id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoId(JLabel lblRezultat, int id) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM zaposleni WHERE id = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            StringBuilder rezultat = new StringBuilder();
            while (rs.next()) {
                rezultat.append("ID: ").append(rs.getInt("id"))
                        .append(", Ime: ").append(rs.getString("ime"))
                        .append(", Godine: ").append(rs.getInt("godine"))
                        .append(", Adresa: ").append(rs.getString("adresa"))
                        .append(", Prihod: ").append(rs.getDouble("prihod"))
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoImenu(JLabel lblRezultat, String ime) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM zaposleni WHERE ime LIKE ?");
            pst.setString(1, "%" + ime + "%"); // Pretraga po delu imena
            ResultSet rs = pst.executeQuery();
            StringBuilder rezultat = new StringBuilder();
            while (rs.next()) {
                rezultat.append("ID: ").append(rs.getInt("id"))
                        .append(", Ime: ").append(rs.getString("ime"))
                        .append(", Godine: ").append(rs.getInt("godine"))
                        .append(", Adresa: ").append(rs.getString("adresa"))
                        .append(", Prihod: ").append(rs.getDouble("prihod"))
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoGodinama(JLabel lblRezultat, int godine) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM zaposleni WHERE godine = ?");
            pst.setInt(1, godine);
            ResultSet rs = pst.executeQuery();
            StringBuilder rezultat = new StringBuilder();
            while (rs.next()) {
                rezultat.append("ID: ").append(rs.getInt("id"))
                        .append(", Ime: ").append(rs.getString("ime"))
                        .append(", Godine: ").append(rs.getInt("godine"))
                        .append(", Adresa: ").append(rs.getString("adresa"))
                        .append(", Prihod: ").append(rs.getDouble("prihod"))
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoAdresi(JLabel lblRezultat, String adresa) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM zaposleni WHERE adresa LIKE ?");
            pst.setString(1, "%" + adresa + "%"); // Pretraga po delu adrese
            ResultSet rs = pst.executeQuery();
            StringBuilder rezultat = new StringBuilder();
            while (rs.next()) {
                rezultat.append("ID: ").append(rs.getInt("id"))
                        .append(", Ime: ").append(rs.getString("ime"))
                        .append(", Godine: ").append(rs.getInt("godine"))
                        .append(", Adresa: ").append(rs.getString("adresa"))
                        .append(", Prihod: ").append(rs.getDouble("prihod"))
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void prikaziRezultatePoPrihodu(JLabel lblRezultat, double prihod) {
        try (Connection conn = Konekcija.uspostaviKonekciju()) {
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM zaposleni WHERE prihod = ?");
            pst.setDouble(1, prihod);
            ResultSet rs = pst.executeQuery();
            StringBuilder rezultat = new StringBuilder();
            while (rs.next()) {
                rezultat.append("ID: ").append(rs.getInt("id"))
                        .append(", Ime: ").append(rs.getString("ime"))
                        .append(", Godine: ").append(rs.getInt("godine"))
                        .append(", Adresa: ").append(rs.getString("adresa"))
                        .append(", Prihod: ").append(rs.getDouble("prihod"))
                        .append("<br>");
            }
            lblRezultat.setText("<html>" + rezultat.toString() + "</html>");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

