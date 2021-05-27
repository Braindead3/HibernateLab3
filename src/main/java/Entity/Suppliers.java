package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Suppliers")
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique = true,nullable = false)
    private int id;
    public String supplierAddress;

    @OneToMany(mappedBy = "suppliers")
    private Set<Deliveries> product = new HashSet<Deliveries>();

    public Suppliers(){}

    public Suppliers(String supplierAddress)
    {
        this.supplierAddress=supplierAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    @Override
    public String toString() {
        return "Suppliers{" +
                "id=" + id +
                ", supplierAddress='" + supplierAddress + '\'' +
                '}';
    }
}
