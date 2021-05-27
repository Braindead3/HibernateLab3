package Service;

import DAO.SuppliersDao;
import Entity.Suppliers;

import java.security.PublicKey;
import java.util.List;
import java.util.Scanner;

public class SuppliersService {
    SuppliersDao suppliersDao = new SuppliersDao();
    Scanner input = new Scanner(System.in);

    public List<Suppliers> getAllSuppliers(){
        return suppliersDao.getAllSuppliers();
    }

    public void saveSupplier(){
        Suppliers suppliers = new Suppliers();

        System.out.println("Введите адрес поставщика");
        suppliers.setSupplierAddress(input.next());

        suppliersDao.save(suppliers);
        System.out.println("Добавление прошло успешно!");
    }

    public void updateSupplier(){
        System.out.println("Введите id поставщика");
        Suppliers suppliers = suppliersDao.getSupplierById(input.nextInt());

        suppliersDao.update(suppliers);
        System.out.println("Изменение прошло успешно!");
    }

    public void deleteSupplier(){
        System.out.println("Введите id поставщика");
        Suppliers suppliers = suppliersDao.getSupplierById(input.nextInt());

        suppliersDao.delete(suppliers);
        System.out.println("Удаление прошло успешно!");
    }
}
