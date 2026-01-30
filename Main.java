import java.util.Scanner;

// Custom Exception Class
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class Main {

    // Method that throws custom exception
    static void withdraw(double balance, double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal amount exceeds current balance!");
        }
        System.out.println("Withdrawal Successful!");
        System.out.println("Remaining Balance: " + (balance - amount));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your account balance: ");
            double balance = sc.nextDouble();

            System.out.print("Enter withdrawal amount: ");
            double amount = sc.nextDouble();

            withdraw(balance, amount);

        } catch (InsufficientBalanceException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Please enter numeric values only.");

        } catch (Exception e) {
            System.out.println("General Error: " + e);

        } finally {
            System.out.println("Transaction Completed.");
            sc.close();
        }
    }
}
