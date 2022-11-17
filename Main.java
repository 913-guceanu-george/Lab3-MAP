import view.View;

public class Main {
    public static void main(String[] args) {
        // IStmt st = new CompStmt("a=3;");
        // System.out.println(((CompStmt) st).getWords()[0]);
        // IStmt next = ((CompStmt) st).nextCompStmt();
        // System.out.println(((CompStmt) next).getWords()[0]);
        String program = "Print(\"Not here\"); If b Then print(a) Else print(\"Condition not met\");";
        View view = new View(program);
        view.execute();

    }
}