/**
 * Created by Jack on 11/14/2016.
 */
public class SeenAQuoteState implements State {
    private CSVMachine csvMachine;

    public SeenAQuoteState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void processChar(char c) {
        switch (c) {
            case '"':
                csvMachine.appendToSB(c);
                csvMachine.setState(csvMachine.getQuotedFieldState());
                break;
            case ',':
                csvMachine.addRow();
                csvMachine.clearSB();
                csvMachine.setState(csvMachine.getBeginFieldState());
                break;
            default:
                csvMachine.setState(csvMachine.getErrorState());
                break;
        }
    }

    @Override
    public String toString() {
        return "SeenAQuoteState";
    }
}
