package com.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class ZaposleniDAO {
    private final SessionFactory sessionFactory;

    public ZaposleniDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void sacuvajZaposlenog(Zaposleni zaposlen) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(zaposlen);
            transaction.commit();
        }
    }

    public void izmeniZaposlenog(Zaposleni zaposlen) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(zaposlen);
            transaction.commit();
        }
    }

    public void obrisiZaposlenog(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Zaposleni zaposlen = session.get(Zaposleni.class, id);
            if (zaposlen != null) {
                session.delete(zaposlen);
                transaction.commit();
            }
        }
    }

    public List<Zaposleni> pronadjiZaposlenePoImenu(String ime) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE ime LIKE :ime", Zaposleni.class);
            query.setParameter("ime", "%" + ime + "%");
            return query.getResultList();
        }
    }

    public List<Zaposleni> pronadjiZaposlenePoGodinama(int godine) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE godine = :godine", Zaposleni.class);
            query.setParameter("godine", godine);
            return query.getResultList();
        }

    }

    public List<Zaposleni> pronadjiZaposlenePoAdresi(String adresa) {
        try (Session session = sessionFactory.openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE adresa LIKE :adresa", Zaposleni.class);
            query.setParameter("adresa", "%" + adresa + "%");
            return query.getResultList();
        }
    }

    public List<Zaposleni> pronadjiZaposlenePoPrihodu(double prihod) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Zaposleni> query = session.createQuery("FROM Person WHERE prihod = :prihod", Zaposleni.class);
            query.setParameter("prihod", prihod);
            List<Zaposleni> people = query.getResultList();
            for (Zaposleni person : people) {
                Double prihodIzBaze = person.getPrihod();
                if (prihodIzBaze == null) {
                    person.setPrihod(0.0);
                }
            }
            return people;

    }
}
}
