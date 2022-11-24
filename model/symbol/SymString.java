package model.symbol;

public class SymString implements ISymbol {

    private String label;
    private String value;
    private String type;

    public SymString(String label, String value) {
        this.setType("String");
        this.setLabel(label);
        this.value = new String(value);
    }

    public SymString(String label) {
        this.setType("String");
        this.defaultValue();
        this.setLabel(label);
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
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
