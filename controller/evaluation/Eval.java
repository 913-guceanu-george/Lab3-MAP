package controller.evaluation;

import controller.symtable.SymTable;
import exceptions.DivisionByZero;
import exceptions.SymbolException;
import exceptions.TypeException;
import model.statements.*;
import model.symbol.*;

public class Eval {

    public static ISymbol lookUp(SymTable<String, ISymbol> table, String label) throws SymbolException {
        ISymbol symbol = table.getSymbol(label);
        if (symbol == null) {
            throw new SymbolException("Symbol is not in table");
        }
        return symbol;

    }

    // Evaluating the Integer symbols
    public static boolean isInt(ISymbol sym) {
        if (sym.getType() == "Int") {
            return true;
        }
        return false;
    }

    public static Integer evalInt(ISymbol sym) {
        if (Eval.isInt(sym)) {
            return ((SymInteger) sym).getValue();
        }
        return null;
    }

    // Evaluating the Boolean symbols
    public static boolean isBool(ISymbol sym) {
        if (sym.getType() == "Bool") {
            return true;
        }
        return false;
    }

    public static Boolean evalBoolean(ISymbol sym) {
        if (Eval.isBool(sym)) {
            return ((SymBoolean) sym).getValue();
        }
        return null;
    }

    // Is numeric and Is boolean functions
    public static Integer isNumeric(String strNum) {
        Integer num;
        if (strNum == null) {
            return null;
        }
        try {
            num = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return null;
        }
        return num;
    }

    public static Boolean isBoolean(String strBool) {
        if (strBool == null) {
            return null;
        }
        Boolean b;
        try {
            b = Boolean.parseBoolean(strBool);
        } catch (NumberFormatException nfe) {
            return null;
        }
        return b;
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

    public static Integer evalArithemtic(ISymbol sym1, ISymbol sym2, String operator)
            throws DivisionByZero, TypeException {
        if (sym1.getType() == "Int") {
            if (sym2.getType() == "Int") {
                Integer nr1 = ((SymInteger) sym1).getValue();
                Integer nr2 = ((SymInteger) sym2).getValue();
                if (operator == "+") {
                    return nr1 + nr2;
                }
                if (operator == "*") {
                    return nr1 * nr2;
                }
                if (operator == "-") {
                    return nr1 - nr2;
                }
                if (operator == "/") {
                    if (nr2 != 0) {
                        return nr1 / nr2;
                    }
                    throw new DivisionByZero("Cannot divide by zero!");
                }
            }
            throw new TypeException("Operands are not of same type");
        }
        throw new TypeException("Operands are not of same type");
    }

    public static Boolean evalLogical(ISymbol sym1, ISymbol sym2, String operator) throws TypeException {
        if (sym1.getType() == "Bool") {
            if (sym2.getType() == "Bool") {
                Boolean s1 = ((SymBoolean) sym1).getValue();
                Boolean s2 = ((SymBoolean) sym2).getValue();
                if (operator == "and") {
                    return s1 && s2;
                }
                if (operator == "or") {
                    return s1 || s2;
                }
            }
            throw new TypeException("Operands are not of same type");
        }
        throw new TypeException("Operands are not of same type");

    }
}
