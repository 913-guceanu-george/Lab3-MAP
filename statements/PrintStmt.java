package statements;

public class PrintStmt implements IStmt {
    private String type;
    private String contents;

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String[] getWords() {
        // Return model1: Print + "exp)"
        // Return model2: Print + "Symbol)"
        return this.contents.split("(");
    }

}
