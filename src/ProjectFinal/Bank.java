package ProjectFinal;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Bank {
    private int money;
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date date = new Date();

    public Bank(int money) {
        this.money = money;
    }

    public Bank() {
        this.money = 0;
    }

    public int getMoney() {
        return this.money;
    }
    public void setMoney(int n){
        this.money = n;
    }
    public void addMoney(int n){
        this.money += n;
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("\u001B[32m" + "Kbank" + "\u001B[0m");
        getDate();
        System.out.println("\u001B[32m" + " +Deposit Money " + n + " Bath." + "\u001B[0m");
        checkBalance();
        System.out.println("--------------------------------------------------------------------\n");
    }
    public void withdrawMoney(int n){
        this.money -= n;
        System.out.println("\n--------------------------------------------------------------------");
        System.out.println("\u001B[32m" + "Kbank" + "\u001B[0m");
        getDate();
        System.out.println("\u001B[31m" + " -Withdraw Money " + n + " Bath." + "\u001B[0m");
        checkBalance();
        System.out.println("--------------------------------------------------------------------\n");
    }
    public void checkBalance(){
        System.out.println("Balance : " + this.money + " Bath.");
    }
    public void getDate(){
        System.out.print(formatter.format(date));
        System.out.print(" Account No. XXXXXX2014");
    }
}
