package po83.gmyrya.oop.model;
import po83.gmyrya.oop.model.Department;

public class DepartmentManager {

    private Department[] departments;
    private int size;

    public DepartmentManager() {
        departments = new Department[16];
        size = 0;
    }

    public DepartmentManager(int size) {
        departments = new Department[size];
        this.size = 0;
    }

    public DepartmentManager(Department[] departments) {
        this.departments = departments;
        this.size = departments.length;
    }

    public boolean add(Department department) {
        if (!hasSpace()) {
            extend();
        }
        departments[size++] = department;
        return true;
    }

    private boolean hasSpace() {
        return size != departments.length;
    }

    private void extend() {
        Department[] deps = new Department[departments.length * 2];
        for (int i = 0; i < departments.length; i++) {
            deps[i] = departments[i];
        }
        departments = deps;
    }

    public boolean add(int index, Department department) {
        if (!hasSpace()) {
            extend();
        }
        if (index == size) {
            departments[size++] = department;
            return true;
        }
        for (int i = size++; i > index; i--) {
            departments[i] = departments[i - 1];
        }
        departments[index] = department;
        return true;
    }

    public Department get(int index) {
        return departments[index];
    }

    public Department get(String name) {
        for (int i = 0; i < size; i++) {
            if (departments[i].getName().equals(name)) {
                return departments[i];
            }
        }
        return null;
    }

    public Department set(int index, Department department) {
        if (index > size - 1 || index < 0 || department == null) {
            return null;
        }
        Department buffer = departments[index];
        departments[index] = department;
        return buffer;
    }

    public Department remove(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        Department buffer = departments[index];
        for (int i = index; i < size - 1; i++) {
            departments[i] = departments[i + 1];
        }
        departments[size--] = null;
        return buffer;
    }

    public Department remove(String name) {
        for (int i = 0; i < size; i++) {
            if (departments[i].getName().equals(name)) {
                return remove(i);
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public Department[] getDepartments() {
        Department[] copyDepartments = new Department[size];
        for (int i = 0; i < size; i++) {
            copyDepartments[i] = departments[i];
        }
        return copyDepartments;
    }
}
