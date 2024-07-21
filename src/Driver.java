
/**

 * Class: 44-241 Computer Programming II

 * Author: Brian Cookson

 * Description: Module 3: Project 01

  * Due: 7/21/2024

  * I pledge that I have completed the programming assignment independently.

  * I have not copied the code from a student or any source.

  * I have not given my code to any other student and will not share this code with anyone under any circumstances.

 */
import java.util.Scanner;
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] smithVotes = new int[3];
        int[] pewterschmidtVotes = new int[3];

        // Input votes
        for (int i = 0; i < 3; i++) {
            System.out.println("Precinct " + (i + 1) + " votes:");
            System.out.print("Mr. Smith votes: ");
            smithVotes[i] = input.nextInt();
            System.out.print("Carter Pewterschmidt votes: ");
            pewterschmidtVotes[i] = input.nextInt();
        }

        // Calculate total votes
        int totalSmithVotes = findTotalVotes(smithVotes);
        int totalPewterschmidtVotes = findTotalVotes(pewterschmidtVotes);

        // Display votes
        System.out.println("\nThe votes for each candidate are:");
        System.out.println("Mr Smith: " + totalSmithVotes);
        System.out.println("Carter Pewterschmidt: " + totalPewterschmidtVotes);

        // Check for recounts
        int recount = 1;
        while (recount == 1) {
            System.out.print("\nDo you have any recounts? 1 for Yes, 2 for No: ");
            recount = input.nextInt();
            if (recount == 1) {
                System.out.println("\nSelect the appropriate candidate number below.");
                System.out.println("1. Mr. Smith");
                System.out.println("2. Carter Pewterschmidt");
                System.out.print("Candidate number: ");
                int candidate = input.nextInt();
                
                System.out.println("\nPlease select a precinct to change");
                System.out.println("1. Precinct 1");
                System.out.println("2. Precinct 2");
                System.out.println("3. Precinct 3");
                System.out.print("Precinct number: ");
                int precinct = input.nextInt();
                
                System.out.print("Please enter the number of votes: ");
                int newVotes = input.nextInt();
                
                if (candidate == 1) {
                    smithVotes[precinct - 1] = newVotes;
                    totalSmithVotes = findTotalVotes(smithVotes);
                } else if (candidate == 2) {
                    pewterschmidtVotes[precinct - 1] = newVotes;
                    totalPewterschmidtVotes = findTotalVotes(pewterschmidtVotes);
                }
            }
        }

        // Display final votes and winner
        System.out.println("\nThe votes for each candidate are:");
        System.out.println("Mr Smith: " + totalSmithVotes);
        System.out.println("Carter Pewterschmidt: " + totalPewterschmidtVotes);
        displayWinner(totalSmithVotes, totalPewterschmidtVotes);

        input.close();
    }

    public static int findTotalVotes(int[] votes) {
        int total = 0;
        for (int vote : votes) {
            total += vote;
        }
        return total;
    }

    public static void displayWinner(int firstCandidate, int secondCandidate) {
        if (firstCandidate > secondCandidate) {
            System.out.println("Mr. Smith with " + firstCandidate + " votes is the winner");
        } else if (secondCandidate > firstCandidate) {
            System.out.println("Carter Pewterschmidt with " + secondCandidate + " votes is the winner");
        } else {
            System.out.println("It is a tie!");
        }
    }
}