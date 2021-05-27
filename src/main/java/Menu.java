import Entity.*;
import Service.*;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void start() throws ParseException {
        Scanner in = new Scanner(System.in);
        boolean mainMenu = true;
        while (mainMenu) {
            System.out.println("Выбирите таблицу:");
            System.out.println("""
                    1.Category
                    2.Customers
                    3.Deliveries
                    4.Market
                    5.Products
                    6.Sales
                    7.Suppliers""");
            int mainSw = in.nextInt();
            switch (mainSw) {
                case 1: {
                    CategoryService categoryService = new CategoryService();
                    boolean categoryMenu = true;
                    while (categoryMenu) {
                        printActions();
                        int categorySw = in.nextInt();
                        switch (categorySw) {
                            case 1: {
                                categoryService.saveCategory();
                                break;
                            }

                            case 2: {
                                categoryService.updateCategory();
                                break;
                            }

                            case 3: {
                                categoryService.deleteCategory();
                                break;
                            }

                            case 4: {
                                List<Category> categories = categoryService.getAllCategories();
                                for (Category category : categories) {
                                    System.out.println(category);
                                }
                                break;
                            }

                            case 5: {
                                categoryMenu = false;
                                break;
                            }
                        }
                    }
                }
                break;
                case 2: {
                    CustomerService customerService = new CustomerService();
                    boolean customerMenu = true;
                    while (customerMenu) {
                        printActions();
                        int categorySw = in.nextInt();
                        switch (categorySw) {
                            case 1: {
                                customerService.saveCustomer();
                                break;
                            }

                            case 2: {
                                customerService.updateCustomer();
                                break;
                            }

                            case 3: {
                                customerService.deleteCustomer();
                                break;
                            }

                            case 4: {
                                List<Customer> customers = customerService.getAllCustomers();
                                for (Customer customer : customers) {
                                    System.out.println(customer);
                                }
                                break;
                            }

                            case 5: {
                                customerMenu = false;
                                break;
                            }
                        }
                    }
                }
                break;
                case 3: {
                    DeliveriesService deliveriesService = new DeliveriesService();
                    boolean delMenu = true;
                    while (delMenu) {
                        printActions();
                        int categorySw = in.nextInt();
                        switch (categorySw) {
                            case 1: {
                                deliveriesService.saveDelivery();
                                break;
                            }

                            case 2: {
                                deliveriesService.updateDelivery();
                                break;
                            }

                            case 3: {
                                deliveriesService.deleteDelivery();
                                break;
                            }

                            case 4: {
                                List<Deliveries> customers = deliveriesService.getAllDeliveries();
                                for (Deliveries customer : customers) {
                                    System.out.println(customer);
                                }
                                break;
                            }

                            case 5: {
                                delMenu = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 4:{
                    MarketService marketService = new MarketService();
                    boolean sideMenu = true;
                    while (sideMenu) {
                        printActions();
                        int categorySw = in.nextInt();
                        switch (categorySw) {
                            case 1: {
                                marketService.savePosition();
                                break;
                            }

                            case 2: {
                                marketService.updatePosition();
                                break;
                            }

                            case 3: {
                                marketService.deletePosition();
                                break;
                            }

                            case 4: {
                                List<Market> customers = marketService.getAllPositions();
                                for (Market customer : customers) {
                                    System.out.println(customer);
                                }
                                break;
                            }

                            case 5: {
                                sideMenu = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 5:{
                    ProductService productService = new ProductService();
                    boolean sideMenu = true;
                    while (sideMenu) {
                        printActions();
                        int categorySw = in.nextInt();
                        switch (categorySw) {
                            case 1: {
                                productService.saveProduct();
                                break;
                            }

                            case 2: {
                                productService.updateProduct();
                                break;
                            }

                            case 3: {
                                productService.deleteProduct();
                                break;
                            }

                            case 4: {
                                List<Product> customers = productService.getAllProducts();
                                for (Product customer : customers) {
                                    System.out.println(customer);
                                }
                                break;
                            }

                            case 5: {
                                sideMenu = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 6:{
                    SalesService salesService = new SalesService();
                    boolean sideMenu = true;
                    while (sideMenu) {
                        printActions();
                        int categorySw = in.nextInt();
                        switch (categorySw) {
                            case 1: {
                                salesService.saveSale();
                                break;
                            }

                            case 2: {
                                salesService.updateSale();
                                break;
                            }

                            case 3: {
                                salesService.deleteSale();
                                break;
                            }

                            case 4: {
                                List<Sales> customers = salesService.getAllSales();
                                for (Sales customer : customers) {
                                    System.out.println(customer);
                                }
                                break;
                            }

                            case 5: {
                                sideMenu = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                case 7:{
                    SuppliersService suppliersService = new SuppliersService();
                    boolean sideMenu = true;
                    while (sideMenu) {
                        printActions();
                        int categorySw = in.nextInt();
                        switch (categorySw) {
                            case 1: {
                                suppliersService.saveSupplier();
                                break;
                            }

                            case 2: {
                                suppliersService.updateSupplier();
                                break;
                            }

                            case 3: {
                                suppliersService.deleteSupplier();
                                break;
                            }

                            case 4: {
                                List<Suppliers> customers = suppliersService.getAllSuppliers();
                                for (Suppliers customer : customers) {
                                    System.out.println(customer);
                                }
                                break;
                            }

                            case 5: {
                                sideMenu = false;
                                break;
                            }
                        }
                    }
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + mainSw);
            }
        }
    }


    private void printActions(){
        System.out.println("""
                1.Добавить
                2.Изменить
                3.Удалить
                4.Посмотреть таблицу
                5.Вернуться""");
    }
}
