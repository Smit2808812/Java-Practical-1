import java.util.Scanner;
import java.util.Random;

public class RPSLS {

    enum Move {
        ROCK, PAPER, SCISSORS, LIZARD, SPOCK
    }

    public static int winner(Move a, Move b) {

        return switch (a) {

            case ROCK -> switch (b) {
                case SCISSORS, LIZARD -> 1;
                case PAPER, SPOCK -> -1;
                case ROCK -> 0;
            };

            case PAPER -> switch (b) {
                case ROCK, SPOCK -> 1;
                case SCISSORS, LIZARD -> -1;
                case PAPER -> 0;
            };

            case SCISSORS -> switch (b) {
                case PAPER, LIZARD -> 1;
                case ROCK, SPOCK -> -1;
                case SCISSORS -> 0;
            };

            case LIZARD -> switch (b) {
                case PAPER, SPOCK -> 1;
                case ROCK, SCISSORS -> -1;
                case LIZARD -> 0;
            };

            case SPOCK -> switch (b) {
                case ROCK, SCISSORS -> 1;
                case PAPER, LIZARD -> -1;
                case SPOCK -> 0;
            };
        };
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int playerScore = 0;
        int computerScore = 0;

        System.out.println("ROCK PAPER SCISSORS LIZARD SPOCK");

        for (int i = 1; i <= 5; i++) {

            System.out.println("\nRound " + i);

            Move player;

            while (true) {
                System.out.print("Enter your move: ");

                String input = sc.nextLine().trim().toUpperCase();

                try {
                    player = Move.valueOf(input);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid move! Try again.");
                }
            }

            Move computer = Move.values()[
                random.nextInt(Move.values().length)
            ];

            System.out.println("Your Move: " + player);
            System.out.println("Computer Move: " + computer);

            int result = winner(player, computer);

            if (result == 1) {
                System.out.println("You win this round!");
                playerScore++;
            } else if (result == -1) {
                System.out.println("Computer wins this round!");
                computerScore++;
            } else {
                System.out.println("It's a tie!");
            }

            System.out.println("Score: " + playerScore + " - " + computerScore);
        }

        System.out.println("\n===== FINAL RESULT =====");

        if (playerScore > computerScore) {
            System.out.println("You win " + playerScore + "–" + computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("Computer wins " + computerScore + "–" + playerScore);
        } else {
            System.out.println("Overall Match Draw!");
        }

        sc.close();
    }
}
