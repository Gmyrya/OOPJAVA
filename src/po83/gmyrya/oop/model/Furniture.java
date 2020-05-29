package po83.gmyrya.oop.model;

import java.util.Objects;

public class Furniture implements Equipment {

    private long number;
    private String name;
    private EquipmentTypes type;

    public static final String FURNITURE = "Furniture";

    public Furniture(long number) {
        this(number, FURNITURE);
    }

    public Furniture(long number, String name) {
        this.name = name;
        this.number = number;
        type=EquipmentTypes.OTHER;
    }

    @Override
    public long getEquipmentNumber() {
        return number;
    }

    @Override
    public void setEquipmentNumber(long number) {
        this.number = number;
    }

    @Override
    public String getEquipmentName() {
        return name;
    }

    @Override
    public void setEquipmentName(String name) {
        this.name = name;
    }

    @Override
    public EquipmentTypes getType() {
        return type;
    }

    @Override
    public void setType(EquipmentTypes type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("“Furniture: %s, %s, inventory name: %d", type, name, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Furniture)) return false;
        Furniture furniture = (Furniture) o;
        return number == furniture.number &&
                Objects.equals(name, furniture.name) &&
                type == furniture.type;
    }

    @Override
    public int hashCode() {
        int result = (int) (71 * number);
        result = 71 * name.hashCode();
        result = 71 * type.hashCode();
        return result;
    }
}
