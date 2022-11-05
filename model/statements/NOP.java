package model.statements;

public class NOP implements IStmt {

    @Override
    public final String getType() {
        // No type for the No Operation stmt
        return "NOP";
    }

    @Override
    public String[] getWords() {
        // No words for the No Operation stmt
        return null;
    }

}
