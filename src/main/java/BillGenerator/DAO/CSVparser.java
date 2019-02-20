package BillGenerator.DAO;

import BillGenerator.model.PackOfProduct;
import BillGenerator.model.ProductDescribe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVparser {


    protected List<String> getListOfLinesFromCSV(String pathToFile) throws IOException {

        FileReader fr = new FileReader(pathToFile);
        BufferedReader bf = new BufferedReader(fr);
        List<String> listOfLines = new ArrayList<>();

        String line = bf.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bf.readLine();
        }
        return listOfLines;
    }


    protected ProductDescribe parseCSVfileToModelPackOfProduct(String[] objectPropertiesArray) {
        return new PackOfProduct(Integer.valueOf(objectPropertiesArray[0].trim()), objectPropertiesArray[1],
                Integer.valueOf(objectPropertiesArray[2].trim()), Double.valueOf(objectPropertiesArray[3].trim()) );
    }


    protected List<ProductDescribe> getListOfProductsFromListOfLinesWithObjects(List<String> listOfLines) {

        List<ProductDescribe> listOfProducts = new ArrayList<>();
        for (int i = 1; i < listOfLines.size(); i++) {
            String[] arrayOfProperties = listOfLines.get(i).split(",");
            listOfProducts.add(parseCSVfileToModelPackOfProduct(arrayOfProperties));
        }
        return listOfProducts;
    }
}
