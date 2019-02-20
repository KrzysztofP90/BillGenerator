package BillGenerator;

import BillGenerator.DAO.BasketDAO;
import BillGenerator.DAO.BasketDAOcsv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BasketDAOcsvTest {

    private BasketDAO basketDAO;

    @BeforeEach
    public void init() {
        basketDAO = new BasketDAOcsv("src/main/Resources/testBasket.txt");
    }

    @Test
    public void testIfGetListOfBarcodesReturnListOfIntegers() {

        Class expectedClass = ArrayList.class;
        Class actualClass = basketDAO.getListOfBarcodes().getClass();

        assertEquals(expectedClass, actualClass);
    }
}
