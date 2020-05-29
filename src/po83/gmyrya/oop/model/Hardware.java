package po83.gmyrya.oop.model;

import java.util.Objects;

public class Hardware implements Equipment {

    private long number;
    private String name;
    private EquipmentTypes type;

    public static final String HARDWARE = "Hardware";

    public Hardware(long number) {
        this(number, HARDWARE);
    }

    public Hardware(long number, String name) {
        this.number = number;
        this.name = name;
        type = EquipmentTypes.OTHER;
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
        return String.format("Hardware: %s, %s, inventory name: %d", type, name, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hardware)) return false;
        Hardware hardware = (Hardware) o;
        return number == hardware.number &&
                Objects.equals(name, hardware.name) &&
                type == hardware.type;
    }

    @Override
    public int hashCode() {
        int result = (int) (53 * number);
        result = 53 * name.hashCode();
        result = 53 * type.hashCode();
        return result;
    }
}
