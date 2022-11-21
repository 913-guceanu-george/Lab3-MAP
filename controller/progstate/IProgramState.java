package controller.progstate;

import exceptions.*;

public interface IProgramState {

    public void nextIsAssign() throws SymbolException, TypeException, DivisionByZero;

    public String nextIsIf() throws SymbolException, TypeException, DivisionByZero, StmtException;

    public String nextIsPrint() throws SymbolException, TypeException, DivisionByZero;

    public void nextIsDecl() throws SymbolException;

    public void nextStep() throws SymbolException, TypeException, DivisionByZero, StmtException;
}
