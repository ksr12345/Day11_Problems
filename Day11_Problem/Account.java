public class Account {
    private final String accountName;
    private double balance;

    public Account(String accountName, double initialBalance) {
        this.accountName = accountName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
        }
    }

    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Credited %.2f to account %s%n", amount, accountName);
        } else {
            System.out.println("Credit amount must be greater than 0.");
        }
    }

    public void debit(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("Debited %.2f from account %s%n", amount, accountName);
            } else {
                System.out.println("Debit amount exceeded account balance.");
            }
        } else {
            System.out.println("Debit amount must be greater than 0.");
        }
    }

    public double getBalance() {
        return balance;
    }
}
