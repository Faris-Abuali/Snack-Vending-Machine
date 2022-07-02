import java.util.Scanner;

public class ProcessingReceivedMoneyState implements State {
    SnackMachine snackMachine;

    public  ProcessingReceivedMoneyState(SnackMachine snackMachine) {
        this.snackMachine = snackMachine;
    }

    @Override
    public void pressAKeypadKey(int keyNumber) {
        System.out.println("You have already selected a snack, now it's time to insert money");
    }

    @Override
    public void checkSnackAvailability() {
        System.out.println("Selected snack is available, please insert money");
    }


//    @Override
//    public void insertCoins() {
//        System.out.println("Please wait while we process the received money");
//    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("todo");
    }

    @Override
    public void processReceivedMoney() {
        Scanner sc = new Scanner(System.in);


        while (snackMachine.getMoneyPaid() < snackMachine.selectedSnack.getPrice()) {
            System.out.println("-------- Specify money denomination ----------------");
            System.out.println("#10   --> 10 cents");
            System.out.println("#20   --> 20 cents");
            System.out.println("#50   --> 50 cents");
            System.out.println("#100  --> $1");
            System.out.println("#2000 --> $20");
            System.out.println("#5000 -->  $50");
            System.out.println("-------- (select the number as cents) ----------------");

            int denomination = sc.nextInt();

            switch (denomination) {
                case 10:
                    snackMachine.moneyPaid += 10;
                    break;
                case 20:
                    snackMachine.moneyPaid += 20;
                    break;
                case 50:
                    snackMachine.moneyPaid += 50;
                    break;
                case 100:
                    snackMachine.moneyPaid += 100;
                    break;
                case 2000:
                    snackMachine.moneyPaid += 2000;
                    break;
                case 5000:
                    snackMachine.moneyPaid += 5000;
                    break;
                default:
                    System.out.println("Invalid money denomination, insert again");
            } // end switch
            // The VM displays the accumulated amount of money each time a new money is entered.
            System.out.println("Money paid so far: $" + (snackMachine.getMoneyPaid()) / 100);
            System.out.println("Required price: $" + (snackMachine.getSelectedSnack().getPrice()) / 100);
        } // end while
        // Now I am sure that the entered money is enough, the VM dispenses the selected snack to the customer.

        snackMachine.setState(snackMachine.getDispensingChangeState());
        snackMachine.dispenseSelectedSnack();
    } //end method

    @Override
    public void dispenseChange() {
        System.out.println("Please wait, the machine is processing received money");
    }

}// end class
