package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ZaposleniQuery {
    private final SessionFactory sessionFactory;

    public ZaposleniQuery(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Zaposleni> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person", Zaposleni.class);
            return query.list();
        }
    }

    public List<Zaposleni> findByIme(String ime) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE ime = :ime", Zaposleni.class);
            query.setParameter("ime", ime);
            return query.list();
        }
    }

    public List<Zaposleni> findByGodine(int godine) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE godine = :godine", Zaposleni.class);
            query.setParameter("godine", godine);
            return query.list();
        }
    }

    public List<Zaposleni> findByAdresa(String adresa) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE adresa = :adresa", Zaposleni.class);
            query.setParameter("adresa", adresa);
            return query.list();
        }
    }

    public List<Zaposleni> findByPrihod(double prihod) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE prihod = :prihod", Zaposleni.class);
            query.setParameter("prihod", prihod);
            return query.list();
        }
    }
}
