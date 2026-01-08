package ProjectFinal;

import java.util.ArrayList;
import java.util.Random;

public class ThreeHintOneWord {
    public Person person = new Person();

    private static Random random = new Random();
    public static int rand = random.nextInt(30);;
    public static ArrayList<String> hint = new ArrayList<>();
    public static ArrayList<String> ans = new ArrayList<>();


    public ThreeHintOneWord(Person person) {
        this.person = person;
    }

    public ThreeHintOneWord() {
        this.person.setInfo("Unknown" , "Unknown" , 0);
    }

    public void start(){
        hint.add("fruit - sweet - yellow");
        ans.add("Pineapple");

        hint.add("clear - healthy - glass");
        ans.add("Water");

        hint.add("spice - sweet - white");
        ans.add("Sugar");

        hint.add("milk - sour - white");
        ans.add("Yoghurt");

        hint.add("door - lock - open");
        ans.add("Key");

        hint.add("fly - airport - travel");
        ans.add("Plane");

        hint.add("fun - play - people");
        ans.add("Game");

        hint.add("smoke - ash - mountain");
        ans.add("Volcano");

        hint.add("color - sun - rain");
        ans.add("Rainbow");

        hint.add("bed - night - tired");
        ans.add("Sleep");

        hint.add("play - bounce - throw");
        ans.add("Basketball");

        hint.add("wood - line - eraser");
        ans.add("Pencil");

        hint.add("head - rest - bed");
        ans.add("Red");

        hint.add("words - pages - spine");
        ans.add("Rook");

        hint.add("teeth - paste - clean");
        ans.add("Toothbrush");

        hint.add("yellow, sticks, Fast food");
        ans.add("Frenchfries");

        hint.add("yellow, crackers, rats love it");
        ans.add("Cheese");

        hint.add("red, fruit, ketchup");
        ans.add("Tomato");

        hint.add("carrot, pet, fast");
        ans.add("Rabbit");

        hint.add("sing, fly, Twitter");
        ans.add("Bird");

        hint.add("Easter, hen, omelet");
        ans.add("Egg");

        hint.add("slow, green, ninja");
        ans.add("Turtle");

        hint.add("fruit, seeds, red");
        ans.add("WaterMelon");

        hint.add("large, big ears, long nose");
        ans.add("Elephant");

        hint.add("happy, playful, pet");
        ans.add("Dog");

        hint.add("tall, long neck, vegetarian");
        ans.add("Giraffe");

        hint.add("fruit, orange, round");
        ans.add("Orange");

        hint.add("fruit, red, iphone");
        ans.add("Apple");

        hint.add("yellow, hot, day");
        ans.add("Sun");

        hint.add("farm, milk, grass");
        ans.add("Cow");
    }
    public void randomWord(){
        this.rand = random.nextInt(30);
        getWordAgain();
    }
    public void getWordAgain(){
        System.out.println(hint.get(rand));
    }
    public boolean checkAns(String a){
        boolean winOrLose = false;
        if (a.equalsIgnoreCase(ans.get(this.rand))){
            System.out.println("*****************************");
            System.out.println("\u001B[32m" + "        You win!!");
            System.out.println("30 Bath has add to your bank." + "\u001B[0m");
            System.out.println("*****************************");
            person.bank.addMoney(30);
            winOrLose = true;
        } else {
            System.out.println("*********************************");
            System.out.println("\u001B[31m" + "        Wrong! try again.");
            System.out.println("10 Bath has remove off your bank." + "\u001B[0m");
            System.out.println("*********************************");
            person.bank.withdrawMoney(10);
        }
        return winOrLose;
    }
    public void getAnswer(){
        System.out.println("\u001B[32m" + "Answer is " + ans.get(rand) + "\u001B[0m");
    }

}
