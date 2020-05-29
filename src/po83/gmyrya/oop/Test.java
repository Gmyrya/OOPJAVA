package po83.gmyrya.oop;
import po83.gmyrya.oop.model.Department;
import po83.gmyrya.oop.model.DepartmentManager;

/**
 * @author Gmyrya Alexandr
 */
public class Test {
    public static void main(String[] args) {
        lab1test();
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
}
