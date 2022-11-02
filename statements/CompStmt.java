package statements;

public class CompStmt implements IStmt {
    private String type;
    private String contents;

    CompStmt(String contents) {
        this.type = "CompStmt";
        this.contents = contents;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String[] getWords() {
        // This will get us all the statements
        return this.contents.split(";");
    }

    public String getStmt() {
        // This will get us the first statement from the compund statement
        // Return model: "Stmt"
        return this.contents.split(";")[0];
    }
}