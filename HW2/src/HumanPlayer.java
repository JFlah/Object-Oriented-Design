import java.util.Scanner;

/**
 * Created by Jack on 9/15/2016.
 */
public class HumanPlayer extends Player {

    Scanner scanner = new Scanner(System.in);

    boolean inTurn;

    public HumanPlayer(int id) {
        super(id);
    }

    public void doTurn() {
        inTurn = rollForTurn();

        while (inTurn) {
            askAboutCounts();
            inTurn = determineTakePotOrRollAgain();
            if (inTurn) {
                doTurn();
            } else {
                takePotEndTurn();
                inTurn = false;
                return;
            }
        }
    }

    private void askAboutCounts() {
        System.out.println("Would you like to see the players' chip counts?");
        System.out.println("Usage: <Y || N>");
        String showCounts = scanner.next();
        if (showCounts.equals("Y")) {
            printCounts();
        }
    }

    private boolean determineTakePotOrRollAgain() {
        System.out.println("Would you like to take the current pot (1) or roll again (2)?");
        System.out.println("Usage: <1 || 2>");
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            return false;
        } else {
            return true;
        }
    }
}
