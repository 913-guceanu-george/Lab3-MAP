package model.statements;

public class IfStmt implements IStmt {
    private String type;
    private String contents;

    public IfStmt(String contents) {
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
        // String[] exp = this.contents.split(" ");
        // String firstExp = "";
        // String secondExp = "";
        // int i = 1;
        // // Computing the first 2 expressions
        // while (exp[i] != "Then") {
        // firstExp += exp[i] + " ";
        // }
        // i++;
        // while (exp[i] != "Else" || i < exp.length) {
        // secondExp += exp[i] + " ";
        // }
        // if (i == exp.length) {
        // String[] finalExp = new String[4];
        // finalExp[0] = "If";
        // finalExp[1] = firstExp;
        // finalExp[2] = "Then";
        // finalExp[3] = secondExp;
        // return finalExp;
        // }
        // // Computing the third one, if it exists
        // i++;
        // String thirdExp = "";
        // while (i < exp.length - 1) {
        // thirdExp += exp[i] + " ";
        // }
        // String[] finalExp = new String[6];
        // finalExp[0] = "If";
        // finalExp[1] = firstExp;
        // finalExp[2] = "Then";
        // finalExp[3] = secondExp;
        // finalExp[4] = "Else";
        // finalExp[5] = thirdExp;
        // return finalExp;
        return this.contents.split(" ");
    }

    @Override
    public String getContents() {
        return this.contents;
    }

}
