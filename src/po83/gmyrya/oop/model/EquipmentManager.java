package po83.gmyrya.oop.model;

import java.util.ArrayList;
import java.util.Arrays;

public class EquipmentManager extends DepartmentManager {

    public EquipmentManager() {
        super();
    }

    public EquipmentManager(int size) {
        super(size);
    }

    public EquipmentManager(Department[] departments) {
        super(departments);
    }

    public Department getDepartmentWithEquipment(long number) {
        for (Department department : getDepartments()) {
            if (department.getByID(number) != null) {
                return department;
            }
        }
        return null;
    }

    public Equipment set(long number, Equipment equipment) {
        for (Department department : getDepartments()) {
            if (department.getByID(number) != null) {
                return department.set(department.getIndex(number), equipment);
            }
        }
        return null;
    }

    public Equipment remove(long number) {
        for (Department department : getDepartments()) {
            Equipment buf = department.removeByID(number);
            if (buf != null) return buf;
        }
        return null;
    }

    public boolean remove(Equipment equipment) {
        return remove(equipment.getEquipmentNumber()) != null;

    }

    public Equipment[] getTypedEquipments(EquipmentTypes type) {
        ArrayList<Equipment> buf = new ArrayList<>();
        for (Department department : getDepartments()) {
            Equipment[] tmp = department.toArray(type);
            if (tmp != null) {
                buf.addAll(Arrays.asList(tmp));
            }
        }
        return buf.toArray(new Equipment[]{});
    }
}
