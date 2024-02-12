import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while(true) {
            ArrayList<Integer> boxes = new ArrayList<>();
            int chekingRandomNumber = 0;

            System.out.println("Welcome to Earth, Martians! Try to find your cargo. ");

            while (chekingRandomNumber == 0) {
                int buryTheFirstBox = random.nextInt(7);
                int buryTheSecondBox = random.nextInt(7);
                int buryTheThirdBox = random.nextInt(7);

                if (buryTheFirstBox != buryTheSecondBox && buryTheFirstBox != buryTheThirdBox && buryTheSecondBox != buryTheThirdBox) {
                    boxes.add(0, buryTheFirstBox);
                    boxes.add(1, buryTheSecondBox);
                    boxes.add(2, buryTheThirdBox);
                    System.out.println(boxes);
                    chekingRandomNumber++;
                }
            }
            int attempts = 1;
            while (attempts < 6) {

                System.out.println("Attempt " + attempts + ": Enter three numbers separated by a space:");

                int location1 = scanner.nextInt();
                int location2 = scanner.nextInt();
                int location3 = scanner.nextInt();

                int rightNumbers = 0;
                for (int i = 0; i < 3; i++) {
                    if (chekingAllLocations(boxes.get(i), location1, location2, location3)) {
                        rightNumbers++;
                    }
                }
                if (rightNumbers == 3) {
                    System.out.println("Congratulations! You have found all the boxes. The Martians thank you!");
                    System.exit(0);

                }
                else {
                    System.out.println("Correct marks: " + rightNumbers + ". Try again.");
                }
                attempts++;

            }
            System.out.println("Sorry, you've run out of attempts. The Martians could not find their cargo.");
            boxes.clear();

            System.out.println("Do you want to play again? (yes, sure / no (you can stop the program.): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }
        }
    }
    static boolean chekingAllLocations(int location1, int location2, int location3, int location4){
        return location1 == location2 || location1 == location3 || location1 == location4;
    }
}