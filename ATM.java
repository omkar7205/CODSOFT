import java.util.Scanner;

public class ATM {
    private static double balance = 1000; // Initial balance

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void checkBalance() {
        System.out.println("Your account balance is: " + balance);
    }

    private static void deposit(double amount) 
    {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private static void withdraw(double amount) {
        if 
        (amount > 0 && amount <= balance) {
           
            balance -= amount;

            System.out.println("Withdrawal successful.");
            checkBalance();
        } 
        else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}
