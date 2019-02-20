package BillGenerator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {


        BillGenerator generator = new BillGenerator("src/main/Resources/testBasket.txt",
                "src/main/Resources/testProductsPrices.csv");
        System.out.println(generator.calculatePrice());

    }
}
