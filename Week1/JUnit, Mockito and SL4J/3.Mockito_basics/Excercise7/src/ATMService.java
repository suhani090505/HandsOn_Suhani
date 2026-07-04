public class ATMService {

    private ATM atm;

    public ATMService(ATM atm) {
        this.atm = atm;
    }

    public void withdraw(int amount) {

        atm.dispenseCash(amount);
    }
}