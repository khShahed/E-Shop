package services;

import entities.Category;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryServices 
{
    public void insert(Category c)
    {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        session.save(c);
        
        transaction.commit();
        session.close();
    }
    
    public void update(Category c)
    {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        session.update(c);
        
        transaction.commit();
        session.close();
    }
    
    public void delete(Category c)
    {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        session.delete(c);
        
        transaction.commit();
        session.close();
    }
    
    public Category getById(int id)
    {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        Category c = (Category)session.get(Category.class, id);
        
        transaction.commit();
        session.close();
        return c;
    }
    
    public List<Category> getAll()
    {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        
        List<Category> list = (List<Category>)session.createQuery("from categories").list();
        
        transaction.commit();
        session.close();
        return list;
    }
}
