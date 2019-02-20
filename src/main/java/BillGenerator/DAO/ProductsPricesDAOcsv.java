package BillGenerator.DAO;

import BillGenerator.model.PackOfProduct;
import BillGenerator.model.ProductDescribe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductsPricesDAOcsv implements ProductPricesDAO {

    private CSVparser parser;
    private String filePath;


    public ProductsPricesDAOcsv(String filePath) {
        this.parser = new CSVparser();
        this.filePath = filePath;
    }


    public List<ProductDescribe> getPacksOfProductsList() {
        return getPacksOfProductsList(filePath);
    }


    private List<ProductDescribe> getPacksOfProductsList(String pathToFile)  {

        List<String> listOfLines = null;
        try {
            listOfLines = parser.getListOfLinesFromCSV(pathToFile);
        } catch (IOException e) {
            System.out.println("Check Your ProductsPrices CSV file!");
        }
        return parser.getListOfProductsFromListOfLinesWithObjects(listOfLines);
    }



}
