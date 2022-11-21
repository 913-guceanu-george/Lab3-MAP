import view.View;

public class Main {
    public static void main(String[] args) {
        // IStmt st = new CompStmt("a=3;");
        // System.out.println(((CompStmt) st).getWords()[0]);
        // IStmt next = ((CompStmt) st).nextCompStmt();
        // System.out.println(((CompStmt) next).getWords()[0]);
        String program = "Int b; b = 4; Bool bol; bol = false; Print(bol); Print(\"Condition not met\"); If b Then Print(\"In fiecare zi vad garda\");";
        View view = new View(program);
        view.execute();

    }
}