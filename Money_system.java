import java.util.ArrayList;
import java.util.Scanner;

public class Money_system {

    private ArrayList<Coin> machine_currency = new ArrayList();
    private ArrayList<Coin> user_currency= new ArrayList();
    private Scanner input = new Scanner(System.in);

    public Money_system(){
        machine_currency.add(new Coin("penny", 1));
        machine_currency.add(new Coin("nickel", 5));
        machine_currency.add(new Coin("dime", 10));
        machine_currency.add(new Coin("quarter", 25));
        machine_currency.add(new Coin("dollar", 100));
        machine_currency.add(new Coin("AirpodCoin", 1000));

        user_currency.add(new Coin("penny", 1));
        user_currency.add(new Coin("nickel", 5));
        user_currency.add(new Coin("dime", 10));
        user_currency.add(new Coin("quarter", 25));
        user_currency.add(new Coin("dollar", 100));
        user_currency.add(new Coin("AirpodCoin", 1000));
    }

    int machine_balance;
    int coin_balance;

    public void display_coins(){
        int i = 0;
        System.out.println("_____________________");
        for(Coin x : user_currency){
            System.out.println((i+1) + ") " +x.getName() + " Qty: " + x.getQuantity());
            i++;
        }
        System.out.println("_____________________");
    }

    public boolean isCoinSelectionValid(int i){
        return 1 <= i && i <= user_currency.size();
    }

    public int how_many_coins_for_purchase(){
        return coin_balance;
    }

    public void add_currency(){
        boolean done = false;
        int coinNum = -1;

        while(!done) {
            display_coins();

            double dnum = how_many_coins_for_purchase();
            System.out.println("-->$" + (dnum / 100));

            System.out.println("Enter the number of the coin you want to insert; enter 0 when finished.");
            coinNum = Integer.parseInt(input.nextLine());
            if (isCoinSelectionValid(coinNum)) {
                Coin temp = user_currency.get(coinNum - 1);
                temp.addOne();
                coin_balance = coin_balance + temp.getValue();
            }
            else if(coinNum == 0) {
                double dnum1 = how_many_coins_for_purchase();
                System.out.println("You have a balance of: $" + (dnum1 / 100));
                done = true;
            }
            else
                System.out.println("Invalid choice! Try again.");
        }

    }


    public void return_Coins_for_purchase(){
        if (coin_balance > 0) {
            double dnum = coin_balance;
            System.out.println("Refunding $" + (dnum / 100) + " in the following change:");
            for (Coin x : user_currency) {
                System.out.print(x.getQuantity() + " " + x.getName() + "s ");
                x.setQuantity();
            }
            coin_balance = 0;
        }else
            System.out.println();
    }

    public void deposit_money(){
        machine_balance += coin_balance;
        int i = 0;
        for (Coin x : user_currency){
            machine_currency.get(i).transferQuantity(x.getQuantity());
            x.setQuantity();
            i++;
        }
        coin_balance = 0;
    }

    public void make_change(int p){

        int temp = coin_balance - p;
        coin_balance -= p;
        System.out.println("Your change is $" + (((double) temp) /100));
        for(Coin x : user_currency){
            x.setQuantity();
        }
    }

//    public void make_change(int p){ could not ffigure this part out
//        int i = user_currency.size() - 1;
//        int cash_at_hand = 0;
////        ArrayList sec_list = new ArrayList();
////        sec_list = (ArrayList)user_currency.clone();
//
//        while (p > cash_at_hand && i > -1){
//            while (user_currency.get(i).getQuantity() > 0){
//                cash_at_hand += user_currency.get(i).getValue();
//                user_currency.get(i).minusOne();
//                i--;
//            }
//        }
//
//        int temp = coin_balance - cash_at_hand;
//        coin_balance -= p;
//        System.out.println("Your change is $" + (((double) temp) /100));
//        for(Coin x : user_currency){
//            x.setQuantity();
//        }
//    }

    public void remove_money(){
        if (machine_balance > 0) {
            double dnum = machine_balance;

            System.out.println("Removing $" + (dnum / 100) + " dollars from machine.");
            System.out.print("Removed ");
            for (Coin x : machine_currency) {
                System.out.print(x.getQuantity() + " " + x.getName() + "s ");
                x.setQuantity();
            }
            System.out.println();
            machine_balance = 0;
        }else
            System.out.println("The vending machine has been robbed. There are 0 coins.");
    }
}
