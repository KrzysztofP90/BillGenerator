package BillGenerator;

import BillGenerator.DAO.ProductsPricesDAOcsv;
import BillGenerator.DAO.ProductPricesDAO;
import BillGenerator.model.PackOfProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProductsPricesDAOcsvTest {

    private ProductPricesDAO productsPricesHandler;


    @BeforeEach
    public void init() {
        productsPricesHandler = new ProductsPricesDAOcsv("src/main/Resources/testProductsPrices.csv");
    }


    @Test
    public void checkIfGetProductsReturnArrayList() {

        Class expectedClass = ArrayList.class;
        Class actualClass = productsPricesHandler.getPacksOfProductsList().getClass();

        assertEquals(expectedClass, actualClass);
    }


    @Test
    public void checkIfGetProductsReturnsArrayListOfProducts() {

        Class expectedClass = PackOfProduct.class;
        Class actualClass = productsPricesHandler.getPacksOfProductsList().get(0).getClass();

        assertEquals(expectedClass, actualClass);
    }






}
