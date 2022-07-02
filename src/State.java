public interface State {
    public void pressAKeypadKey(int keyNumber);
    public void checkSnackAvailability();
//    public void displayMsgSnackAvailable();
//    public void displayMsgSnackSoldOut();
    public void processReceivedMoney();
    public void insertCard(String cardNumber);
    public void dispenseChange();
//    public void validateReceivedMoney(int money);
}
