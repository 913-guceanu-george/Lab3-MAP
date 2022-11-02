package evaluation;

import symbol.*;

public class Eval {
    // We have to return null as a non boolean type, in case the eval fails,
    // so we cast it to a variable

    /**
     *
     */
    private static final Boolean BOOLEAN = (Boolean) null;

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

    public static int evalInt(ISymbol sym) {
        if (Eval.isInt(sym) == true) {
            SymInteger s = (SymInteger) sym;
            return s.getValue();
        }
        return -1;
    }

    public static boolean evalBool(ISymbol sym) {
        if (Eval.isBool(sym) == true) {
            SymBoolean s = (SymBoolean) sym;
            return s.getValue();
        }
        return BOOLEAN;
    }
}
