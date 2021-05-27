package Service;

import DAO.CategoryDao;
import Entity.Category;

import java.util.List;
import java.util.Scanner;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();
    Scanner in = new Scanner(System.in);

    public CategoryService(){}

    public void saveCategory(){
        Category category  = new Category();
        System.out.println("Введите название новой категории:");
        category.setCategoryName(in.next());

        categoryDao.save(category);
        System.out.println("Добавление успешно!");
    }

    public void updateCategory(){
        System.out.println("Введите id категории, которую нужно изменить:");
        Category category = categoryDao.getCategoryById(in.nextInt());
        System.out.println("Введите новое имя категории:");
        category.setCategoryName(in.next());

        categoryDao.update(category);
        System.out.println("Сохранение успешно!");
    }

    public void deleteCategory(){
        System.out.println("Введите id категории, которую нужно удалить:");
        Category category = categoryDao.getCategoryById(in.nextInt());

        categoryDao.delete(category);
        System.out.println("Удаление прошло успешно!");
    }

    public List<Category> getAllCategories(){
        return categoryDao.getAllCategories();
    }
}
