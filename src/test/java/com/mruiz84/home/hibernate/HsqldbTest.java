package com.mruiz84.home.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class HsqldbTest {

    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        // setup the session factory
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(SuperHero.class);

        // hibernate c3p0 connection pooling configuration
        configuration.setProperty("hibernate.c3p0.acquire_increment", "1");
        configuration.setProperty("hibernate.c3p0.idle_test_period", "100");
        configuration.setProperty("hibernate.c3p0.min_size", "0");
        configuration.setProperty("hibernate.c3p0.max_size", "15");
        configuration.setProperty("hibernate.c3p0.max_statements", "0");
        configuration.setProperty("hibernate.c3p0.timeout", "30");
        configuration.setProperty("hibernate.c3p0.acquireRetryAttempts", "1");
        configuration.setProperty("hibernate.c3p0.acquireRetryDelay", "250");

        // database connection properties
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbc.JDBCDriver");
        configuration.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:testdb");
        configuration.setProperty("hibernate.connection.username", "sa");
        configuration.setProperty("hibernate.connection.password", "");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        configuration.setProperty("hibernate.show_sql","true");

        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    public void testing () {
        SuperHero unknownHero = new SuperHero();
        unknownHero.name = "Name";

        session.beginTransaction();
        session.save(unknownHero);
        session.getTransaction().commit();

        Query query = session.createQuery("from SuperHero");
        List<SuperHero> heroes = query.list();
        Assert.assertEquals(1, heroes.size());

        SuperHero registeredHero = heroes.get(0);
        System.out.print("hero id: " + registeredHero.id);

        Assert.assertEquals("Name", registeredHero.name);
    }

    @After
    public void after() {
        session.close();
        sessionFactory.close();
    }
}


