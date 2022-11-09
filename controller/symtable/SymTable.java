package controller.symtable;

import java.util.HashMap;

public class SymTable<Key, Value> implements ISymTable<Key, Value> {

    private HashMap<Key, Value> symbols;

    public SymTable() {
        this.symbols = new HashMap<Key, Value>();
    }

    // We'll need it in order to put symbols in the table.
    @Override
    public void addSymbol(Key label, Value sym) {
        this.symbols.put(label, sym);
    }

    @Override
    public void setSymbol(Key label, Value sym) {
        this.symbols.remove(label);
        this.addSymbol(label, sym);
    }

    // We'll need it to evaluate expressions
    @Override
    public Value getSymbol(Key label) {
        Value s = this.symbols.get(label);
        return s;
    }

    @Override
    public HashMap<Key, Value> getAll() {
        return this.symbols;
    }

}
