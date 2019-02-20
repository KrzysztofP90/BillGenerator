package BillGenerator;

import BillGenerator.DAO.BasketDAO;
import BillGenerator.DAO.BasketDAOcsv;
import BillGenerator.DAO.ProductPricesDAO;
import BillGenerator.DAO.ProductsPricesDAOcsv;
import BillGenerator.model.PackOfProduct;
import BillGenerator.model.ProductDescribe;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BillGenerator {

    private BasketDAO basketDAO;
    private ProductPricesDAO productPricesDAO;


    public BillGenerator(String pathToBasket, String patchToProductPrices) {
        this.basketDAO = new BasketDAOcsv(pathToBasket);
        this.productPricesDAO = new ProductsPricesDAOcsv(patchToProductPrices);
    }

    public BasketDAO getBasketDAO() {
        return basketDAO;
    }

    public ProductPricesDAO getProductPricesDAO() {
        return productPricesDAO;
    }



    public double calculatePrice() {

        List<ProductDescribe> listOfProducts = productPricesDAO.getPacksOfProductsList();
        List<Integer> barCodeList = basketDAO.getListOfBarcodes();

        Map<Integer, Integer> mapWithCountOfProductsFromBasket = getMapWithCountOfProductsFromBasket(barCodeList);

        Set<Integer> setOfKeysOfProduct = mapWithCountOfProductsFromBasket.keySet();

        double price = 0;

        for (Integer barCode : setOfKeysOfProduct) {

            int countOfProduct = mapWithCountOfProductsFromBasket.get(barCode);

            while (countOfProduct > 0) {

                ProductDescribe maxPack = getMaxPack(countOfProduct, barCode, listOfProducts);
                PackOfProduct maxPackToRemove = (PackOfProduct) maxPack;
                price += maxPackToRemove.getPrice();
                countOfProduct -= maxPackToRemove.getAmount();
            }
        }
        BigDecimal bd = new BigDecimal(price);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    private ProductDescribe getMaxPack(int countOfProduct, int barCode, List<ProductDescribe> listOfProducts) {

        int maxPackCount = 0;
        ProductDescribe maxPack = null;

        for (ProductDescribe packOfProducts : listOfProducts) {

            int actualPackCount = ((PackOfProduct) packOfProducts).getAmount();

            if (((PackOfProduct) packOfProducts).getBarCode() == barCode) {

                if (actualPackCount <= countOfProduct && maxPackCount < actualPackCount) {
                    maxPackCount = actualPackCount;
                    maxPack = packOfProducts;
                }
            }
        }
        return maxPack;
    }


    private Map<Integer,Integer> getMapWithCountOfProductsFromBasket(List<Integer> barCodeList) {

        Map<Integer,Integer> countOfProductsInBasket = new HashMap<>();

        for (Integer barCode : barCodeList) {

            if (!countOfProductsInBasket.containsKey(barCode)) {
                countOfProductsInBasket.put(barCode, 1);
            }
            else {
                int newValue = countOfProductsInBasket.get(barCode) + 1;
                countOfProductsInBasket.remove(barCode);
                countOfProductsInBasket.put(barCode, newValue);
            }
        }
        return countOfProductsInBasket;
    }


}
