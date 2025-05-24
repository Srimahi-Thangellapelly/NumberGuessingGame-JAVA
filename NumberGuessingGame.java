import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
          
            int maxAttempts = 0;
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Choose a level that makes you rethink about the game existence:");
            System.out.println("1. Easy (20 attempts)");
            System.out.println("2. Medium (10 attempts)");
            System.out.println("3. Hard (5 attempts)");
            System.out.print("Enter choice (1-3): ");
            int level = scanner.nextInt();

            switch (level) {
                case 1:
                    maxAttempts = 20;
                    break;
                case 2:
                    maxAttempts = 10;
                    break;
                case 3:
                    maxAttempts = 5;
                    break;
                default:
                    System.out.println("Invalid choice. Defaulting to Medium difficulty.");
                    maxAttempts = 10;
            }

            int numberToGuess = random.nextInt(100) + 1;
            int attemptsLeft = maxAttempts;
            int guess = 0;
            boolean hasWon = false;

            System.out.println("\n pick a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.\n");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attemptsLeft--;

                if (guess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    System.out.println("Attempts used: " + (maxAttempts - attemptsLeft));
                    hasWon = true;
                    break;
                } else if (Math.abs(guess - numberToGuess) <= 10) {
                    System.out.println("Very close! Try again.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft + "\n");
                } else {
                    System.out.println("Game Over! The number was: " + numberToGuess);
                }
            }

       
            System.out.print("\nDo you want to play again? (yes/no): ");
            scanner.nextLine();
            playAgain = scanner.nextLine().trim();

            System.out.println();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!!!!!!!!!!!!!!");
        System.out.println("Come back to sweat it out, wondering if it is correct");
        scanner.close();
    }
}
