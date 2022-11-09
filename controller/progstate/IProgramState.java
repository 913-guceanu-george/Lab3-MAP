package controller.progstate;

import exceptions.DivisionByZero;
import exceptions.SymbolException;
import exceptions.TypeException;
// import exceptions.*;
import model.statements.*;

public interface IProgramState {

    public AssignStmt processAssign() throws SymbolException, TypeException, DivisionByZero;

    public IfStmt processIf();

    public PrintStmt processPrint();

    public VarDecl processDecl();

    public void nextStep();
}
