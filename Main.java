import view.View;

public class Main {
    public static void main(String[] args) {
        // IStmt st = new CompStmt("a=3;");
        // System.out.println(((CompStmt) st).getWords()[0]);
        // IStmt next = ((CompStmt) st).nextCompStmt();
        // System.out.println(((CompStmt) next).getWords()[0]);
        String program = "Int b; b = 2 + 3; Int c; c = 2; b = 3 * c; Bool bol; bol = false and true; Print(bol); Print(\"Condition not met\"); If bol Then Print(\"In fiecare zi vad garda\") Else b = 1;";
        View view = new View(program);
        view.execute();

    }
}