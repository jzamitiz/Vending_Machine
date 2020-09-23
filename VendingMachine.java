import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Product> inventory = new ArrayList();
    private Money_system money_box = new Money_system();

    public VendingMachine(){

        inventory.add(new Product("Doritos",200, 3));
        inventory.add(new Product("Airpods",1000, 0));
        inventory.add(new Product("Kit-Kat",200, 5));
        inventory.add(new Product("Beer",400, 3));
        inventory.add(new Product("Water",100, 6));
    }

    public void display_inventory(){
        int i = 0;
        System.out.println("_________________________");
        for(Product x : inventory){
            double dnum = x.getPrice();
            System.out.println((i+1) + ") " +x.getName() + " $" + (dnum/100) + " QTY: " + x.getQuantity());
            i++;
        }
        System.out.println("_________________________");
        double dnum = money_box.how_many_coins_for_purchase();
        System.out.println("You have a balance of: $" + (dnum/100) + "\n");

    }

    public boolean isSelectionValid(int i){
        return 1 <= i && i <= inventory.size();
    }

    public void emptyMoney_Box(){
        money_box.remove_money();
    }

    public void add_coins(){
        money_box.add_currency();
    }

    public void refund(){
        money_box.return_Coins_for_purchase();
    }

    public void restock(int choice){

        if(choice >= 1 & choice <= inventory.size()){
            Product item = inventory.get(choice - 1);
            item.restock(2);
        }
        else
            System.out.println("Invalid Selection");
    }

    public void select_product(int choice){

        if (choice >= 1 & choice <= inventory.size()){

            Product item = inventory.get(choice - 1);

            if (money_box.how_many_coins_for_purchase() < item.getPrice()){
                System.out.println("You have not added enough money!");
            }
            else if(money_box.how_many_coins_for_purchase() > item.getPrice() && item.getQuantity() != 0){
                money_box.make_change(item.getPrice());
                money_box.deposit_money();
                item.vend();
                System.out.println("Enjoy!");
            }
            else if (item.getQuantity() == 0){
                System.out.println("Sorry! " + item.getName() + "(s) are out of stock.");
                money_box.return_Coins_for_purchase();
            }
            else {
                money_box.deposit_money();
                item.vend();
                System.out.println("Enjoy!");
            }
        }
        else
            System.out.println("Invalid Selection");
        System.out.println();
    }

}
