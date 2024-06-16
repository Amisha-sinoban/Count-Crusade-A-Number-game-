package Count;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int rounds = 0;

        while (true) {
            rounds++;
            System.out.println("\nRound " + rounds);
            score += playGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().trim().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("\nGame over! You played " + rounds + " rounds with a score of " + score + ".");
        scanner.close();
    }

    private static int playGame(Scanner scanner) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        int maxAttempts = 10;

        System.out.println("I have generated a random number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess the number.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess;

            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.next(); // clear invalid input
                continue;
            }

            attempts++;

            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                return 10 - attempts; // Higher score for fewer attempts
            } else if (guess < randomNumber) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + randomNumber + ".");
        return 0;
    }
}
