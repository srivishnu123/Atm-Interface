import java.util.Scanner;

// ATM Interface
interface ATM {
    void checkBalance();
    void deposit(double amount);
    void withdraw(double amount);
}

// ATM Implementation
class ATMImpl implements ATM {
    private double balance = 10000; // initial balance

    @Override
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

// Main Class
public class ATMApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATMImpl();

        while (true) {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    atm.deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    atm.withdraw(sc.nextDouble());
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}