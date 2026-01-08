package ProjectFinal;

import java.util.ArrayList;
import java.util.Random;

public class RandomNumber{
    public Person person = new Person();
    private Random random = new Random();
    public static ArrayList<String> correctNumber = new ArrayList<>();
    private String lastNumberTwoDigits = "";
    private String lastNumberThreeDigits = "";

    public RandomNumber(Person person) {
        this.person = person;
    }

    public RandomNumber() {
        this.person.setInfo("Unknown", "Unknown", 0);
    }

    public void randomNumber() {
        this.lastNumberTwoDigits = "";
        this.lastNumberThreeDigits = "";
        for (int i = 0; i < 5; i++) {
            String forAdd = "";
            for (int j = 0; j < 6; j++) {
                int abc = random.nextInt(10);
                forAdd += abc + "";

            }
            correctNumber.add(forAdd);


            if (correctNumber.size() > 5) {
                correctNumber.remove(0);
            }
        }

    }

    public void showNumber() {
        System.out.println("*******************************");
        for (int i = 0; i < correctNumber.size(); i++) {
            System.out.println("#" + (i + 1) + " Prize : " + correctNumber.get(i) + "  " + ifYouWin(i) + " Bath.");
        }
        this.lastNumberTwoDigits = correctNumber.get(0).charAt(4) + "" + correctNumber.get(0).charAt(5);
        this.lastNumberThreeDigits = correctNumber.get(0).charAt(3) + "" +correctNumber.get(0).charAt(4) + "" + correctNumber.get(0).charAt(5);
        System.out.println("Last number two digits is " + lastNumberTwoDigits);
        System.out.println("Last number three digits is " + lastNumberThreeDigits);
        System.out.println("*******************************\n");
    }

    public int ifYouWin(int i) {
        int money = 0;
        if (i == 0) {
            money = 6000000;
        } else if (i == 1) {
            money = 200000;
        } else if (i == 2) {
            money = 80000;
        } else if (i == 3) {
            money = 40000;
        } else if (i == 4) {
            money = 20000;
        }
        return money;
    }

    public void checkPlayerNumber(ArrayList<String> ticket) {
        String nConvertToTwoDigits = "";
        String nConvertToThreeDigits = "";
        int win = 0;
        int index = 0;
        for (int i = 0; i < ticket.size(); i++) {
            win = 0;
            for (int j = 0; j < correctNumber.size(); j++) {
                nConvertToTwoDigits = ticket.get(i).charAt(4) +""+ ticket.get(i).charAt(5);
                nConvertToThreeDigits = ticket.get(i).charAt(3) +""+ ticket.get(i).charAt(4) +""+ ticket.get(i).charAt(5);
                if (ticket.get(i).equalsIgnoreCase(correctNumber.get(j))) {
                    index = j;
                    win = 1;
                    break;
                }  else if (nConvertToThreeDigits.equalsIgnoreCase(lastNumberThreeDigits)) {
                    System.out.println((("\u001B[32m" + "[" + (i+1) + "]You win Last Number Three Digits Prize!!!" + "\u001B[0m")));
                    System.out.println("4000 Bath has add to your bank.");
                    person.bank.addMoney(4000);
                    win = 3;
                    break;
                } else if (nConvertToTwoDigits.equalsIgnoreCase(lastNumberTwoDigits)) {
                    System.out.println(("\u001B[32m" + "[" + (i+1) + "]You win Last Number Two Digits Prize!!!" + "\u001B[0m"));
                    System.out.println("2000 Bath has add to your bank.");
                    person.bank.addMoney(2000);
                    win = 3;
                    break;
                }

            }
            if (win == 1) {
                System.out.println("\n***********************************");
                System.out.println("\u001B[32m" + "[" + (i + 1) + "]" + "You win " + (index+1) + "# Prize!!!" + "\u001B[0m");
                System.out.println(ifYouWin(index) + " Bath has add to your bank.");
                System.out.println("***********************************\n");
                person.bank.addMoney(ifYouWin(index));
            } else if (win == 0) {
                if (i == 0) {
                    System.out.println("***********************************");
                }
                System.out.println("[" + (i + 1) + "]" + ticket.get(i) + " : Sorry, you didn't win this time.");
                if (i == ticket.size() - 1) {
                    System.out.println("***********************************\n");
                }
            }
        }
    }
}
