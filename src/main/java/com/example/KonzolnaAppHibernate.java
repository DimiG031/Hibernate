package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class KonzolnaAppHibernate {
        public static void main(String[] args) {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                SessionFactory sessionFactory = configuration.buildSessionFactory();
                Session session = sessionFactory.openSession();
                session.beginTransaction();

                Zaposleni person = new Zaposleni();
                person.setIme("John");
                person.setGodine(30);
                person.setAdresa("123 Main St");
                person.setPrihod(50000.0);

                session.save(person);
                session.getTransaction().commit();

                session.close();
                sessionFactory.close();
        }
}
