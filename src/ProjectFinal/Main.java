package ProjectFinal;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void nameSetting(Person player){
        //Method ไว้สำหรับตั้งชื่อ
        while (true) {
            //ไว้ดักจับกรณีที่เราใส่ค่าตัวเลขอายุผิด
            try {
                //สร้าง Object Scanner สำหรับรับข้อความจาก keyboard
                Scanner kb = new Scanner(System.in);
                System.out.print(colorMagenta+ "Enter your Name LastName and Age [Example. Torlab Ritchai 20] : " + colorReset);
                // ใส่ชื่อผู้เล่น
                String name = kb.next();
                // ใส่นามสกุลผู้เล่น
                String lastName = kb.next();
                // ใส่นามสกุลผู้เล่น
                int age = kb.nextInt();
                // เช็คว่าอายุผู้เล่นอยู่ระหว่าง 0 ถึง 100 หรือไม่
                if (age < 0 || age > 100){
                    throw new InputMismatchException();
                }
                // เปลี่ยนชื่อผู่เล่นตามค่าที่ใส่
                player.setInfo(name , lastName , age);
                // จบการทำงาน
                break;
            } catch (InputMismatchException iem){
                System.out.println("Inputmismatch try again"); // ดักจับกรณีที่ใส่ค่าไม่ถูกต้อง
            }

        }
        System.out.println(colorGreen + "Hello " + player.getName() + "!!" +colorReset); // แสดงข้อความชื่อผู้ใช้
    }
    // Method สำหรับเช็คว่าต้องการจะเล่นต่อหรือไม่
    public static boolean playing(boolean playing){
        //สร้าง Object Scanner สำหรับรับข้อความจาก keyboard
        Scanner kb = new Scanner(System.in);
        System.out.println("[P.Play again]     [Q.Quit this game]");
        // ป้อนคำสั่งที่ต้องการ
        String input = kb.next();
        // ถ้าออก คืนค่าเท็จ
        if (input.equalsIgnoreCase("q")){
            System.out.println("See you next time!");
            playing = false;
        } // ถ้าเล่นต่อ คืนค่าจริง
        else if (input.equalsIgnoreCase("p")) {
            playing = true;
            System.out.println("-----------------------------");
        }
        // คืนค่า
        return playing;
    }
    // Method สำหรับเช็คว่าคงเหลือเงินเท่าไหร่
    public static boolean checkPlayerBalance(Person player , int cost){
        boolean returN = false;
        if (player.bank.getMoney() < cost){
            System.out.println("========================================================");
            System.out.println(colorRed + "Your money not enough for this game it's cost (" + cost + " Bath)" + colorReset);
            System.out.println("Your money is " + player.bank.getMoney() + " Bath");
            // ถ้าเงินไม่พอ คืนค่าเท็จ
            returN = false;
        } else {
            // ถ้าเงินพอ คืนค่าจริง
            returN = true;
        }
        // คืนค่า
        return returN;
    }
    public static void main(String[] args) throws InterruptedException {
        Scanner kb = new Scanner(System.in);
        // สร้าง Object ผู้เล่นขึ้นมา
        Person player = new Person();
        // เรียกใช้ Method ไว้สำหรับตั้งชื่อ
        nameSetting(player);
        while (true) {
            // วนลูปจนกว่าจะได้คำสั่ง break หรือ มีค่าเป็นเท็จ
            System.out.println("========================================================\n" + colorMagenta +"Menu");
            System.out.println(colorBlue + "[I.Info Yourself] " + colorReset + "|" +colorBlue + " [C.Change Player] " + colorReset + "|" + colorBlue + " [Q.Quit]" + colorReset);
            System.out.println("========================================================");
            System.out.println(colorMagenta + "Game");
            System.out.println(colorBlue + "[1.Random Number]     [2.Guess the hint]");
            System.out.println("[3.Remember Number]   [4.Guess the number between 0-100]" + colorReset);

            System.out.println("========================================================");
            System.out.print("Choose your Order : ");
            // ป้อนคำสั่งที่ต้องการ
            String game = kb.next();

            String yourInput = "";
            // ถ้าคำสั่งที่ต้องการตรงกับ 1 ให้ใช้คำสั่งด้านล่าง
            if (game.equalsIgnoreCase("Random Number") || game.equalsIgnoreCase("RandomNumber") || game.equalsIgnoreCase("1")) {
                // สร้างตัวแปร boolean ไว้เช็คว่าสามารถเล่นเกมได้หรือไม่
                boolean permission = true;
                permission = checkPlayerBalance(player , 80);
                //
                if (permission) {
                    RandomNumber random = new RandomNumber(player);
                    boolean playing = true;
                    while (playing) {
                        System.out.println(colorMagenta + "[About this game] : This game is about guessing number six digits if you guess right you win." + colorReset);
                        int n = 0;
                        int money = 0;
                        // สร้างลูป ไว้เช็คว่ากำลังเล่นเกมอยู่หรือไม่
                        while (true) {
                            kb = new Scanner(System.in);
                            try {
                                while (true) {
                                    System.out.print("How many ticket number do you want to buy (80 Bath per ticket) : ");
                                    n = kb.nextInt();
                                    playing = checkPlayerBalance(player, n * 80);
                                    if (playing) {
                                        break;
                                    }
                                }
                                break;
                            } catch (InputMismatchException ime) {
                                System.out.println("Inputmismatch try again");
                            }
                        }
                        ArrayList<String> ticket = new ArrayList<>();
                        random.randomNumber();
                        for (int i = 0; i < n; i++) {
                            while (true) {
                                try {
                                    kb = new Scanner(System.in);
                                    //int sixDigits = 0;
                                    int forCheck = 0;
                                    String sixDigits = "";
                                    while (true){
                                        System.out.print("[" + (i + 1) + "] Input your number : ");
                                        //sixDigits = kb.nextInt();
                                        sixDigits = kb.next();
                                        forCheck = Integer.valueOf(sixDigits);
                                        if (sixDigits.length() != 6){
                                            System.out.println("Your input must be six digits.");
                                        } else {
                                            break;
                                        }
                                    }
                                    yourInput = sixDigits + "";
                                    ticket.add(yourInput);
                                    money += 80;
                                    break;
                                } catch (NumberFormatException nfe) {
                                    System.out.println("NumberFormatException try again with 6 digits of number (Ex.123456)");
                                }
                            }
                        }
                        player.bank.withdrawMoney(money);
                        random.showNumber();
                        for (int i = 0; i < 4; i++) {
                            TimeUnit.SECONDS.sleep(1);
                        }
                        random.checkPlayerNumber(ticket);
                        // เรียกใช้ Method ว่าต้องการเล่นต่อหรือไม่
                        playing = playing(playing);
                        // เช็คยอดเงินว่าสามารถเล่นต่อได้หรือไม่
                        permission = checkPlayerBalance(player , 80);
                        if (permission){
                        }else {
                            break;
                        }
                    }
                }
            } // ถ้าคำสั่งที่ต้องการตรงกับ 2 ให้ใช้คำสั่งด้านล่าง
            else if (game.equalsIgnoreCase("2") || game.equalsIgnoreCase("Guess the hint") || game.equalsIgnoreCase("Guessthehint")) {
                // สร้างตัวแปร boolean ไว้เช็คว่าสามารถเล่นเกมได้หรือไม่
                boolean permission = true;
                permission = checkPlayerBalance(player , 30);
                if (permission) {
                    // สร้าง Object เกมทายคำจากคำใบ้
                    ThreeHintOneWord threeHint = new ThreeHintOneWord(player);
                    boolean playing = true;
                    // สร้างลูป ไว้เช็คว่ากำลังเล่นเกมอยู่หรือไม่
                    while (playing) {
                        threeHint.start();
                        System.out.println(colorMagenta + "[About this game] : This game is about guessing word,Player will get 3 hints and guess word 3 round if you guess right you win." + colorReset);
                        System.out.println("Example : cow , drink , white");
                        System.out.println("answer is Milk");
                        System.out.println("-----------------------------");
                        threeHint.randomWord();
                        for (int i = 0; i < 3; i++) {
                            System.out.print("Guess your word : ");
                            String ans = kb.next();
                            if (threeHint.checkAns(ans)) {
                                playing = false;
                                break;
                            }
                            if (i != 2) {
                                threeHint.getWordAgain();
                            }

                        }
                        threeHint.getWordAgain();
                        threeHint.getAnswer();
                        // เรียกใช้ Method ว่าต้องการเล่นต่อหรือไม่
                        playing = playing(playing);
                    }
                }

            } // ถ้าคำสั่งที่ต้องการตรงกับ 3 ให้ใช้คำสั่งด้านล่าง
            else if (game.equalsIgnoreCase("3") || game.equalsIgnoreCase("Change Player") || game.equalsIgnoreCase("ChangePlayer")) {
                // สร้างตัวแปร boolean ไว้เช็คว่าสามารถเล่นเกมได้หรือไม่
                boolean permission = checkPlayerBalance(player , 10);
                if (permission) {
                    boolean playing = true;
                    // สร้างลูป ไว้เช็คว่ากำลังเล่นเกมอยู่หรือไม่
                    while (playing) {
                        System.out.println(colorMagenta + "[About this game] : This game is you have to remember the numbers. Then answer in the correct box(only number 0-9). \nwith time to remember " + colorYellow + "The more answers you get, the more money you get." + colorReset);
                        System.out.println("  Example         you answer       you score\n 1 ┃ 2 ┃ 3        1 ┃ 0 ┃ 3        1 ┃ 0 ┃ 1\n━━━ ━━━ ━━━      ━━━ ━━━ ━━━      ━━━ ━━━ ━━━\n 4 ┃ 5 ┃ 6        3 ┃ 5 ┃ 6        0 ┃ 1 ┃ 1\n━━━ ━━━ ━━━      ━━━ ━━━ ━━━      ━━━ ━━━ ━━━\n 7 ┃ 8 ┃ 9        7 ┃ 8 ┃ 9        1 ┃ 1 ┃ 1");
                        System.out.println("Score is (your correct) - (your incorrect)");
                        System.out.println(colorYellow + "In case your input not equal 0-9 the system will automatics change your number to zero" + colorReset);
                        System.out.println("What level do you want to play?");


                        int level;
                            while (true){
                                try {
                                    System.out.print("Input Level (Each level cost 10 Bath) : ");
                                    kb = new Scanner(System.in);
                                    level = kb.nextInt();
                                    if (level < 0){
                                        System.out.println("Level can't below 0, try again.");
                                    } else {
                                        break;
                                    }
                                } catch (InputMismatchException ime){
                                    System.out.println("Inputmismatch try again.");
                                }
                            }

                            playing = checkPlayerBalance(player , 10 * level);
                            if (!playing){
                                break;
                            }
                            // สร้าง Object เกมจำตัวเลข
                            RememberNumber random = new RememberNumber(player, level);
                            random.randomNumber();
                            random.showNumber();
                            int[][] n = new int[level][level];
                            String[][] input = new String[level][level];
                            System.out.println();
                        for (int i = 0; i < level; i++) {
                            for (int j = 0; j < level; j++) {
                                input[i][j] = kb.next();
                                n[i][j] = isCanTurnToInt(input[i][j]);
                            }
                        }
                            random.checkNumber(n);
                        // เรียกใช้ Method ว่าต้องการเล่นต่อหรือไม่
                        playing = playing(playing);
                    }
                }
            } // ถ้าคำสั่งที่ต้องการตรงกับ 4 ให้ใช้คำสั่งด้านล่าง
            else if (game.equalsIgnoreCase("4") || game.equalsIgnoreCase("Guess the number between 0-100") || game.equalsIgnoreCase("Guessthenumberbetween0-100")) {
                // สร้างตัวแปร boolean ไว้เช็คว่าสามารถเล่นเกมได้หรือไม่
                boolean permission = true;
                permission = checkPlayerBalance(player , 50);
                if (permission) {
                    boolean playing = true;
                    // สร้างลูป ไว้เช็คว่ากำลังเล่นเกมอยู่หรือไม่
                    while (playing){
                        System.out.println(colorMagenta + "[About this game] : This game is you have to Guess the number between 0-100, Player will receive 5 chances to guess." + colorReset);
                        System.out.println("Example : Guess number between 0-100");
                        System.out.println("Player : 2 \nGame : Upper 2 \nPlayer : 10 \nGame : Lower 10 \nPlayer : 5 \nGame : You win!!");
                        System.out.println("--------------------------------");
                        // สร้าง Object เกมทายตัวเลข
                        GuessNumberBTWOnehun guessNum = new GuessNumberBTWOnehun(player);
                        for (int i = 0; i < 5; i++) {
                            int n = 0;
                            System.out.print("["+ (i+1) +"]Guess number between 0-100 : ");
                            try {
                                kb = new Scanner(System.in);
                                while (true) {
                                    n = kb.nextInt();
                                    if (n < 101) {
                                        break;
                                    } else {
                                        System.out.print("try again with number 0-100 : ");
                                    }
                                }
                                playing = guessNum.checkNumber(n);
                                if (!playing){
                                    break;
                                }
                            } catch (InputMismatchException ime){
                                System.out.println("Inputmismatch try again with number 0-100");
                                i -= 1;
                            }
                            if (i == 4){
                                System.out.println(colorGreen + "The number is " + guessNum.getRandomNumber() + colorReset);
                            }


                        }
                        // เช็คยอดเงินว่าสามารถเล่นต่อได้หรือไม่
                        playing = checkPlayerBalance(player , 50);
                        // เรียกใช้ Method ว่าต้องการเล่นต่อหรือไม่
                        playing = playing(playing);
                    }
                }
            } // ถ้าคำสั่งที่ต้องการตรงกับ c ให้ใช้คำสั่งด้านล่าง
            else if (game.equalsIgnoreCase("c") || game.equalsIgnoreCase("Remember Number") || game.equalsIgnoreCase("RememberNumber")) {
                // แก้ไขชื่อผู้เล่น
                nameSetting(player);
            } // ถ้าคำสั่งที่ต้องการตรงกับ i ให้ใช้คำสั่งด้านล่าง
            else if (game.equalsIgnoreCase("i") || game.equalsIgnoreCase("Info Yourself") || game.equalsIgnoreCase("InfoYourself")) {
                // แสดงรายละเอียดผู้เล่น
                System.out.println(player.toString());
            } // ถ้าคำสั่งที่ต้องการตรงกับ q ให้ใช้คำสั่งด้านล่าง แล้วจบการทำงาน
            else if (game.equalsIgnoreCase("q") || game.equalsIgnoreCase("quit")) {
                System.out.println(colorCYAN + "Have a nice day!");
                break;
            }

        }


    }
    // Method เช็คว่าสามารถแปลงค่าเป็น int ได้หรือไม่
    public static int isCanTurnToInt(String input){
        int forReturn = 0;
        switch (input){
            case "1" :
                forReturn = 1;
                break;
            case "2" :
                forReturn = 2;
                break;
            case "3" :
                forReturn = 3;
                break;
            case "4" :
                forReturn = 4;
                break;
            case "5" :
                forReturn = 5;
                break;
            case "6" :
                forReturn = 6;
                break;
            case "7" :
                forReturn = 7;
                break;
            case "8" :
                forReturn = 8;
                break;
            case "9" :
                forReturn = 9;
                break;
        }
        return forReturn;
    }
    // ปรับสีตัวอักษรเป็นสีเริ่มต้น
    public static final String colorReset = "\u001B[0m";
    // ปรับสีตัวอักษรเป็นสีแดง
    public static final String colorRed = "\u001B[31m";
    // ปรับสีตัวอักษรเป็นสีฟ้า
    public static final String colorBlue = "\u001B[34m";
    // ปรับสีตัวอักษรเป็นสีฟ้าอ่อน
    public static final String colorCYAN = "\u001B[36m";
    // ปรับสีตัวอักษรเป็นสีขาว
    public static final String colorWhite = "\u001B[37m";
    // ปรับสีตัวอักษรเป็นสีดำ
    public static final String colorBlack = "\u001B[30m";
    // ปรับสีตัวอักษรเป็นสีม่วง
    public static final String colorMagenta = "\u001B[35m";
    // ปรับสีตัวอักษรเป็นสีเขียว
    public static final String colorGreen = "\u001B[32m";
    // ปรับสีตัวอักษรเป็นสีเหลือง
    public static final String colorYellow = "\u001B[33m";
}

