
import java.util.Random;
import java.util.Scanner;

public class P2_Number_Guessing_Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain;
        
        do {
            int randomNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int guess = 0;
            
            System.out.println("\nWelcome to the Number Guessing Game!");
            System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

            while (guess != randomNumber) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;

                if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } 
                else if (guess > randomNumber) {
                    System.out.println("Too high! Try again.");
                }
            }
            
            System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
            
            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);
        
        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }
}
