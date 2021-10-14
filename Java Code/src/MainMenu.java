import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu { //Mohammad & Samuel //
    public static Scanner scanner = new Scanner(System.in);
    public static Order[] orders;
    public static Order[] archivedOrders;

    public static ArrayList<Order> archiveList = new ArrayList<>();

    public static Archive archive = new Archive(archiveList);

    public static Pizza hawaii = new Pizza("Hawaii", "ost, tomatsovs, ananas, skinke.",99 );
    public static Pizza mariosSpecial = new Pizza("Mario's Special","ost, tomatsovs, oregano, oliven, mozzarella, basilikum.", 65);
    public static Pizza pepperoni = new Pizza("Pepperoni", "ost, tomatsovs, Pepperoni.", 65);
    public static Pizza inbagtHvidløgsPizza = new Pizza("Indbagt Hvidløgs Pizza", "ost, tomatsovs, mozzarella, hvidløg.", 55);
    public static Pizza quattroFormaggi = new Pizza("4 dobbelt oste pizza", "ost, tomatsovs, mozzarella, gedeost, parmasan ost,", 70);

    public static Pizza[] arrayOfPizzas = {hawaii,mariosSpecial,pepperoni,inbagtHvidløgsPizza,quattroFormaggi};
    public static void main(String[] args) {
        while(true) {
            java.lang.System.out.println("MARIOS PIZZABAR 🍕🍕🍕");
            java.lang.System.out.println("____________________________________");
            java.lang.System.out.println("Press 1 for Menu");
            java.lang.System.out.println("Press 2 to confirm orders");
            java.lang.System.out.println("Press 3 for for Active Orders");
            java.lang.System.out.println("Press 4 to see archived orders");
            java.lang.System.out.println("____________________________________");

            int pressedNumber = scanner.nextInt();
            System.out.println("____________________________________");

            System.out.println();
            if (pressedNumber == 1) {
                menuCard();
            } else if (pressedNumber == 2) {
                order();
            } else if (pressedNumber == 3) {
                activeOrders();
            } else if (pressedNumber == 4) {

                //Samuel
                System.out.println("Archive Menu \n");
                System.out.println( "1. for printing Archive \n"+
                                    "2. for deleting an element in archive \n" +
                                    "3. for something else \n");
                int archiveChoice = scanner.nextInt();
                switch(archiveChoice) {
                    case 1:
                        if(archivedOrders != null) {
                            for (Order order: archivedOrders
                            ) {
                                System.out.println(order);
                            }
                        }

                        break;
                    case 2:
                        System.out.println("Pending functionality");
                        break;
                }
               System.out.println("Inside Archive menu tab");

            } else if (pressedNumber >= 4) {
                java.lang.System.out.println("you only have 4 options");
            }

        }
    }
    public static Order[] addOneElementToOrder(Order[] oldArray, Order newObject){ //Nicolas
        int oldArrayLength;
        if (oldArray == null){
            oldArrayLength = 0;
        }else{
            oldArrayLength = oldArray.length;
        }
        int newArrayLength= (oldArrayLength+1);
        Order[] newArray = new Order[newArrayLength];
        for (int i = 0; i < oldArrayLength; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[newArrayLength-1] = newObject;

        for (int i = 0; i < newArrayLength; i++) {
            System.out.println("-----------------------------------");

            System.out.println(newArray[i]);
        }
        return newArray;
    }

    public static void order(){ //Nicolas
        System.out.println("ORDER");
        System.out.println("-----------------------------------");
        System.out.println();

        boolean choiceLock = true;
        Pizza[] PizzaOrder;
        ArrayList<Pizza> PizzaOrderList = new ArrayList<Pizza>();
        for (int i = 0; i < arrayOfPizzas.length; i++) {
            System.out.println((i+1)+" " + arrayOfPizzas[i]);
        }
        while(choiceLock){

            System.out.println("Choose from the menu card using the pizzas number, hit 0 when finished");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    PizzaOrderList.add(hawaii);
                    break;
                case 2:
                    PizzaOrderList.add(mariosSpecial);
                    break;
                case 3:
                    PizzaOrderList.add(pepperoni);
                    break;
                case 4:
                    PizzaOrderList.add(inbagtHvidløgsPizza);
                    break;
                case 5:
                    PizzaOrderList.add(quattroFormaggi);
                    break;
                case 0:
                    choiceLock = false;
                    break;
            }
        }
        PizzaOrder  = PizzaOrderList.toArray(new Pizza[0]);
        int customerid;
        if(orders == null){
            customerid = 0;
        }else {
            int lastObjectInArray = orders.length - 1;
            Order lastCustomerID = orders[lastObjectInArray];
            int customerIDtemp = lastCustomerID.getCustomerID();
            customerid = customerIDtemp + 1;
        }
        Order customerInitiation = new Order(customerid, PizzaOrder);
        orders = addOneElementToOrder(orders, customerInitiation);
    }
    public static void menuCard() {

        System.out.println("MENU CARD");
        System.out.println("...................................." + "\n");

        for (int i = 0; i < arrayOfPizzas.length; i++) {
            System.out.println(arrayOfPizzas[i]);

        }


    }
    public static void activeOrders() { //Mo//
        System.out.println("ACTIVE ORDERS");
        System.out.println("___________________________");
        System.out.println();



        if (orders == null) {
            System.out.println("you have currently no orders");
        } else {



            int activeOrderLength = orders.length;
            ArrayList<Order> activeOrder = new ArrayList<Order>();
            for (int i = 0; i < activeOrderLength; i++) {
                activeOrder.add(orders[i]);
            }

            System.out.println(activeOrder.size());

            for (int i = 0; i < activeOrder.size(); i++) {
                System.out.println(activeOrder.get(i));
            }

            int idChoice = scanner.nextInt();

            scanner.nextLine();


            int indexOfIdChoice = 0;
            for (int i = 0; i < activeOrder.size(); i++) {
                if (activeOrder.get(i).getCustomerID() == idChoice) {
                    indexOfIdChoice = i;
                }

            }
            System.out.println(indexOfIdChoice);

            System.out.println("do you want to delete the order and send it the Archive or return to menu");
            System.out.println("press 1 for Main Menu");
            System.out.println("press 2 for delete and archive the order");

            int choiseOFUser = scanner.nextInt();
            scanner.nextLine();

            ArrayList<Order> archivedOrdersList = new ArrayList<Order>();
            if(archivedOrders==null){

            }else{
                for (int i = 0; i < archivedOrders.length; i++) {
                    archivedOrdersList.add(archivedOrders[i]);
                }
            }


            if ( choiseOFUser == 1) {
                System.out.println("returning to main menu...");

            } else if (choiseOFUser == 2) {
                archivedOrdersList.add(activeOrder.get(indexOfIdChoice));
                activeOrder.remove(indexOfIdChoice);

            }else if (choiseOFUser >= 2){
                System.out.println("you only have 2 options");
            }
            archivedOrders = archivedOrdersList.toArray(new Order[0]);
            orders = activeOrder.toArray(new Order[0]);

        }
    }
}


