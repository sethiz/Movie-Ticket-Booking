package model.to;

/**
 *
 * @author Shubham Sethi
 */
public class seattypeTO {
    private int typeID;
    private String typename;
    private int charges;

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public int getCharges() {
        return charges;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        return typename + "(" + charges + ")";
    }
}
