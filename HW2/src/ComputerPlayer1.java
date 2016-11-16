/**
 * Created by Jack on 9/15/2016.
 */
public class ComputerPlayer1 extends Player {

    boolean inTurn;

    public ComputerPlayer1(int id) {
        super(id);
    }

    public void doTurn() {
        inTurn = rollForTurn();

        while (inTurn) {
            inTurn = calculateMove();
            if (inTurn) {
                doTurn();
            } else {
                takePotEndTurn();
                inTurn = false;
                return;
            }
        }
    }

    private boolean calculateMove() {
        if (getAvgCount() < (CHIPS_TO_WIN/2/getNumberPlayers()) && getRolls() < 3 ) {
            return true;
        } else {
            return false;
        }
    }
}
