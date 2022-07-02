import java.util.HashMap;
import java.util.Map;

public class DispensingChangeState implements State {
    SnackMachine snackMachine;

    public  DispensingChangeState(SnackMachine snackMachine) {
        this.snackMachine = snackMachine;
    }

    @Override
    public void pressAKeypadKey(int keyNumber) {
        System.out.println("Please wait, the machine is dispensing change");
    }

    @Override
    public void checkSnackAvailability() {
        System.out.println("Please wait, the machine is dispensing change");
    }

    @Override
    public void processReceivedMoney() {
        System.out.println("Please wait, the machine is dispensing change");
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Please wait, the machine is dispensing change");
    }

    @Override
    public void dispenseChange() {
//  Available denominations: 10c • 20c • 50c • $1 • $20 • $50
//        int requiredPrice = Math.round(snackMachine.getSelectedSnack().getPrice());
//        int paidMoney = Math.round(snackMachine.getMoneyPaid());

        float requiredPrice = snackMachine.getSelectedSnack().getPrice();
        float paidMoney = snackMachine.getMoneyPaid();

        System.out.println("------------------------------------------");
//        Remember that I stored the prices in cents.
        System.out.println("required price: $" + (requiredPrice / 100));
        System.out.println("paid money: $" + (paidMoney / 100));

        int[] denominations = {5000, 2000, 100, 50, 20, 10};

        HashMap<String, Integer> tally = new HashMap<String, Integer>();
        tally.put("10", 0); // 10 cents
        tally.put("20", 0); // 20 cents
        tally.put("50", 0); // 50 cents
        tally.put("100", 0); // $1
        tally.put("2000", 0); // $2
        tally.put("5000", 0); // $5

        float changeDue = paidMoney - requiredPrice; // in cents
        float changeDueCopy = changeDue; // in cents
        if (changeDue > 0) {
//            then there is change to be returned:
            for(int denom : denominations) {
                int number = (int) Math.floor(changeDue / denom);
                tally.put(denom+"", number); // number of coins of this denomination to be returned

                changeDue = changeDue % denom;
            }
        }
        System.out.println("Change: " + (changeDueCopy / 100));
//        Now iterate over the `tally` hashMap and print the details:
        System.out.println("------------------------------------------");
        System.out.println("The change will be dispensed as follows: ");
        System.out.println("denomination        Number of coins/notes");
        System.out.println("$50                  " + tally.get("5000"));
        System.out.println("$20                  " + tally.get("2000"));
        System.out.println("$1                   " + tally.get("100"));
        System.out.println("¢50                  " + tally.get("50"));
        System.out.println("¢20                  " + tally.get("20"));
        System.out.println("¢10                  " + tally.get("10"));
        System.out.println("------------------------------------------");


//        for (Map.Entry<String, Integer> entry : tally.entrySet()) {
//            System.out.println(entry.getKey() + " ---> " + entry.getValue());
//        }

        snackMachine.setState(snackMachine.getIdleState()); // DispensingChangeState ==> IdleState
    }// end method dispenseChange
} // end class
