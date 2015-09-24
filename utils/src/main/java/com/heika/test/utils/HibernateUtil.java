package com.heika.test.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil
{
    private static final SessionFactory ourSessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static
    {
        try
        {
            Configuration configuration = new Configuration();
            configuration.configure();

            serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            ourSessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex)
        {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * ThreadLocal Session Map
     */
    public static final ThreadLocal MAP = new ThreadLocal();

    public static Session currentSession() throws HibernateException
    {
        Session s = (Session) MAP.get();
        // Open a new Session, if this Thread has none yet
        if (s == null)
        {
            s = ourSessionFactory.openSession();
            MAP.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException
    {
        Session s = (Session) MAP.get();
        MAP.set(null);
        if (s != null)
        {
            s.close();
        }
    }
}
