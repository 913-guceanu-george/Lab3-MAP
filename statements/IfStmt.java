package statements;

public class IfStmt implements IStmt {
    private String type;
    private String contents;

    IfStmt(String contents) {
        this.type = "IfStmt";
        this.contents = contents;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String[] getWords() {
        // Return model: "If" + exp1 + "Then" + exp2 + "Else" + exp3
        return this.contents.split(" ");
    }

}
