package Service;

import DAO.SalesDao;
import Entity.Sales;

import java.util.List;
import java.util.Scanner;

public class SalesService {

    SalesDao salesDao= new SalesDao();
    Scanner input = new Scanner(System.in);

    public List<Sales> getAllSales(){
        return salesDao.getAllSales();
    }

    public void saveSale(){
        Sales sales = new Sales();
        System.out.println("Введите id продукта:");
        sales.setIdProduct(input.nextInt());
        System.out.println("Введите кол-во проданного продукта:");
        sales.setAmount(input.nextInt());
        System.out.println("Введите id покупателя:");
        sales.setIdCustomer(input.nextInt());

        salesDao.save(sales);
        System.out.println("Добавление продажи успешно!");
    }

    public void updateSale(){
        System.out.println("Введите id продажи");
        Sales sales = salesDao.getSaleById(input.nextInt());

        System.out.println("Введите id продукта:");
        sales.setIdProduct(input.nextInt());
        System.out.println("Введите кол-во проданного продукта:");
        sales.setAmount(input.nextInt());
        System.out.println("Введите id покупателя:");
        sales.setIdCustomer(input.nextInt());

        salesDao.update(sales);
        System.out.println("Изменение продажи успешно!");
    }

    public void deleteSale(){
        System.out.println("Введите id продажи");
        Sales sales = salesDao.getSaleById(input.nextInt());

        salesDao.delete(sales);
        System.out.println("Удаление продажи успешно!");
    }
}
