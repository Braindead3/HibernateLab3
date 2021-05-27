package Service;

import DAO.MarketDao;
import DAO.ProductDao;
import Entity.Market;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Scanner;

public class MarketService {
    MarketDao marketDao = new MarketDao();
    Scanner input= new Scanner(System.in);

    public List<Market> getAllPositions(){
        return marketDao.getAllProductsInMarket();
    }

    public void savePosition(){
        Market market = new Market();
        System.out.println("Введите id продукта на продажу");
        market.setProduct(new ProductDao().getProductById(input.nextInt()));
        System.out.println("Введите кол-во продуктов, поставленных в магазин:");
        market.setMarketAmount(input.nextInt());

        marketDao.save(market);

        System.out.println("Позиция добавлена упешно!");
    }

    public void updatePosition(){
        System.out.println("Введите id");
        Market market = marketDao.getPositionById(input.nextInt());

        System.out.println("Введите id продукта на продажу");
        market.setProduct(new ProductDao().getProductById(input.nextInt()));
        System.out.println("Введите кол-во продуктов, поставленных в магазин:");
        market.setMarketAmount(input.nextInt());

        marketDao.save(market);

        System.out.println("Изменение успешно!");
    }

    public void deletePosition(){
        System.out.println("Введите id");
        Market market = marketDao.getPositionById(input.nextInt());

        marketDao.delete(market);

        System.out.println("Удаление прошло успешно!");
    }
}
