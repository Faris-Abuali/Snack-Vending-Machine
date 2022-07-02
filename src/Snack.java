public class Snack {
    float price;
    int amount;
    String name;

    public Snack(float price, int amount, String name) {
        this.price = price;
        this.amount = amount;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getAmount() {
        return this.amount;
    }

    public float getPrice(){
        return this.price;
    }

    public String toString() {
        return "Snack{name: " + this.name + ", price: $" + (this.price / 100) + ", amount = " + this.amount + "}";
    }

    public void decreaseAmount() {
        this.amount -= 1;
    }
}
