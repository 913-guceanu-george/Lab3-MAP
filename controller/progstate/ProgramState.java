package controller.progstate;

import controller.evaluation.Eval;
import controller.exestack.ExeStack;
import controller.exestack.MyDeque;
import controller.symtable.SymTable;
import exceptions.*;
import model.statements.*;
import model.symbol.ISymbol;
import model.symbol.SymInteger;

public class ProgramState implements IProgramState {

    // TODO - analyze all cases for each Statement

    private SymTable<String, ISymbol> table;
    private ExeStack stack;
    private MyDeque<String> output;

    public ProgramState(String program) {
        this.table = new SymTable<String, ISymbol>();
        this.stack = new ExeStack();
        this.output = new MyDeque<String>();
        this.stack.addLast(new CompStmt(program));
    }

    @Override
    public AssignStmt processAssign() throws SymbolException, TypeException, DivisionByZero {
        CompStmt comp = (CompStmt) this.stack.removeLast();
        String assignContent = comp.getStmt();
        comp = comp.nextCompStmt();
        this.stack.addLast(comp);
        AssignStmt stmt = new AssignStmt(assignContent);
        this.stack.addFirst(stmt);
        String[] exp = stmt.getWords();
        if (Eval.isAssignStmt(stmt)) { // First we check if it's an assign statement
            try {
                ISymbol sym = Eval.lookUp(table, exp[0]); // We get the symbol, lookUp automatically checks if it's in
                                                          // the table
                if (Eval.isInt(sym)) { // If our symbol is an integer
                    Integer rez = 0;
                    if (exp.length == 3) { // If it's just a simple assignment
                        rez = Eval.isNumeric(exp[2]);
                        if (rez != null) { // Checking if we are assigning a variable only a value
                            this.table.setSymbol(sym.getLabel(), new SymInteger(rez, sym.getLabel()));
                            return stmt;
                        } else { // If it's not a value, than it is the value of another variable
                            rez = ((SymInteger) Eval.lookUp(table, exp[2])).getValue();
                            this.table.setSymbol(sym.getLabel(), new SymInteger(rez, sym.getLabel()));
                            return stmt;
                        }
                    } else { // If it's a compund assingment
                        // First value of the assignment
                        rez = Eval.isNumeric(exp[2]);
                        if (rez == null)
                            rez = ((SymInteger) Eval.lookUp(table, exp[2])).getValue();
                        // Rest of the values
                        for (int i = 3; i < exp.length - 1; i = i + 2) {
                            ISymbol s2 = Eval.lookUp(table, exp[i + 1]);
                            if (s2 != null) {
                                rez += Eval.evalArithemtic(new SymInteger(rez, ""), s2, exp[i]);
                            } else {
                                rez += Eval.evalArithemtic(new SymInteger(rez, ""),
                                        new SymInteger(Eval.isNumeric(exp[i + 1]), ""), exp[i]);
                            }
                        }
                        this.table.setSymbol(sym.getLabel(), new SymInteger(rez, sym.getLabel()));
                        return stmt;

                    }
                }
            } catch (SymbolException e) {
                throw new SymbolException(e.getMessage());
            } catch (DivisionByZero d) {
                throw new DivisionByZero(d.getMessage());
            } catch (TypeException t) {
                throw new TypeException(t.getMessage());
            }
        }
        return (AssignStmt) null;
    }

    @Override
    public VarDecl processDecl() {
        return (VarDecl) null;
    }

    @Override
    public IfStmt processIf() {
        return (IfStmt) null;
    }

    @Override
    public PrintStmt processPrint() {
        return (PrintStmt) null;
    }

    @Override
    public void nextStep() {

    }
}
