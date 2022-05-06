package pl.sdacademy.unit.test.basic.exercises.task3;

public class Account {
    private float balance;
    private final String accountNumber;
    private final Customer customer;

    public Account(float balance, String accountNumber, Customer customer) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.customer = customer;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void transferMoney(Account account, float amount) {
        if(validate(account)) {
            this.setBalance(this.getBalance() - amount);
            account.setBalance(account.getBalance() + amount);
        }
    }

    private boolean validate(Account account) {
        return validateAccountNumber(this.getAccountNumber()) &&
                validateAccountNumber(account.getAccountNumber());
    }

    private boolean validateAccountNumber(String accountNumber) {
        //todo dodać if-else z system.out.println któy informuje że account number jest błędny
       if(accountNumber.length() != 26 || !accountNumber.matches("\\d+")) {
           return false;
       }
       return true;
    }
}
