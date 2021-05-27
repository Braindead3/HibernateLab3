package Entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Market")
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",unique = true,nullable = false)
    private int id;

    private int marketAmount;

    @ManyToOne
    @JoinColumn(name="idProduct")
    private Product productMarket;

    public Market(){}

    public Market(int marketAmount){
        this.marketAmount=marketAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMarketAmount() {
        return marketAmount;
    }

    public void setMarketAmount(int marketAmount) {
        this.marketAmount = marketAmount;
    }

    public Product getProduct() {
        return productMarket;
    }

    public void setProduct(Product product) {
        this.productMarket=product;
    }

    @Override
    public String toString() {
        return "Market{" +
                "id=" + id +
                ", marketAmount=" + marketAmount +
                ", product=" + productMarket +
                '}';
    }
}
