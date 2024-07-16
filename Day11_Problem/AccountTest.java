public class AccountTest {
    public static void main(String[] args) {
        Account account1 = new Account("John Doe", 1000.0);

        System.out.println("Initial Balance: " + account1.getBalance());

        account1.credit(500.0);
        System.out.println("Current Balance after credit: " + account1.getBalance());

        account1.debit(200.0);
        System.out.println("Current Balance after debit: " + account1.getBalance());

        account1.debit(1500.0); // This should fail
        System.out.println("Current Balance after invalid debit: " + account1.getBalance());
    }
}

