package BillGenerator.DAO;

import BillGenerator.model.ProductDescribe;

import java.util.List;

public interface ProductPricesDAO {

    List<ProductDescribe> getPacksOfProductsList();
}
