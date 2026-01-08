package ProjectFinal;

import java.util.Random;

public class GuessNumberBTWOnehun {
    public Person person = new Person();
    public static Random random = new Random();
    private static int randomNumber = random.nextInt(101);

    public GuessNumberBTWOnehun(Person person) {
        this.person = person;
        randomNumber = random.nextInt(101);
    }

    public GuessNumberBTWOnehun() {
        randomNumber = random.nextInt(101);
    }
    public boolean checkNumber(int n){
        boolean winOrLose = true;
            if (n > randomNumber){
                System.out.println("*********************************");
                System.out.println("\u001B[31m" + "        You wrong!!");
                System.out.println("10 Bath has remove off your bank." + "\u001B[0m");
                System.out.println("*********************************");
                person.bank.withdrawMoney(10);
                System.out.println("------------Lower " + n + "------------");
                winOrLose = true;
            } else if (n < randomNumber){
                System.out.println("*********************************");
                System.out.println("\u001B[31m" + "        You wrong!!");
                System.out.println("10 Bath has remove off your bank." + "\u001B[0m");
                System.out.println("*********************************");
                person.bank.withdrawMoney(10);
                System.out.println("------------Upper " + n + "------------");
                winOrLose = true;
            } else if (n == randomNumber){
                System.out.println("**********************************");
                System.out.println("\u001B[32m" + "        You win!!");
                System.out.println("30 Bath has add to your bank." + "\u001B[0m");
                System.out.println("**********************************");
                person.bank.addMoney(30);
                winOrLose = false;
            }
        return winOrLose;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
