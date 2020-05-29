package po83.gmyrya.oop.model;

public class Department {

    private String name;
    private Node head, tail;
    private int size;

    public Department() {
        name = "";
        head = new Node();
        tail = new Node();
    }

    public Department(String name) {
        this.name = name;
        head = new Node();
        tail = new Node();
    }

    public Department(Equipment[] equipments) {
        name = "";
        for (Equipment equipment : equipments) {
            addNode(equipment);
        }
    }

    public boolean add(Equipment equipment) {
        return addNode(equipment);
    }

    public boolean add(int index, Equipment equipment) {
        return addNode(index, equipment);
    }

    public Equipment get(int index) {
        return getNodeByIndex(index).value;
    }

    public Equipment getByID(long equipmentNumber) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value.getEquipmentNumber() == equipmentNumber) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null;
    }

    public int getIndex(long equipmentNumber) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.value.getEquipmentNumber() == equipmentNumber) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean equipmentExist(long equipmentNumber) {
        Equipment equipment = getByID(equipmentNumber);
        return equipment != null;
    }

    public boolean equipmentExist(String equipmentName) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (head.value.getEquipmentName() == equipmentName) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Equipment set(int index, Equipment equipment) {
        return setNode(index, equipment);
    }

    public Equipment remove(int index) {
        return removeNode(index);
    }

    public Equipment removeByID(long equipmentNumber) {
        return removeNode(getIndex(equipmentNumber));
    }

    public Equipment[] toArray() {
        Node temp = head;
        Equipment[] equipment = new Equipment[size];
        for (int i = 0; i < size; i++) {
            equipment[i] = temp.value;
            temp = temp.next;
        }
        return equipment;
    }

    public Equipment[] toArray(String equipmentName) {
        Node temp = head;
        Equipment[] equipments = new Equipment[getCountItemsByName(equipmentName)];
        int index=0;
        for (int i = 0; i < size; i++) {
            if (temp.value.getEquipmentName().equals(equipmentName)) {
                equipments[index++] = temp.value;
            }
            temp = temp.next;
        }
        return equipments;
    }

    public int getCountItemsByName(String equipmentName) {
        Node temp = head;
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (temp.value.getEquipmentName().equals(equipmentName)) {
                count++;
            }
            temp = temp.next;
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    private boolean addNode(Equipment equipment) {
        if (this.head == null) {
            head = new Node(equipment, null, null);
        } else {
            Node prevElement = this.tail == null ? this.head : this.tail;
            this.tail = new Node(equipment, null, prevElement);
            prevElement.next = this.tail;
        }
        this.size++;
        return true;
    }

    private boolean addNode(int index, Equipment equipment) {
        if (index > size || index < 0 || equipment == null) {
            return false;
        }
        if (index == size) {
            return addNode(equipment);
        }
        Node oldElement = getNodeByIndex(index);
        Node newElement = new Node(equipment, oldElement, oldElement.prev);
        if (oldElement.prev == null) {
            this.head = newElement;
            this.tail = oldElement;
        } else {
            oldElement.prev.next = newElement;
            oldElement.prev = newElement;
        }
        this.size++;
        return true;
    }

    private Node getNodeByIndex(int index) {
        Node result;
        if (this.size >> 1 >= index) {
            result = this.head;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = this.tail;
            for (int i = this.size - 1; i > index; i--) {
                result = result.prev;
            }
        }
        return result;
    }

    private Equipment removeNode(int index) {
        if (index > size || index < 0) {
            return null;
        }
        return removeNode(getNodeByIndex(index));
    }

    private Equipment removeNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.next == null && node.prev == null) {
            head = null;
            tail = null;
        } else if (node.prev == null) {
            head = node.next;
            tail.prev = null;
        } else if (node.next == null) {
            tail = node.prev;
            tail.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
        return node.value;
    }

    private Equipment setNode(int index, Equipment equipment) {
        if (index > size || index < 0 || equipment == null) {
            return null;
        }
        Node temp = getNodeByIndex(index);
        Equipment oldEquipment = temp.value;
        temp.value = equipment;
        return oldEquipment;
    }

    private class Node {
        Equipment value;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(Equipment value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
