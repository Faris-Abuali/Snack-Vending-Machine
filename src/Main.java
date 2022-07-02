import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SnackMachine snackMachine = new SnackMachine();

        snackMachine.printAllSnacks();
        int keypadNumber = sc.nextInt();
        snackMachine.pressAKeypadKey(keypadNumber); // IdleState ==> CheckingSnackAvailabilityState
        snackMachine.checkSnackAvailability(); // CheckingSnackAvailabilityState  ==> ProcessingReceivedMoneyState
        snackMachine.processReceivedMoney(); // ProcessingReceivedMoneyState ==> DispensingChangeState
        snackMachine.dispenseChange(); // DispensingChangeState ==> IdleState
    }// end main
}// end Main class
