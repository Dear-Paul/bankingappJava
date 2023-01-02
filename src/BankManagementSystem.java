import java.util.*;

public class BankManagementSystem implements AccountInterface{
    private AccountOwner accountOwner;
    Map<String, AccountOwner> accounts = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    @Override
    public String toString() {
        return "object";
    }
    @Override
    public void register() {
    System.out.print("Enter a name ");
    accountOwner = new AccountOwner();
    accountOwner.setName(scanner.next());
    Random random = new Random();
    String accountNum = "JVM";
    for(int i = 0; i < 8; i++){
        int n = random.nextInt(10);
        accountNum += Integer.toString(n);
    };
    accountOwner.setAccountNumber(accountNum);
    if(!accounts.containsKey(accountOwner.getAccountNumber())){
        accounts.put(accountOwner.getAccountNumber(), accountOwner);
        System.out.println("Account created successfully");
        showAccountDetails(accountOwner);
    } else System.out.println("Account already exist");

    }

    @Override
    public void showAccountDetails(AccountOwner owner) {
    System.out.println("Account details: " + owner);
    }

    @Override
    public void deposit() {
        System.out.print("Enter your account number: ");
        String accountNum = scanner.next();
        AccountOwner owner = accounts.get(accountNum);
        if(owner != null){
            System.out.print("Enter amount #***");
            long amount = Long.parseLong(scanner.next());
            amount+= owner.getBalance();
            owner.setBalance(amount);
            showAccountDetails(owner);
        } else {
            System.out.println("Account does not exist");
        }
    }

    @Override
    public void withdraw() {
        System.out.print("Enter your account number: ");
        String accountNum = scanner.next();
        AccountOwner owner = accounts.get(accountNum);
        if(owner != null){
            System.out.print("Enter amount #*** ");
            long amount = Long.parseLong(scanner.next()), result;
            if(amount > 0 && amount <= owner.getBalance()){
             result =  owner.getBalance() - amount;
                owner.setBalance(result);
                System.out.println(result + "deducted from account");
                showAccountDetails(owner);
            } else System.out.println("Insufficient balance!");

        } else {
            System.out.println("Account does not exist");
        }

    }

    @Override
    public void transfer() {
        System.out.print("Enter your account number: ");
        String accountNum = scanner.next();
        AccountOwner owner = accounts.get(accountNum);
        if(owner != null){
            System.out.print("Enter recipient account number: ");
            String recipientAcc = scanner.next();
            AccountOwner recipient = accounts.get(recipientAcc);
           if(recipient != null){
               System.out.print("Enter amount #*** ");
               long amount = Long.parseLong(scanner.next()), result;
               if(amount > 0 && amount <= owner.getBalance()){
                   recipient.setBalance(amount);
                   result =  owner.getBalance() - amount;
                   owner.setBalance(result);
                   System.out.println(result + "deducted from account");
                   showAccountDetails(owner);
               } else System.out.println("Insufficient balance!");
           } else {
               System.out.println("Account does not exist");
           }

        } else {
            System.out.println("Account does not exist");
        }
    }

    @Override
    public void checkBalance() {
        System.out.print("Enter your account number: ");
        String accountNum = scanner.next();
        AccountOwner owner = accounts.get(accountNum);
        if(owner != null){
            showAccountDetails(owner);
        } else {
            System.out.println("Account does not exist");
        }


    }


}
