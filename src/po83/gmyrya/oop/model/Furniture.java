package po83.gmyrya.oop.model;

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
}
