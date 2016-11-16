import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Jack on 9/14/2016.
 */
public class HW2DiceGame {

    private static int numPlayers;
    private static int numComp1Players;
    private static int numComp2Players;
    private static int numHumanPlayers;

    private static List<Player> playerList = new ArrayList<Player>();

    private static int chipPot = 0;

    public static void main(String[] args) {
        takeInitialInput();
        populateList();
        beginGame();
        System.out.println("\nThank you for playing!");
    }

    public static void printChipCounts() {
        for (Player player : playerList) {
            System.out.println(player.toString() + " has " + player.getChips() + " chips.");
        }
        System.out.println();
    }

    public static int getAverageChipCount() {
        int totalChips = 0;
        int size = 0;
        for (Player player : playerList) {
            totalChips += player.getChips();
            size++;
        }
        return totalChips/size;
    }

    public static int getPlayerListSize() {
        return numPlayers;
    }

    public static int getChipPot() {
        return chipPot;
    }

    public static void increaseChipPot(int chipIncrement) {
        chipPot += chipIncrement;
        System.out.println("Pot increased to: " + chipPot + "\n");
    }

    public static void resetChipPot() {
        chipPot = 0;
    }

    private static void takeInitialInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players? Usage: <int >= 2>");
        numPlayers = scanner.nextInt();

        System.out.println("How many CPU1 players?\n" +
                "Usage: <int>");
        numComp1Players = scanner.nextInt();
        System.out.println("How many CPU2 players? (remainder will be Human)\n" +
                "Usage: <int>");
        numComp2Players = scanner.nextInt();
        numHumanPlayers = numPlayers - (numComp1Players + numComp2Players);
        System.out.println("Total Players: " + numPlayers +
                "\nCPU1 Players: " + numComp1Players +
                "\nCPU2 Players: " + numComp2Players +
                "\nHuman Players: " + numHumanPlayers);
    }

    private static void populateList() {
        addHumanPlayersToList();
        addComputerPlayersToList();
    }

    private static void addHumanPlayersToList() {
        for (int i = 0; i < numHumanPlayers; i++) {
            playerList.add(new HumanPlayer(i));
        }
    }

    private static void addComputerPlayersToList() {
        for (int i = 0; i < numComp1Players; i++) {
            playerList.add(new ComputerPlayer1(i));
        }
        for (int i = 0; i < numComp2Players; i++) {
            playerList.add(new ComputerPlayer2(i));
        }
    }

    private static void beginGame() {
        System.out.println("\nGame Begun\n");
        boolean gameIsOver = false;
        while (!gameIsOver) {
            for (Player player : playerList) {
                System.out.println("It is player " + player.toString() + "'s turn.");
                System.out.println("Current pot: " + chipPot);
                System.out.println("You have " + player.getChips() + " chips.\n");
                System.out.println("Chip Count:");
                printChipCounts();
                player.doTurn();
                int playerChips = player.getChips();
                if (playerChips >= 30) {
                    System.out.println(player.toString() + " wins the game with " + playerChips + " chips!");
                    gameIsOver = true;
                    break;
                }
            }
        }
    }
}
