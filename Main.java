import view.View;
// import model.statements.*;
// import model.symbol.SymString;

public class Main {
    public static void main(String[] args) {
        // Actual program
        String program = "String exp; exp = \"test.in\"; Int b; b = 2 + 3; Int c; c = 2; b = 3 * c; Bool bol; bol = true; Print(bol); Print(\"Condition not met\"); If c > b Then Print(\"In fiecare zi vad garda\") Else b = 1;";
        View view = new View(program);
        view.execute();
    }
}