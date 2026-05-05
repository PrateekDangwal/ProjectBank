package ProjectBank;

public class CurrentAccount extends BankAccount{
    float overdraftLimit;
    public CurrentAccount(String accountHolderName, int accountNumber, float balance,float limit) {
        super(accountHolderName, accountNumber, balance);
        this.overdraftLimit = limit;

    }
   @Override
    void withdraw(float amount){
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return;
        }

    else if (getBalance()+overdraftLimit<amount){
        System.out.println("Insufficent Amount");
        return;
    }

    // Actual Deduction
        float newbalance = getBalance() - amount;
        updateBalance(newbalance);

    // Update via Deposite trick


        System.out.println("Withdrawn (with overdraft support): " + amount);
    }

}
