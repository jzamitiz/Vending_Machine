import java.util.Scanner;

public class User_Interaction {
    private Scanner input = new Scanner(System.in);
    private VendingMachine machine_1;

    public User_Interaction(VendingMachine machine_1){
        this.machine_1 = machine_1;
    }

    public void user_menu(){
        System.out.println("=================================================================");
        System.out.println("   Welcome to Bobcat Quick-Purchase! A TXST Vending Machine.");
        System.out.println("=================================================================");
        machine_1.display_inventory();
        //System.out.println();
        while (true){
            System.out.println("Please choose what you would like to do:");
            System.out.println("1) Add Money\n" +
                               "2) Pick Item\n" +
                               "3) Empty Money\n" +
                               "4) Restock\n" +
                               "5) Quit ");

            char choice = input.nextLine().trim().charAt(0);

            switch (choice){
                case '1':
                    this.add_coins();
                    break;
                case '2':
                    this.choose_product();
                    break;
                case '3':
                    machine_1.emptyMoney_Box();
                    break;
                case '4':
                    this.restock_product();
                    break;
                case '5':
                    this.quit();
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }

    }

    private void add_coins(){
        machine_1.add_coins();
    }

    private void restock_product(){
        machine_1.display_inventory();
        boolean done = false;
        int itemNum = -1;

        while(!done){
            System.out.println("Enter the number of product you would like to re-stock");
            itemNum = Integer.parseInt(input.nextLine());
            if (machine_1.isSelectionValid(itemNum)){
                done = true;
            }
            else
                System.out.println("Invalid choice! Try again.");
        }
        machine_1.restock(itemNum);
    }

    private void choose_product(){
        machine_1.display_inventory();
        boolean done = false;
        int itemNum = -1;

        while(!done){
            System.out.println("Enter the number of product you would like to purchase");
            itemNum = Integer.parseInt(input.nextLine());
            if (machine_1.isSelectionValid(itemNum)){
                done = true;
            }
            else
                System.out.println("Invalid choice! Try again.");
        }
        machine_1.select_product(itemNum);
    }

    private void quit(){
        System.out.println("Thank you for choosing Bobcat Quick-Purchase!");
        machine_1.refund();
        System.exit(0);
    }
}
