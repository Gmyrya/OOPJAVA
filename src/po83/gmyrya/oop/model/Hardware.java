package po83.gmyrya.oop.model;

public class Hardware implements Equipment {

    private long number;
    private String name;

    public static final String HARDWARE = "Hardware";

    public Hardware(long number) {
        this(number, HARDWARE);
    }

    public Hardware(long number, String name) {
        this.number = number;
        this.name = name;
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
}
