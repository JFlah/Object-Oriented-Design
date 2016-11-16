/**
 * Created by Jack on 11/14/2016.
 */
public class BeginFieldState implements State {
    private CSVMachine csvMachine;

    public BeginFieldState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void processChar(char c) {
        switch (c) {
            case '"':
                csvMachine.setState(csvMachine.getQuotedFieldState());
                break;
            default:
                csvMachine.setState(csvMachine.getUnquotedFieldState());
                csvMachine.appendToSB(c);
                break;
        }
    }

    @Override
    public String toString() {
        return "BeginFieldState";
    }
}
