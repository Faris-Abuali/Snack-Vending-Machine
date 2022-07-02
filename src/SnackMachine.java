import java.util.Random;

public class SnackMachine {
    State idleState;
    State checkingSnackAvailabilityState;
    State waitingToInsertMoneyState;
    State processingReceivedMoneyState;
    State ejectingReceivedMoneyState;
    State dispensingSnackState;
    State dispensingChangeState;

    State state = idleState;

    Snack[][] snacks = new Snack[5][5];
    Snack selectedSnack;

    float moneyPaid = 0;

    public SnackMachine() {
        idleState = new IdleState(this);
        checkingSnackAvailabilityState = new CheckingSnackAvailabilityState(this);
        processingReceivedMoneyState = new ProcessingReceivedMoneyState(this);
//        ejectingReceivedMoneyState = new EjectingReceivedMoneyState(this);
//        dispensingSnackState = new DispensingSnackState(this);
        dispensingChangeState = new DispensingChangeState(this);

        this.state = idleState;


        Random rand = new Random();
        int count = 0;
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                float price = rand.nextFloat() * (100 - 0) + 0;
                String name = "item"+count;
                this.snacks[row][col] = new Snack(price*100, 99, name);
//                I multiplied the price by 100 to store the price as in cents
                count++;
            }
        }
    } // end constructor


// Delegate to the state object based on the current state:
    public void pressAKeypadKey(int keyNumber) {
        System.out.println(keyNumber);
        System.out.println(state);
        state.pressAKeypadKey(keyNumber);
    }
    public void checkSnackAvailability() {
        state.checkSnackAvailability();
    }

    public void processReceivedMoney() {
        state.processReceivedMoney();
    }
    public void insertCard(String cardNumber) {
        state.insertCard(cardNumber);
    }
    public void dispenseChange() {
        state.dispenseChange();
    }

//    ---------------------------------------------------------------
    public void printAllSnacks() {
        System.out.println("*********************************");
        System.out.println("        WELCOME TO THE VENDING MACHINE      ");
        System.out.println("*********************************");

        int count = 0;
        System.out.println("----------- All Snacks ---------------");
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.println("#"+count+": " + this.snacks[row][col]);
                count++;
            }
        }
        System.out.println("---------------------------------------");

        System.out.println("Please select a snack (a number from [0, 24]): ");
    }
    //    ---------------------------------------------------------------

    public void dispenseSelectedSnack() {
        System.out.println("Here is your snack: " + this.selectedSnack.getName());
        System.out.println("Thank you for your payment");
        selectedSnack.decreaseAmount();
    }

//    -------- Setter methods: ---------------------
    public void setState(State state) {
        this.state = state;
    }
    public void setSelectedSnack(int keyNumber) {
//        receives a keyNumber. Must be in range: [0, 24]
//        Sets the snacks that corresponds to this number from the 5x5 matrix
        int row = (int) Math.floor(keyNumber / 5);
        int col = (int) Math.floor(keyNumber % 5);
        this.selectedSnack = this.snacks[row][col];
    }

//    -------- Getter methods: ---------------------
    public Snack getSelectedSnack() {
        return this.selectedSnack;
    }

    public float getMoneyPaid() {
        return this.moneyPaid;
    }

//    -------- Getter methods for states: ---------------------
    public State getIdleState() {
        return this.idleState;
    }
    public State getCheckingSnackAvailabilityState() {
        return this.checkingSnackAvailabilityState;
    }
    public State getProcessingReceivedMoneyState() {
        return this.processingReceivedMoneyState;
    }
    public State getDispensingChangeState() {
        return this.dispensingChangeState;
    }

} // end class
