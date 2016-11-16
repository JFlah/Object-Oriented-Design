/**
 * Created by Jack on 11/14/2016.
 */
public class ErrorState implements State {
    private CSVMachine csvMachine;

    public ErrorState(CSVMachine csvMachine) {
        this.csvMachine = csvMachine;
    }

    public void processChar(char c) {
        switch (c) {
            case ',':
                csvMachine.setSBError();
                csvMachine.addRow();
                csvMachine.clearSB();
                csvMachine.setState(csvMachine.getBeginFieldState());
                break;
            default:
                csvMachine.setSBError();
                break;
        }
    }

    @Override
    public String toString() {
        return "ErrorState";
    }
}
