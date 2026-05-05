package ProjectBank;

public class BankAccount {

    private String accountHolderName;
    private int accountNumber;
    private float balance;

    // Constructor
    public BankAccount(String accountHolderName, int accountNumber, float balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Set to 0.");
        }
    }
    // Deposit
    void deposit(float amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }

        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw
    void withdraw(float amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdraw amount");
            return;
        }

        if (balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }

    // Display Balance
    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Transfer to next Bank Account
    void transfer(BankAccount other, float amount) {
        if (amount <= 0) {
            System.out.println("Invalid transfer amount");
            return;
        }
        if (this.balance < amount) {
            System.out.println("Insufficient balance");
            return;
        }

        this.withdraw(amount);
        other.deposit(amount);

        System.out.println("Sucess");
    }

    float getBalance() {
        return balance;
    }

    void updateBalance(float newbalance) {
        this.balance = newbalance;
    }


    // toString override
    @Override
    public String toString() {
        return "Account Holder Name: " + accountHolderName +
                "\nAccount Number: " + accountNumber +
                "\nBalance: " + balance;
    }


    // Main method
    public static void main(String[] args) {
        BankAccount ac1 = new BankAccount("Prateek Dangwal", 23444930, 1000);
        BankAccount ac2 = new BankAccount("Anshul Sanon", 23444939, 4000);

//        System.out.println(ac);
//
//        ac.deposit(2000);
//        ac.displayBalance();
//
//        ac.withdraw(300);
//        ac.displayBalance();

//        ac2.transfer(ac1, 1000);
//
//        ac1.displayBalance();
//        ac2.displayBalance();

        SavingAccount sa = new SavingAccount("Prateek", 123, 1000, 5);

        sa.displayBalance();   // 1000
        sa.addInterest();      // +5%
        sa.displayBalance();   // 1050

        CurrentAccount ca = new CurrentAccount("A", 111, 1000, 2000);

        ca.withdraw(2500);   // should work
        ca.displayBalance();





    }

}
