public class Pizza {

    private String pizzaType;
    private String ingredients;
    private int price;


    public Pizza(String pizzaType, String ingredients, int price) {
        this.pizzaType = pizzaType;
        this.ingredients = ingredients;
        this.price = price;
    }
    public int getPrice(){
        return this.price;
    }
    @Override
    public String toString() {
        return "Pizzas{" +
                "pizzaType='" + pizzaType + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", price=" + price +
                '}';
    }

}
