package ProjectFinal;

public class Person extends Bank implements Info{
    private String name;
    private String lastName;
    private int age;
    public Bank bank = new Bank();

    public Person() {
        this.name = "Unknown";
        this.lastName = "Unknown";
        this.age = 0;
        this.bank.setMoney(500);
    }

    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.bank.setMoney(500);
    }

    public void setName(String n){
        this.name = n;
    }
    public void setLastName(String ln){
        this.lastName = ln;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setInfo(String name ,String lastName , int age){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }
    public void clearName(){
        this.name = "";
        this.lastName = "";
        this.age = 0;
        this.bank.setMoney(0);
    }
    public String toString(){
        return "\u001B[33m" + "\n******************************\n" +
                "Name : " + this.name + " " + this.lastName + "\nAge : " + this.age + " | Balance : " + this.bank.getMoney() +
                " Bath\n******************************\n" + "\u001B[0m";
    }

    public String getName() {
        return name;
    }
}
