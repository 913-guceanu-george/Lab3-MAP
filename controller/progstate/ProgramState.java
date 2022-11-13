package controller.progstate;

import javax.xml.catalog.Catalog;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import controller.evaluation.Eval;
import controller.exestack.ExeStack;
import controller.exestack.MyDeque;
import controller.symtable.SymTable;
import exceptions.*;
import model.statements.*;
import model.symbol.ISymbol;
import model.symbol.SymBoolean;
import model.symbol.SymInteger;

public class ProgramState implements IProgramState {

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
    public void nextIsAssign() throws SymbolException, TypeException, DivisionByZero {
        CompStmt comp = (CompStmt) this.stack.getLast();
        String assignContent = comp.getStmt();
        try {
            CompStmt nexCompStmt = comp.nextCompStmt();
            AssignStmt stmt = new AssignStmt(assignContent);
            AssignStmt astmt = Eval.processAssign(table, stmt);
            if (astmt == null)
                return;
            this.stack.removeLast();
            this.stack.addLast(nexCompStmt);
            this.stack.addFirst(astmt);
        } catch (SymbolException s) {
            throw new SymbolException(s.getMessage());
        } catch (TypeException t) {
            throw new TypeException(t.getMessage());
        } catch (DivisionByZero d) {
            throw new DivisionByZero(d.getMessage());
        }
    }

    @Override
    public void nextIsDecl() throws SymbolException {
        CompStmt comp = (CompStmt) this.stack.getLast();
        String declContent = comp.getStmt();
        try {
            VarDecl v = new VarDecl(declContent);
            VarDecl dstmt = Eval.processDecl(table, v);
            if (dstmt == null)
                return;
            this.stack.removeLast();
            this.stack.addLast(comp.nextCompStmt());
            this.stack.addFirst(v);
        } catch (SymbolException s) {
            throw new SymbolException(s.getMessage());
        }
    }

    @Override
    public IfStmt nextIsIf() throws SymbolException, TypeException, DivisionByZero {
        // TODO - Do a conditional evaluation in Eval
        CompStmt comp = (CompStmt) this.stack.removeLast();
        String condContent = comp.getStmt();
        this.stack.addLast(comp.nextCompStmt());
        IfStmt conditional = new IfStmt(condContent);
        this.stack.addFirst(conditional);
        String[] exp = conditional.getWords();
        if (Eval.isIfStmt(conditional)) {
            if (exp.length == 4) {
                try {
                    // Second string from the exp will be our condition, which will be a variable
                    // and we have to evaluate it
                    ISymbol sym = Eval.lookUp(table, exp[1]);
                    if (Eval.isBool(sym)) {
                        // We'll now look at realistic use cases for the conditional stmt
                        // First one we check is assign stmt
                        if (Eval.isAssignStmt(new AssignStmt(exp[3]))) {

                        }
                    }
                } catch (SymbolException s) {
                    throw new SymbolException(s.getMessage());
                } catch (TypeException t) {
                    throw new TypeException(t.getMessage());
                } catch (DivisionByZero d) {
                    throw new DivisionByZero(d.getMessage());
                }
            }
        }
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
