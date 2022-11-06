package controller.evaluation;

import controller.symtable.SymTable;
import exceptions.SymbolException;
import model.statements.*;
import model.symbol.*;

public class Eval {

    public static ISymbol lookUp(SymTable<String, ISymbol> table, String label) throws SymbolException {
        ISymbol symbol = table.getSymbol(label);
        if (symbol == null) {
            throw new SymbolException("Symbol" + label + "is not defined.");
        }
        return symbol;
    }

    public static boolean isInt(ISymbol sym) {
        if (sym.getType() == "int") {
            return true;
        }
        return false;
    }

    public static boolean isBool(ISymbol sym) {
        if (sym.getType() == "bool") {
            return true;
        }
        return false;
    }

    /**
     * @param statement
     * @return false if the stmt is not compound or is an empty compound.
     */
    public static boolean isCompStmt(IStmt statement) {
        if (statement.getType() == "CompStmt") {
            if (((CompStmt) statement).getWords()[0] == "")
                return false;
            return true;
        }
        return false;
    }

    public static boolean isIfStmt(IStmt statement) {
        if (statement.getType() == "IfStmt") {
            if (statement.getWords()[0] == "If") {
                return true;
            }
        }
        return false;

    }

    public static boolean isAssignStmt(IStmt statement) {
        if (statement.getType() == "AssignStmt") {
            if (statement.getWords()[1] == "=") {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrintStmt(IStmt statement) {
        if (statement.getType() == "PrintStmt") {
            if (statement.getWords()[0] == "Print") {
                return true;
            }
        }
        return false;
    }

    public static boolean isVarDecl(IStmt statement) {
        if (statement.getType() == "VarDecl") {
            if (statement.getWords()[0] == "Int" || statement.getWords()[0] == "Bool") {
                return true;
            }
        }
        return false;
    }
}
