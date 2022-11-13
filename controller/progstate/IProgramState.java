package controller.progstate;

import exceptions.DivisionByZero;
import exceptions.SymbolException;
import exceptions.TypeException;
// import exceptions.*;
import model.statements.*;

public interface IProgramState {

    public void nextIsAssign() throws SymbolException, TypeException, DivisionByZero;

    public IfStmt nextIsIf() throws SymbolException, TypeException, DivisionByZero;

    public PrintStmt processPrint() throws SymbolException, TypeException, DivisionByZero;

    public void nextIsDecl() throws SymbolException;

    public void nextStep() throws SymbolException, TypeException, DivisionByZero;
}
