package model.symbol;

public class SymString implements ISymbol {

    private String label;
    private String value;
    private String type;

    public SymString(String label, String value) {
        this.type = "String";
        this.label = label;
        this.value = new String(value);
    }

    public SymString(String label) {
        this.type = "String";
        this.label = label;
        this.defaultValue();
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    public void setValue(String value) {
        this.value = new String(value);
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public void defaultValue() {
        this.setValue(null);
    }
}
