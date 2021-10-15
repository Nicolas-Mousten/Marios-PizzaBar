import java.util.ArrayList;

public class Archive {

    //Samuel
    ArrayList<Order> archiveList;


    public Archive(ArrayList<Order> archiveList){
        this.archiveList = archiveList;
    }

    public void addOrder(Order newOrder){

        archiveList.add(newOrder);
        System.out.println("This order has been added to Archive." + newOrder);
    }

    public void printArchive(){
        Pizza temp = new Pizza("Temp", "temp", 300);
        Pizza[] pizzalist = {temp};
        addOrder(new Order(3, pizzalist));
        System.out.println("Check inside print list of archive");
        if(!archiveList.isEmpty()) {
            for(int i = 0; i < archiveList.size();i++){
                System.out.println(archiveList.get(i));
            }
        } else {
            System.out.println("Archive is currently empty");
        }



    }
}
