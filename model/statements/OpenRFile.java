package model.statements;

import model.symbol.SymString;

public class OpenRFile implements IStmt {

    private String type;
    private SymString contents;

    public OpenRFile(SymString contents) {
        this.type = "OpenRFile";
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
        // Expression: openRFile(exp) ->
        String[] words = this.getContents().split("\\(");
        words[1] = words[1].split("\\)")[0];
        // -> String[] = ["openRFile", "exp"]
        return words;
    }

}
