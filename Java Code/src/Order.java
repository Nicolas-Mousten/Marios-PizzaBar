import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Order {//Ni
    private int customerID;
    private Pizza[] productList;
    private String currentTimeFormatted;
    private String currentDateFormatted;
    private String productListString;
    private int combinedPrice;
    public Order(int customerID, Pizza[] productList){
        this.customerID = customerID;
        productListString = "\n";
        for (int i = 0; i < productList.length; i++) {
            productListString += (productList[i] +"\n");
        }
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String currentDateFormatted = currentDate.format(dateFormat);

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
        String currentTimeFormatted = currentTime.format(timeFormat);
        this.currentDateFormatted = currentDateFormatted;
        this.currentTimeFormatted = currentTimeFormatted;

        combinedPrice= combinedPrice(productList);
    }
    public int getCustomerID(){
        return this.customerID;
    }


    private int combinedPrice(Pizza[] productList){
        int combinedPrice = 0;
        for (int i = 0; i < productList.length; i++) {
            int pizzaPrice = productList[i].getPrice(); // lavede en metode som sender pizza price til denne classe siden den er privat i den anden classe
            combinedPrice = combinedPrice + pizzaPrice;
        }
        return combinedPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customerID=" + customerID +
                ", productList=" + productListString +
                ", currentDateFormatted='" + currentDateFormatted + '\'' +
                ", currentTimeFormatted='" + currentTimeFormatted + '\'' +
                ", total Price='" + combinedPrice + '\'' +
                '}';
    }
}
