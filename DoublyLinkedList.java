package student_information_recording_system;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //adding
    public void addFirst(Student student) {
        Node newNode = new Node(student);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(Student student) {
        Node newNode = new Node(student);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, Student student) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            addFirst(student);
            return;
        }
        if (index == size) {
            addLast(student);
            return;
        }

        Node newNode = new Node(student);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node prevNode = current.prev;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = current;
        current.prev = newNode;
        size++;
    }

    // removing
    public Student removeFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException("Liste boş.");
        }
        Student data = head.student;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        size--;
        return data;
    }

    public Student removeLast() {
        if (tail == null) {
            throw new java.util.NoSuchElementException("Liste boş.");
        }
        Student data = tail.student;
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return data;
    }

    public Student remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
        return current.student;
    }

    // traversal
    public void printForward() {
        Node current = head;
        System.out.print("HEAD ↔ ");
        while (current != null) {
            System.out.print(current.student);
            if (current.next != null) {
                System.out.print(" ↔ ");
            }
            current = current.next;
        }
        System.out.println(" ↔ TAIL");
    }

    public void printBackward() {
        Node current = tail;
        System.out.print("TAIL ↔ ");
        while (current != null) {
            System.out.print(current.student);
            if (current.prev != null) {
                System.out.print(" ↔ ");
            }
            current = current.prev;
        }
        System.out.println(" ↔ HEAD");
    }
}
