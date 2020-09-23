public class Main {

    public static void main(String[] args){

        VendingMachine machine_1 = new VendingMachine();
        User_Interaction ui = new User_Interaction(machine_1);

        ui.user_menu();

    }
}
