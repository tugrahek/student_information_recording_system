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
    
    public Node getHead() {
    return head;
}

    public Node getTail() {
        return tail;
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
    if (head == null) {
        System.out.println("The list is empty.");
        return;
    }

    System.out.println("\n===== Students in Ascending Order =====");
    System.out.printf("%-12s %-25s %-40s%n", "Student ID", "Full Name", "Phone Numbers");
    System.out.println("----------------------------------------------------------------------------");

    Node current = head;

    while (current != null) {
        Student s = current.student;

        System.out.printf("%-12d %-25s %-40s%n",
                s.getStudentID(),
                s.getFullName(),
                s.getPhoneNumbers());

        current = current.next;
    }
}

public void printBackward() {
    if (tail == null) {
        System.out.println("The list is empty.");
        return;
    }

    System.out.println("\n===== Students in Descending Order =====");
    System.out.printf("%-12s %-25s %-40s%n", "Student ID", "Full Name", "Phone Numbers");
    System.out.println("----------------------------------------------------------------------------");

    Node current = tail;

    while (current != null) {
        Student s = current.student;

        System.out.printf("%-12d %-25s %-40s%n",
                s.getStudentID(),
                s.getFullName(),
                s.getPhoneNumbers());

        current = current.prev;
    }
}

public void clear() {
    head = null;
    tail = null;
    size = 0;
}
}
