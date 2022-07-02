public class CheckingSnackAvailabilityState implements State {
    SnackMachine snackMachine;

    public  CheckingSnackAvailabilityState(SnackMachine snackMachine) {
        this.snackMachine = snackMachine;
    }

    @Override
    public void pressAKeypadKey(int keyNumber) {
        System.out.println("Please wait, you have already selected a snack");
    }

    @Override
    public void checkSnackAvailability() {
        System.out.println("--------- Checking Snack Availability.. ---------");
        Snack selectedSnack = snackMachine.getSelectedSnack();
        if (selectedSnack.getAmount() > 0) {
            System.out.println("The snack: " + selectedSnack.getName() + " is available");
//            remember that I stored prices in cents.
            System.out.println("Price: $" + (selectedSnack.getPrice() / 100));

            snackMachine.setState(snackMachine.getProcessingReceivedMoneyState());
//        CheckingSnackAvailabilityState ==> ProcessingReceivedMoneyState
        }
        else {
            System.out.println("Sorry, the snack: " + selectedSnack.getName() + " is SOLD OUT");

            snackMachine.setState(snackMachine.getIdleState());
//        CheckingSnackAvailabilityState ==> IdleState
        }
        System.out.println("------------------------------------------------");
    }

    @Override
//    public void insertCoins() {
//        System.out.println("Please wait, the machine is checking if the selected snack is available");
//    }

    public void processReceivedMoney() {
        System.out.println("Please wait, the machine is checking if the selected snack is available");
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("Please wait, the machine is checking if the selected snack is available");
    }

//    @Override
//    public void validateReceivedMoney(int money) {
//        System.out.println("Please wait, the machine is checking if the selected snack is available");
//    }

    @Override
    public void dispenseChange() {
        System.out.println("Please wait, the machine is checking if the selected snack is available");
    }
}
