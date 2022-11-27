package model.statements;

import model.symbol.SymString;

public class CloseRFile implements IStmt {

    private String type;
    private SymString contents;

    public CloseRFile(SymString contents) {
        this.type = "CloseRFile";
        this.contents = new SymString(contents.getLabel(), contents.getValue());
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getContents() {
        return this.contents.getValue();
    }

    @Override
    public String[] getWords() {
        // Expression: closeRFile(exp) ->
        String[] words = this.getContents().split("\\(");
        words[1] = words[1].split("\\)")[0];
        // -> String[] = ["closeRFile", "exp"]
        return words;
    }

}
