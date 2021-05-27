package DAO;

import Entity.Sales;
import Entity.Suppliers;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.List;

public class SuppliersDao {
    public List<Suppliers> getAllSuppliers(){
        return HibernateUtil.getSessionFactory().openSession().createQuery("From Suppliers", Suppliers.class).getResultList();
    }

    public void save(Suppliers suppliers){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(suppliers);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public void update(Suppliers suppliers){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(suppliers);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public void delete(Suppliers suppliers){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(suppliers);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public Suppliers getSupplierById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Suppliers.class,id);
    }
}
