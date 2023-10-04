package com.example.ass01_rps;
import java.util.Scanner;

public class Ass01_RPS {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            boolean playAgain = true;

            while (playAgain) {
                System.out.println("Player A, enter your move (R/P/S): ");
                String playerAMove = scanner.nextLine().toUpperCase();

                while (!isValidMove(playerAMove)) {
                    System.out.println("Invalid move. Please enter R, P, or S: ");
                    playerAMove = scanner.nextLine().toUpperCase();
                }

                System.out.println("Player B, enter your move (R/P/S): ");
                String playerBMove = scanner.nextLine().toUpperCase();

                while (!isValidMove(playerBMove)) {
                    System.out.println("Invalid move. Please enter R, P, or S: ");
                    playerBMove = scanner.nextLine().toUpperCase();
                }

                String result = determineWinner(playerAMove, playerBMove);
                System.out.println(result);

                System.out.println("Do you want to play again? (Y/N): ");
                String playAgainChoice = scanner.nextLine().toUpperCase();
                playAgain = playAgainChoice.equals("Y");
            }

            System.out.println("Thank you for playing!");
            scanner.close();
        }

        public static boolean isValidMove(String move) {
            return move.equals("R") || move.equals("P") || move.equals("S");
        }

        public static String determineWinner(String moveA, String moveB) {
            if (moveA.equals(moveB)) {
                return "It's a Tie!";
            } else if ((moveA.equals("R") && moveB.equals("S")) ||
                    (moveA.equals("P") && moveB.equals("R")) ||
                    (moveA.equals("S") && moveB.equals("P"))) {
                return "Player A wins!";
            } else {
                return "Player B wins!";
            }
        }

}
