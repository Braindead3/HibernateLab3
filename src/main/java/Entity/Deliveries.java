package Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name="Deliveries")
@IdClass(ProductSupplierPK.class)
public class Deliveries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private int id;
    private Date deliveryDate = new Date();
    private int deliveryAmount;


    @Id
    private int idProduct;
    @Id
    private int idSupplier;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="idSupplier",referencedColumnName = "id")
    private Suppliers suppliers;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="idProduct",referencedColumnName = "id")
    private Product product;

    public Deliveries() {
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryAmount(int deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getDeliveryAmount() {
        return deliveryAmount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        this.setIdProduct(product.getId());
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
        this.setIdSupplier(suppliers.getId());
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Deliveries{" +
                "id=" + id +
                ", deliveryDate=" + deliveryDate +
                ", deliveryAmount=" + deliveryAmount +
                ", suppliers=" + suppliers +
                ", product=" + product +
                '}';
    }
}
