/**
 * Created by Jack on 11/14/2016.
 */
public class QuotedFieldState implements State {
    private CSVMachine csvMachine;

    public QuotedFieldState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void processChar(char c) {
        switch (c) {
            case '"':
                csvMachine.setState(csvMachine.getSeenAQuoteState());
                break;
            default:
                csvMachine.appendToSB(c);
                break;
        }
    }

    @Override
    public String toString() {
        return "QuotedFieldState";
    }
}
