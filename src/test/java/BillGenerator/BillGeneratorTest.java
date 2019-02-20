package BillGenerator;

import BillGenerator.DAO.BasketDAO;
import BillGenerator.DAO.BasketDAOcsv;
import BillGenerator.DAO.ProductPricesDAO;
import BillGenerator.DAO.ProductsPricesDAOcsv;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.TestGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BillGeneratorTest {

    private String testPathBasket;
    private String testPathProductPrices;
    private BillGenerator testGenerator;


    @BeforeEach
    public void init() {
        testPathBasket = "src/main/Resources/testBasket.txt";
        testPathProductPrices = "src/main/Resources/testProductsPrices.csv";
        testGenerator = new BillGenerator(testPathBasket, testPathProductPrices);
    }


    @Test
    public void testIfBillGeneratorCreatesCorrectBasketDao() {

        Class expectedClass = BasketDAOcsv.class;
        Class actualClass = testGenerator.getBasketDAO().getClass();

        assertEquals(expectedClass, actualClass);
    }


    @Test
    public void testIfBillGeneratorCreatesCorrectProductPricesDao() {

        Class expectedClass = ProductsPricesDAOcsv.class;
        Class actualClass = testGenerator.getProductPricesDAO().getClass();

        assertEquals(expectedClass, actualClass);
    }


    @Test
    public void testIfCalculatePriceReturnCorrectPrice17ForTestBasket() {

        double expectedPrice = 17.00;
        double actualPrice = testGenerator.calculatePrice();

        assertEquals(expectedPrice, actualPrice);
    }


    
    @Test
    public void testIfCalculatePriceReturnCorrectPriceForOtherBasket() {

        BillGenerator generator2 = new BillGenerator("src/main/Resources/testBasket2.txt",
                testPathProductPrices);

        double expectedPrice = 18.50;
        double actualPrice = generator2.calculatePrice();

        assertEquals(expectedPrice, actualPrice);
    }


    @Test
    public void testIfCalculatePriceReturnCorrectPriceForOtherPackOfProductsSet() {

        BillGenerator generator2 = new BillGenerator(testPathBasket,
                "src/main/Resources/testProductPrices2.csv");

        double expectedPrice = 5.60;
        double actualPrice = generator2.calculatePrice();

        assertEquals(expectedPrice, actualPrice);
    }

}
