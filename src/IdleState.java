public class IdleState implements State {
    SnackMachine snackMachine;

    public  IdleState(SnackMachine snackMachine) {
        this.snackMachine = snackMachine;
    }

    @Override
    public void pressAKeypadKey(int keyNumber) {
        snackMachine.setSelectedSnack(keyNumber);
        snackMachine.setState(snackMachine.getCheckingSnackAvailabilityState());
//        IdleState ==> CheckingSnackAvailabilityState
    }

    @Override
    public void checkSnackAvailability() {
        System.out.println("You must select a snack first");
    }


    @Override
    public void processReceivedMoney() {
        System.out.println("You must select a snack first");
    }

    @Override
    public void insertCard(String cardNumber) {
        System.out.println("You must select a snack first");
    }

//    @Override
//    public void validateReceivedMoney(int money) {
//        System.out.println("You must select a snack first");
//    }

    @Override
    public void dispenseChange() {
        System.out.println("There is no change to dispense. Machine is idle");
    }
}
