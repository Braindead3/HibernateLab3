package DAO;

import Entity.Deliveries;
import Entity.Market;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistence.HibernateUtil;

import java.util.List;

public class DeliveriesDao {
        public List<Deliveries> getAllDelivers(){
            return HibernateUtil.getSessionFactory().openSession().createQuery("From Deliveries").list();
        }

        public void save(Deliveries deliveries){
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                session.save(deliveries);
                transaction.commit();
                session.close();
            }
            catch (Exception e){
                System.out.println("Exception:"+e);
            }
        }

        public void update(Deliveries deliveries){
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                session.update(deliveries);
                transaction.commit();
                session.close();
            }
            catch (Exception e){
                System.out.println("Exception:"+e);
            }
        }

        public void delete(Deliveries deliveries){
            try{
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();
                session.delete(deliveries);
                transaction.commit();
                session.close();
            }
            catch (Exception e){
                System.out.println("Exception:"+e);
            }
        }

        public Deliveries getDeliveryById(int id){
            return HibernateUtil.getSessionFactory().openSession().get(Deliveries.class,id);
        }
}
