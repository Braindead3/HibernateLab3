package DAO;

import Entity.Market;
import Entity.Sales;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.List;

public class SalesDao {
    public List<Sales> getAllSales(){
        return HibernateUtil.getSessionFactory().openSession().createQuery("From Sales",Sales.class).getResultList();
    }

    public Sales getSaleById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Sales.class,id);
    }

    public void save(Sales sales){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(sales);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public void update(Sales sales){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(sales);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public void delete(Sales sales){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(sales);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }
}
