package DAO;

import Entity.Market;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.List;

public class MarketDao {
    public List<Market> getAllProductsInMarket(){
        return HibernateUtil.getSessionFactory().openSession().createQuery("From Market").list();
    }

    public void save(Market market){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(market);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public void update(Market market){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.update(market);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public void delete(Market market){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(market);
            transaction.commit();
            session.close();
        }
        catch (Exception e){
            System.out.println("Exception:"+e);
        }
    }

    public Market getPositionById(int id){
        return HibernateUtil.getSessionFactory().openSession().get(Market.class,id);
    }
}
