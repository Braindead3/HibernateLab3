package Entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductCustomerPK implements Serializable {

    @Column(name="idProduct")
    private int idProduct;

    @Column(name="idCustomer")
    private int idCustomer;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCustomerPK that = (ProductCustomerPK) o;
        return idProduct == that.idProduct && idCustomer == that.idCustomer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idCustomer);
    }
}
