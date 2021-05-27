package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Customers")
public class Customer
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private int id;
    private String userLogin;
    private String userPassword;
    private String userEmail;

    @OneToMany(mappedBy = "customerSales")
    private Set<Sales> productSales = new HashSet<Sales>();

    public Customer(){}

    public Customer(String userLogin, String userPassword, String userEmail){
        this.userLogin=userLogin;
        this.userPassword= userPassword;
        this.userEmail=userEmail;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Set<Sales> getProductSales() {
        return productSales;
    }

    public void setProductSales(Set<Sales> productSales) {
        this.productSales = productSales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
