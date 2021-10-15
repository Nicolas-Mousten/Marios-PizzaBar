import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Order {//Ni
    private int customerID;     //initialize variables
    private Pizza[] productList;
    private String currentTimeFormatted;
    private String currentDateFormatted;
    private String productListString;
    private int combinedPrice;
    public Order(int customerID, Pizza[] productList){      //constructing constructor, whitout date and combined prize since they are automatic
        this.customerID = customerID;
        productListString = "\n";
        for (int i = 0; i < productList.length; i++) {  //remakes the array into a long string for better showing of the input.
            productListString += (productList[i] +"\n");
        }
        LocalDate currentDate = LocalDate.now();                                    //get the local date/time
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");   //specify the layout of the date/time
        String currentDateFormatted = currentDate.format(dateFormat);               //adds the structure for the information

        LocalTime currentTime = LocalTime.now();                                    //get the local date/time
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");     //specify the layout of the date/time
        String currentTimeFormatted = currentTime.format(timeFormat);               //adds the structure for the information


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
        //Samuel
        return new String("Order \n" +
                                    "CustomerID: " + customerID + "\n"+
                                    "productList: " + productListString  +
                                    "Date of Order Confirm: '" + currentDateFormatted + "\'\n" +
                                    "Time of Order Confirm: '" + currentTimeFormatted + "\'\n" +
                                    "Total Price: '" + combinedPrice + "DKK\'\n");
    }
    /*@Override
    public String toString() {
        return "Order{" +
                "customerID=" + customerID +
                ", productList=" + productListString +
                ", currentDateFormatted='" + currentDateFormatted + '\'' +
                ", currentTimeFormatted='" + currentTimeFormatted + '\'' +
                ", total Price='" + combinedPrice + '\'' +
                '}';
    }*/
}
