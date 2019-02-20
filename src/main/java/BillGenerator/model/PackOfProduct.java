package BillGenerator.model;

public class PackOfProduct implements ProductDescribe{


    private int barCode;
    private String name;
    private int amount;
    private double price;


    public PackOfProduct(int barCode, String name, int amount, double price) {
        this.barCode = barCode;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setBarCode(int barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
