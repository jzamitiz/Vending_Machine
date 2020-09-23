
public class Product {

    private String name;
    private int price;
    private int quantity;

    public Product(String brand, int cost, int amt){
        this.name = brand;
       this.price = cost;
       this.quantity = amt;
    }

    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    public void restock(int a){
        quantity = quantity + a;
        System.out.println("You have added 2 units to " + this.getName());
    }

    public void vend(){
        quantity = quantity - 1;

        System.out.println("Here's your " + this.getName());
    }

}
