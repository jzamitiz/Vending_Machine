public class Coin {
    private String name;
    private int value;
    private int quantity;

    public Coin(String n, int a){
        this.name = n;
        this.value = a;
        this.quantity = 0;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public void addOne(){
        quantity+=1;
    }

    public void setQuantity(){
        quantity = 0;
    }

    public void transferQuantity(int t){
        quantity += t;
    }

    public void minusOne(){
        quantity -= 1;
    }
}
