import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) {
        BankManagementSystem system = new BankManagementSystem();
        int option = 0;
        do{
        System.out.println("^^^^^Banking Application System^^^^^^^^");
        System.out.println(" 1. Check balance \n 2. Register Account\n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Transfer \n 6. Exit ");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        option = scanner.nextInt();
        switch (option){
            case 1: system.checkBalance();
            break;
            case 2: system.register();
            break;
            case 3: system.deposit();
            break;
            case 4: system.withdraw();
            break;
            case 5: system.transfer();
            break;
            case 6: System.out.println("Thanks for Banking with us");
            break;

        }
        }while (option != 6);
    }
}