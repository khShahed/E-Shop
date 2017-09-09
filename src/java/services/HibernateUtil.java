package services;

import entities.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    
    private static SessionFactory getSessionFactory()
    {
        if(sessionFactory == null){
            sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Category.class)
                .buildSessionFactory();
        }
        return sessionFactory;
    }
    
    public static Session getSession()
    {
        return getSessionFactory().openSession();
    }
}
