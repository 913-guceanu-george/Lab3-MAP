package model.symbol;

public class SymInteger implements ISymbol {
    private Integer value;
    private String label;
    private String type;

    public SymInteger(Integer val, String label) {
        this.setType("Int");
        this.value = val;
        this.setLabel(label);
    }

    public void setValue(Integer val) {
        this.value = val;
    }

    public Integer getValue() {
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
