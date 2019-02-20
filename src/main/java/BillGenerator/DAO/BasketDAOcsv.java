package BillGenerator.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BasketDAOcsv implements BasketDAO {

    private CSVparser parser;
    private String pathFile;

    public BasketDAOcsv(String pathFile) {
        this.parser = new CSVparser();
        this.pathFile = pathFile;
    }

    public List<Integer> getListOfBarcodes() {

        List<String> listOfBasketLines = null;
        try {
            listOfBasketLines = parser.getListOfLinesFromCSV(pathFile);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Check Your basket file!");
        }
        return convertListOfBasketLinesToListInteger(listOfBasketLines);
    }


    private List<Integer> convertListOfBasketLinesToListInteger(List<String> listOflines) {

        List<Integer> basketList = new ArrayList<>();
        for (String line : listOflines) {
            basketList.add(Integer.valueOf(line.trim()));
        }
        return basketList;
    }
}
