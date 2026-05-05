package ProjectBank;

public class SavingAccount extends BankAccount{

    float interestRate;
    public SavingAccount(String accountHolderName, int accountNumber, float balance,float rate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = rate;
    }

    void addInterest(){
        float interest = getBalance()*interestRate/100;
        deposit(interest);
    }
}
