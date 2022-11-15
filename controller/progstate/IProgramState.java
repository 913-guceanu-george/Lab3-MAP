package controller.progstate;

import exceptions.*;

public interface IProgramState {

    public void nextIsAssign() throws SymbolException, TypeException, DivisionByZero;

    public void nextIsIf() throws SymbolException, TypeException, DivisionByZero, StmtException;

    public void nextIsPrint() throws SymbolException, TypeException, DivisionByZero;

    public void nextIsDecl() throws SymbolException;

    public void nextStep() throws SymbolException, TypeException, DivisionByZero, StmtException;
}
