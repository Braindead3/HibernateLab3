package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Products")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private int id;

    private String productName;

    @ManyToOne
    @JoinColumn(name="idCategory",referencedColumnName ="id")
    private Category category;

    @OneToMany(mappedBy = "productMarket",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Market> market;

    @OneToMany(mappedBy = "product")
    private Set<Deliveries> suppliers = new HashSet<>();

    @OneToMany(mappedBy = "productSales")
    private Set<Sales> customerSales = new HashSet<Sales>();

    public Product(){}

    public Product(String productName){
        this.productName=productName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public List<Market> getMarket() {
        return (List<Market>) market;
    }

    public void setMarket(List<Market> market) {
        this.market = market;
    }

    public Set<Deliveries> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Deliveries> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<Sales> getCustomerSales() {
        return customerSales;
    }

    public void setCustomerSales(Set<Sales> customerSales) {
        this.customerSales = customerSales;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName+
                '}';
    }
}
