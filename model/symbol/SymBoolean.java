package model.symbol;

public class SymBoolean implements ISymbol {
    private Boolean value;
    private String type;
    private String label;

    public SymBoolean(Boolean val, String label) {
        this.setType("Bool");
        this.value = val;
        this.setLabel(label);
    }

    public void setValue(Boolean val) {
        this.value = val;
    }

    public Boolean getValue() {
        return this.value;
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

    @Override
    public String toString() {
        if (this.value == null) {
            return "No value assigned";
        }
        return this.type + ": " + this.value.toString();
    }

}
