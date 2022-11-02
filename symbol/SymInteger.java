package symbol;

public class SymInteger implements ISymbol {
    private Integer value;
    private String label;
    private String type;

    SymInteger(Integer val, String label) {
        this.setType("int");
        this.value = val;
        this.setLabel(label);
    }

    public int getValue() {
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
    public Boolean getValueBool() {
        return (Boolean) null;
    }

    @Override
    public Integer getValueInt() {
        return this.value;
    }
}
