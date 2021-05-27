package Service;

import DAO.CustomerDao;
import Entity.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerService {

    CustomerDao customerDao = new CustomerDao();
    Scanner input= new Scanner(System.in);

    public void saveCustomer(){
        Customer customer = new Customer();
        System.out.println("Введите имя клиента:");
        customer.setUserLogin(input.next());
        System.out.println("Введите пароль клиента:");
        customer.setUserPassword(input.next());
        System.out.println("Введите Email клиента:");
        customer.setUserEmail(input.next());
        customerDao.save(customer);
        System.out.println("Клиент добавлен успешно!");
    }

    public void updateCustomer(){
        System.out.println("Введите id клиента:");
        Customer customer = customerDao.getCustomerById(input.nextInt());
        System.out.println("Введите имя клиента:");
        customer.setUserLogin(input.next());
        System.out.println("Введите пароль клиента:");
        customer.setUserPassword(input.next());
        System.out.println("Введите Email клиента:");
        customer.setUserEmail(input.next());
        customerDao.update(customer);
        System.out.println("Клиент изменен успешно!");
    }

    public void deleteCustomer(){
        System.out.println("Введите id клиента:");
        Customer customer = customerDao.getCustomerById(input.nextInt());
        customerDao.delete(customer);
        System.out.println("Клиент удалён успешно!");
    }

    public List<Customer> getAllCustomers(){
        return customerDao.getListOfAllCustomers();
    }
}
