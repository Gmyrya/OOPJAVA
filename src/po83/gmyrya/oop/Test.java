package po83.gmyrya.oop;
import po83.gmyrya.oop.model.*;

/**
 * @author Gmyrya Alexandr
 */
public class Test {
    public static void main(String[] args) {
        lab1test();
        System.out.println("\n\nЛабораторная 2");
        lab2test();
        System.out.println("\n\nЛабораторная 3");
        lab3test();
    }

    public static void lab1test() {
        Department department1 = new Department();
        Department department2 = new Department("Test");
        Department department3 = new Department("Hello");
        Department department4 = new Department("HiHi");
        Department department5 = new Department("OlOlolo");
        Department[] departments = new Department[]{department1, department2,
                department3, department4, department5};

        DepartmentManager manager = new DepartmentManager(departments);
        manager.add(5, new Department("6"));
        manager.add(3, new Department("7"));
        System.out.println(manager.getSize());
        System.out.println(manager.get(2).getName());
        System.out.println(manager.get("HiHi").getName());
        System.out.println(manager.get("Null"));
        System.out.println(manager.remove(2).getName());
        System.out.println(manager.remove("HiHi").getName());

        System.out.println("\n\n");
        for (int i = 0; i < manager.getSize(); i++) {
            System.out.println(i + "-ый элемент массива: " + manager.get(i).getName());
        }
    }

    public static void lab2test() {
        Equipment equipment = new Hardware(2);
        Equipment equipment1 = new Furniture(1, "Test");
        Equipment equipment2 = new Hardware(2, "Hello");
        Equipment equipment3 = new Furniture(2, "Test");
        Equipment equipment4 = new Hardware(3, "Test");
        Equipment[] equipments = new Equipment[]{equipment, equipment1,
                equipment2, equipment3, equipment4};

        Department department = new Department(equipments);
        department.add(new Furniture(4, "Lof"));
        System.out.println(department.getCountItemsByName("Test"));
        System.out.println(department.remove(5).getEquipmentName());

        Equipment[] equipmentsTest = department.toArray("Test");
        for (Equipment equip : equipmentsTest) {
            System.out.println(equip.getEquipmentName());
        }
    }

    public static void lab3test() {
        Equipment equipment = new Hardware(2);
        Equipment equipment1 = new Furniture(1, "Test");
        Equipment equipment2 = new Hardware(2, "Hello");
        Equipment equipment3 = new Furniture(2, "Test");
        Equipment equipment4 = new Hardware(3, "Test");
        Equipment[] equipments = new Equipment[]{equipment, equipment1,
                equipment2, equipment3, equipment4};

        Department department = new Department(equipments);

        equipment = new Hardware(4);
        equipment1 = new Furniture(1, "Hi");
        equipment2 = new Hardware(2, "Lof");
        equipment3 = new Furniture(2, "Hi");
        equipment4 = new Hardware(3, "Test");
        equipments = new Equipment[]{equipment, equipment1,
                equipment2, equipment3, equipment4};

        Department department1 = new Department(equipments);

        EquipmentManager manager = new EquipmentManager(new Department[]{department, department1});
        System.out.println(manager.getDepartmentWithEquipment(2));
        System.out.println(manager.remove(4L).getEquipmentName());
        System.out.println(manager.set(3, new Hardware(1, "Hahohi")).getEquipmentName());

        equipments = manager.getTypedEquipments(EquipmentTypes.OTHER);

        for (int i = 0; i < equipments.length; i++) {
            System.out.println(equipments[i].getEquipmentName());
        }

    }
}
