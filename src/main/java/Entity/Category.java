package Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "Category")
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private int id;
    private String categoryName;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Product> products;

    public Category(){}

    public Category(String categoryName){
        this.categoryName= categoryName;
    }

    public void addProduct(Product product){
        product.setCategory(this);
        products.add(product);
    }

    public void deleteProduct(Product product){
        products.remove(product);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", products=" + products +
                '}';
    }
}
