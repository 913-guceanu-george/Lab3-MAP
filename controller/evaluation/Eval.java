package controller.evaluation;

import controller.symtable.SymTable;
import exceptions.SymbolException;
import model.symbol.*;

public class Eval {

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

    public static ISymbol lookUp(SymTable<String, ISymbol> table, String label) throws SymbolException {
        ISymbol symbol = table.getSymbol(label);
        if (symbol == null) {
            throw new SymbolException("Symbol" + label + "is not defined.");
        }
        return symbol;
    }

}
