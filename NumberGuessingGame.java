import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int rounds = 0;
        int score = 0;

        while (true) {
            rounds++;
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;

            System.out.println("\nRound " + rounds + ". Guess a number between " + minRange + " and " + maxRange + ". You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    score++;
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The secret number was " + secretNumber + ".");
            }

            System.out.println("Your current score is: " + score);

            System.out.print("Do you want to play another round? (y/n): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Game over! Your final score is: " + score);
        scanner.close();
    }
}