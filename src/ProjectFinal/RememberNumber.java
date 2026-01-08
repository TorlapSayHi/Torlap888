package ProjectFinal;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RememberNumber {
    public Person person = new Person();
    private Random random = new Random();
    public int[][] arr; //แก้ตรงนี้ = new int[0][0];


    public RememberNumber(Person person) {
        this.person = person;
    }
    public RememberNumber(Person person , int n) {
        this.person = person;
        this.arr = new int[n][n];
    }
    public RememberNumber(int n) {
        this.person.setInfo("Unknown" , "Unknown" , 0);
        this.arr = new int[n][n];
    }

    public RememberNumber() {
        this.person.setInfo("Unknown" , "Unknown" , 0);

    }

    public void randomNumber(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = random.nextInt(10);
            }
        }
    }
        public void showNumber() throws InterruptedException {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    if (j == 0){
                        System.out.print(" ");
                    }
                    System.out.print(arr[i][j]);

                    if (j < arr.length-1) {
                        System.out.print(" ┃ ");
                    }
                }
                System.out.println();
                if (i < arr.length-1) {
                    for (int j = 0; j < arr.length; j++) {
                        System.out.print("━━━ ");
                    }
                }
                System.out.println();
            }
            for (int i = arr.length+1 ; i > 0 ; i--) {
                System.out.print(i + " ");
                TimeUnit.SECONDS.sleep(1);
            }
            for (int i = 0; i < 30; i++) {
                System.out.println();
            }
            System.out.print("Enter your number (" + arr.length + " * " + arr.length + ")");
        }
        public void checkNumber(int[][] arr){
            int yourFinalScore = 0;
            System.out.println("[Answer],[Your Input],[Your Score] in sequence.\n");
        int[][] yourscore = new int[arr.length][arr.length];
            for (int i = 0; i < this.arr.length; i++) {
                for (int j = 0; j < this.arr.length; j++) {
                    if (arr[i][j] == this.arr[i][j]){
                        yourscore[i][j] = 1;
                        yourFinalScore++;
                    } else {
                        yourscore[i][j] = 0;
                        yourFinalScore--;
                    }
                }
            }
            for (int i = 0; i < yourscore.length; i++) {
                for (int j = 0; j < yourscore.length; j++) {
                    if (j == 0){
                        System.out.print(" ");
                    }
                    System.out.print(this.arr[i][j]);

                    if (j < yourscore.length-1) {
                        System.out.print(" ┃ ");
                    }

                    if (j == yourscore.length-1){
                        System.out.print("    ");
                            for (int l = 0; l < yourscore.length; l++) {
                                if (l == 0){
                                    System.out.print(" ");
                                }
                                System.out.print(arr[i][l]);

                                if (l < yourscore.length-1) {
                                    System.out.print(" ┃ ");
                                }
                                if (l == yourscore.length-1){
                                    System.out.print("    ");
                                    for (int h = 0; h < yourscore.length; h++) {
                                        if (h == 0){
                                            System.out.print(" ");
                                        }
                                        System.out.print(yourscore[i][h]);

                                        if (h < yourscore.length-1) {
                                            System.out.print(" ┃ ");
                                        }
                                    }

                                }
                            }

                    }
                }
                System.out.println();
                if (i < yourscore.length-1) {
                    for (int j = 0; j < yourscore.length; j++) {
                        System.out.print("━━━ ");
                        if (j == yourscore.length-1){
                            if (i < yourscore.length-1) {
                                System.out.print("  ");
                                for (int k = 0; k < yourscore.length; k++) {
                                    System.out.print("━━━ ");
                                    if (k == yourscore.length-1){
                                        if (i < yourscore.length-1) {
                                            System.out.print("  ");
                                            for (int h = 0; h < yourscore.length; h++) {
                                                System.out.print("━━━ ");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.println();
            }
            System.out.println("Your Score is " + yourFinalScore);
            if (yourFinalScore > 0){
                person.bank.addMoney((yourFinalScore * (arr.length * 10)));
            } else if (yourFinalScore < 0){
                person.bank.withdrawMoney((yourFinalScore * (-arr.length * 10)));
            }
        }
}
