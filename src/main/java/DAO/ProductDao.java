package DAO;

import Entity.Customer;
import Entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.List;

public class ProductDao
{
    public void save(Product product) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(product);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Логин и почта уже существуют.");
        }
    }

    public void update(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }

    public List<Product> getListOfAllProducts(){
        List<Product> products = (List<Product>) HibernateUtil.getSessionFactory().openSession().createQuery("From Products",Product.class).getResultList();
        return products;
    }

    public Product getProductById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Product.class,id);
    }
}
