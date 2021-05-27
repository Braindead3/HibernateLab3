package Entity;

import DAO.CustomerDao;
import DAO.ProductDao;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;

import javax.persistence.*;

@Entity(name="Sales")
@IdClass(ProductCustomerPK.class)
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int amount;

    @Id
    private int idProduct;

    @Id
    private int idCustomer;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "idProduct",referencedColumnName = "id")
    private Product productSales;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "idCustomer",referencedColumnName = "id")
    private Customer customerSales;

    public Sales(){}

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.customerSales=new CustomerDao().getCustomerById(idCustomer);
        this.idCustomer = idCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.productSales=new ProductDao().getProductById(idProduct);
        this.idProduct = idProduct;
    }

    public Customer getCustomerSales() {
        return customerSales;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setCustomerSales(Customer customerSales) {
        this.customerSales = customerSales;
    }

    public void setProductSales(Product productSales) {
        this.productSales = productSales;
    }

    public Product getProductSales() {
        return productSales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", amount=" + amount +
                ", idProduct=" + idProduct +
                ", idCustomer=" + idCustomer +
                ", productSales=" + productSales +
                ", customerSales=" + customerSales +
                '}';
    }
}
