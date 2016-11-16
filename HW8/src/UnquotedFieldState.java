/**
 * Created by Jack on 11/14/2016.
 */
public class UnquotedFieldState implements State {
    private CSVMachine csvMachine;

    public UnquotedFieldState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void processChar(char c) {
        switch (c) {
            case '"':
                csvMachine.setState(csvMachine.getErrorState());
                break;
            case ',':
                csvMachine.addRow();
                csvMachine.clearSB();
                csvMachine.setState(csvMachine.getBeginFieldState());
                break;
            default:
                csvMachine.appendToSB(c);
                break;
        }
    }

    @Override
    public String toString() {
        return "UnquotedFieldState";
    }
}
