import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public boolean withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class AtmInterface {
    private BankAccount account;
    private Scanner scanner;

    public AtmInterface(BankAccount account, Scanner scanner) {
        this.account = account;
        this.scanner = scanner;
    }

    public void deposit() {
        System.out.print("Enter the amount for deposit: ");
        int amount = scanner.nextInt();
        if (amount < 1000) {
            System.out.println("Sorry!! You need to deposit more than 1000!!");
        } else {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        }
    }

    public void withdraw() {
        System.out.print("Enter the amount for withdrawal: ");
        int amount = scanner.nextInt();
        if (amount <= 0) {
            System.out.println("Please enter a valid amount.");
            return;
        }

        if (account.getBalance() > 1000) {
            if (amount > account.getBalance()) {
                System.out.println("Your withdrawal amount is greater than the balance amount!!");
            } else {
                if (account.withdraw(amount)) {
                    System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                    if (account.getBalance() < 1000) {
                        System.out.println("Warning: Balance is below the minimum limit!!");
                    }
                }
            }
        } else {
            System.out.println("Insufficient balance for withdrawal!!");
        }
    }

    public void checkBalance() {
        System.out.println("The balance amount is: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);  // Initial balance for the account
        Scanner scanner = new Scanner(System.in);
        AtmInterface atm = new AtmInterface(account, scanner);

        boolean end = true;

        System.out.println("1] DEPOSIT      2] WITHDRAWAL");
        System.out.println("3] CHECK BALANCE  4] EXIT");

        while (end) {
            System.out.print("Enter the number to choose the option: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    atm.deposit();
                    break;
                case 2:
                    atm.withdraw();
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    end = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        System.out.println("Thank you!!");
        scanner.close();
    }
}
