package Entity;

import org.hibernate.annotations.CollectionId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductSupplierPK implements Serializable {

    @Column(name="idProduct")
    private int idProduct;

    @Column(name = "idSupplier")
    private int idSupplier;

    public int getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(int idSupplier) {
        this.idSupplier = idSupplier;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductSupplierPK that = (ProductSupplierPK) o;
        return idProduct == that.idProduct && idSupplier == that.idSupplier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, idSupplier);
    }
}
