package Service;

import DAO.CategoryDao;
import DAO.ProductDao;
import Entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductService {
    ProductDao productDao = new ProductDao();
    Scanner input = new Scanner(System.in);

    public void saveProduct(){
        Product product = new Product();
        System.out.println("Введите название продукта:");
        product.setProductName(input.next());
        System.out.println("Введите id категории");
        product.setCategory(new CategoryDao().getCategoryById(input.nextInt()));

        productDao.save(product);
        System.out.println("Продукт добавлен успешно!");
    }

    public void updateProduct(){
        System.out.println("Введите id продукта");
        Product product = productDao.getProductById(input.nextInt());

        System.out.println("Введите название продукта:");
        product.setProductName(input.next());
        System.out.println("Введите id категории");
        product.setCategory(new CategoryDao().getCategoryById(input.nextInt()));

        productDao.update(product);
        System.out.println("Продукт изменён успешно!");
    }

    public void deleteProduct(){
        System.out.println("Введите id продукта");
        Product product = productDao.getProductById(input.nextInt());

        productDao.delete(product);
        System.out.println("Продукт удалён успешно!");
    }

    public List<Product> getAllProducts(){
        return productDao.getListOfAllProducts();
    }
}
