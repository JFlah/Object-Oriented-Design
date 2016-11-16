import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 11/14/2016.
 */
public class CSVMachine {
    private State beginFieldState;
    private State errorState;
    private State quotedFieldState;
    private State unquotedFieldState;
    private State seenAQuoteState;

    private State state;

    private StringBuilder sb = new StringBuilder();

    private List<String> outputRow = new ArrayList<String>();

    public CSVMachine() {
        beginFieldState = new BeginFieldState(this);
        errorState = new ErrorState(this);
        quotedFieldState = new QuotedFieldState(this);
        unquotedFieldState = new UnquotedFieldState(this);
        seenAQuoteState = new SeenAQuoteState(this);

        state = beginFieldState;
    }

    public void processChar(char c) {
        state.processChar(c);
    }

    public List<String> getRow() {
        outputRow.add(sb.toString());
        return outputRow;
    }

    public void addRow() {
        outputRow.add(sb.toString());
    }

    public void appendToSB(char c) {
        sb.append(c);
    }

    public void clearSB() {
        sb.delete(0, sb.length());
    }

    public void setSBError() {
        clearSB();
        sb.append("ERROR");
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getBeginFieldState() {
        return beginFieldState;
    }

    public State getErrorState() {
        return errorState;
    }

    public State getQuotedFieldState() {
        return quotedFieldState;
    }

    public State getUnquotedFieldState() {
        return unquotedFieldState;
    }

    public State getSeenAQuoteState() {
        return seenAQuoteState;
    }
}
