package model.statements;

import model.symbol.SymString;

public class ReadFile implements IStmt {

    private String type;
    private SymString contents;

    public ReadFile(SymString contents) {
        this.type = "ReadFile";
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
        String[] words = new String[3];
        words[0] = this.contents.getValue().split("\\(")[0];
        words[1] = this.contents.getValue().split("\\(")[1].split(", ")[0];
        words[2] = this.contents.getValue().split("\\(")[1].split(", ")[1].split("\\)")[0];
        return words;
    }

}
