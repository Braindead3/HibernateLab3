package DAO;

import Entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao
{
    public void save(Customer customer) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(customer);
            tx1.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Логин и почта уже существуют.");
        }
    }

    public void update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(customer);
        tx1.commit();
        session.close();
    }

    public void delete(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(customer);
        tx1.commit();
        session.close();
    }

    public List<Customer> getListOfAllCustomers(){
        List<Customer> customers = (List<Customer>) HibernateUtil.getSessionFactory().openSession().createQuery("From Customers",Customer.class).getResultList();
        return customers;
    }

    public Customer getCustomerById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Customer.class,id);
    }
}
