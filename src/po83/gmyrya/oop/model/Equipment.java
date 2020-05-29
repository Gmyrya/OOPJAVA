package po83.gmyrya.oop.model;

import java.util.Objects;

public interface Equipment {

    long getEquipmentNumber();

    void setEquipmentNumber(long number);

    String getEquipmentName();

    void setEquipmentName(String name);

    EquipmentTypes getType();

    void setType(EquipmentTypes type);

    default String stringValue() {
        return String.format("%s, %s, inventory name: %d", getType(),
                getEquipmentName(), getEquipmentNumber());
    }

    default int hash() {
        return (int) (getEquipmentNumber() * getType().hashCode() * getEquipmentName().hashCode());
    }

    default boolean isEquals(Equipment equipment){
        if (this == equipment) return true;
        if (!(equipment instanceof Hardware)) return false;
        return getEquipmentNumber() == equipment.getEquipmentNumber() &&
                Objects.equals(getEquipmentName(), equipment.getEquipmentName()) &&
                getType() == equipment.getType();
    }
}
