package DAO;

import Entity.Category;
import Entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CategoryDao {
    public List<Category> getAllCategories() {
        List<Category> categories = HibernateUtil.getSessionFactory().openSession().createQuery("From Category", Category.class).list();
        return categories;
    }

    public void save(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(category);
        tx1.commit();
        session.close();
    }

    public void update(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(category);
        transaction.commit();
        session.close();
    }

    public void delete(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(category);
        transaction.commit();
        session.close();
    }

    public Category getCategoryById(int id) {
        return HibernateUtil.getSessionFactory().openSession().get(Category.class, id);
    }

    public List<Product> getAllProducts() {
        return HibernateUtil.getSessionFactory().openSession().createQuery("From Category").list();
    }


}
