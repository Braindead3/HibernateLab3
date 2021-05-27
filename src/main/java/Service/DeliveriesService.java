package Service;

import DAO.DeliveriesDao;
import DAO.ProductDao;
import DAO.SuppliersDao;
import Entity.Deliveries;
import Entity.Product;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DeliveriesService {
    private DeliveriesDao deliveriesDao = new DeliveriesDao();
    Scanner input = new Scanner(System.in);

    public void saveDelivery() throws ParseException {
        Deliveries deliveries = new Deliveries();

        System.out.println("Введите дату доставки:");
        deliveries.setDeliveryDate((new SimpleDateFormat("yyyy.MM.dd")).parse(input.next()));
        System.out.println("Введите кол-во поставленного товара");
        deliveries.setDeliveryAmount(input.nextInt());
        System.out.println("Введите id поставляемого товара:");
        deliveries.setProduct(new ProductDao().getProductById(input.nextInt()));
        System.out.println("Введите id поставщика:");
        deliveries.setSuppliers(new SuppliersDao().getSupplierById(input.nextInt()));
        deliveriesDao.save(deliveries);
        System.out.println("Сохранение прошло успешно!");
    }

    public void updateDelivery() throws ParseException {
        System.out.println("Введите id");

        Deliveries deliveries = deliveriesDao.getDeliveryById(input.nextInt());

        System.out.println("Введите дату доставки:");
        deliveries.setDeliveryDate((new SimpleDateFormat("yyyy.MM.dd")).parse(input.next()));
        System.out.println("Введите кол-во поставленного товара");
        deliveries.setDeliveryAmount(input.nextInt());
        System.out.println("Введите id поставляемого товара:");
        deliveries.setProduct(new ProductDao().getProductById(input.nextInt()));
        System.out.println("Введите id поставщика:");
        deliveries.setSuppliers(new SuppliersDao().getSupplierById(input.nextInt()));

        deliveriesDao.save(deliveries);

        System.out.println("Изменение прошло успешно!");
    }

    public void deleteDelivery(){
        System.out.println("Введите id");

        deliveriesDao.delete(deliveriesDao.getDeliveryById(input.nextInt()));

        System.out.println("Удаление прошло успешно!");
    }

    public List<Deliveries> getAllDeliveries(){
        return deliveriesDao.getAllDelivers();
    }
}