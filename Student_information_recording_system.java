package student_information_recording_system;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Student_information_recording_system {

    private static final Scanner input = new Scanner(System.in);
    private static final DoublyLinkedList list = new DoublyLinkedList();
    

    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("   STUDENT INFORMATION RECORDING SYSTEM       ");
        System.out.println("---------------------------------------");

        int choice;

        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    if (list.isEmpty()) {
                      readStudentsFromFile("students.txt");
                      System.out.println("Students were read from file successfully.");
                   } else {
                       System.out.println("The list has already been built. File was not read again."); }
                    break;
                case 2:
                    addStudentFromKeyboard();
                    break;
                case 3:
                    searchStudentByFullName();
                    break;
                case 4:
                    deleteStudentByID();
                    break;
                case 5:
                    list.printForward();
                    break;
                case 6:
                    list.printBackward();
                    break;
                case 7:
                    copyListToStackAndPrint();
                    break;
                case 8:
                    writeListToFile("temporary_students.txt");
                    System.out.println("Data was written to temporary_students.txt. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }
    
    
    //prints the main application menu.
    private static void printMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1) Build the doubly linked list from students.txt");
        System.out.println("2) Add a new student");
        System.out.println("3) Search student by full name");
        System.out.println("4) Delete student by student ID");
        System.out.println("5) Print records in ascending order");
        System.out.println("6) Print records in descending order");
        System.out.println("7) Copy records to stack and print stack");
        System.out.println("8) Exit");
    }

    //reads students from the file and inserts each student into the correct sorted position.
    private static void readStudentsFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            while ((line = reader.readLine()) != null) {
                Student student = parseStudent(line);
                insertSorted(student);
            }


        } catch (IOException e) {
            System.out.println("File could not be read: " + e.getMessage());
        }
    }

    //converts one line of the text file into a Student object.
    private static Student parseStudent(String line) {
        String[] parts = line.split(",");

        int id = Integer.parseInt(parts[0].trim());
        String fullName = parts[1].trim();

        ArrayList<String> phoneNumbers = new ArrayList<>();

        for (int i = 2; i < parts.length; i++) {
            phoneNumbers.add(parts[i].trim());
        }

        Student student = new Student();
        student.setStudentID(id);
        student.setFullName(fullName);
        student.setPhoneNumbers(phoneNumbers);

        return student;
    }

    //inserts a student into the doubly linked list while preserving ascending ID order.
    private static void insertSorted(Student student) {
        if (list.isEmpty()) {
            list.addFirst(student);
            return;
        }

        Node current = list.getHead();
        int index = 0;

        while (current != null && current.student.getStudentID() < student.getStudentID()) {
            current = current.next;
            index++;
        }

        list.add(index, student);
    }

    //reads student information from the keyboard and adds it to the sorted list.
    private static void addStudentFromKeyboard() {
        int id;

        while (true) {
            id = readInt("Enter student ID: ");

            if (!studentIDExists(id)) {
                break;
            }

            System.out.println("This student ID already exists. Please enter a different ID.");
        }

        String fullName = readName("Enter full name: ");

        ArrayList<String> phoneNumbers = new ArrayList<>();

        int count = readInt("How many phone numbers? ");

        for (int i = 0; i < count; i++) {
            String phone = readPhoneNumber("Enter phone number " + (i + 1) + ": ");
            phoneNumbers.add(phone);
        }

        Student student = new Student();
        student.setStudentID(id);
        student.setFullName(fullName);
        student.setPhoneNumbers(phoneNumbers);

        insertSorted(student);

        System.out.println("Student was added successfully.");
    }

    //searches and prints all students with the given full name.
    private static void searchStudentByFullName() {
        String searchedName = readName("Enter full name: ");

        Node current = list.getHead();
        boolean found = false;

        while (current != null) {
            if (current.student.getFullName().equalsIgnoreCase(searchedName)) {
                System.out.println(current.student);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No student found with this full name.");
        }
    }

    //deletes the student whose ID is entered from the keyboard.
    private static void deleteStudentByID() {
           
        int id = readInt("Enter student ID to delete: ");


        Node current = list.getHead();
        int index = 0;

        while (current != null) {
            if (current.student.getStudentID() == id) {
                list.remove(index);
                System.out.println("Student was deleted successfully.");
                return;
            }

            current = current.next;
            index++;
        }

        System.out.println("No student found with this ID.");
    }

    //copies all students from the linked list to the custom stack and prints the stack.
    private static void copyListToStackAndPrint() {
        Stack stack = new Stack(list.size());

        Node current = list.getHead();

        while (current != null) {
            stack.push(current.student);
            current = current.next;
        }

        System.out.println("Stack contents:");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    //writes the final form of the linked list to a temporary file before exiting.
    private static void writeListToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            Node current = list.getHead();

            while (current != null) {
                Student s = current.student;

                writer.print(s.getStudentID() + ", " + s.getFullName());

                for (String phone : s.getPhoneNumbers()) {
                    writer.print(", " + phone);
                }

                writer.println();
                current = current.next;
            }

        } catch (IOException e) {
            System.out.println("File could not be written: " + e.getMessage());
        }
    }
    
    //reads an integer input from the user and keeps asking until a valid number is entered.
    private static int readInt(String message) {
    while (true) {
        try {
            System.out.print(message);
            return Integer.parseInt(input.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
    //reads a full name from the user and allows only letters and spaces.
    private static String readName(String message) {
    while (true) {
        System.out.print(message);
        String name = input.nextLine().trim();

        if (name.matches("[a-zA-ZçÇğĞıİöÖşŞüÜ ]+")) {
            return name;
        }

        System.out.println("Invalid input. Name must contain only letters and spaces.");
    }
}
    //reads a phone number from the user and allows only numbers and spaces.
    private static String readPhoneNumber(String message) {
    while (true) {
        System.out.print(message);
        String phone = input.nextLine().trim();

        if (phone.matches("[0-9 ]+")) {
            return phone;
        }

        System.out.println("Invalid phone number. Please enter only numbers and spaces.");
    }
}
    //checks whether a student with the given student ID already exists in the linked list.
    private static boolean studentIDExists(int id) {
        Node current = list.getHead();

        while (current != null) {
            if (current.student.getStudentID() == id) {
                return true;
            }
            current = current.next;
        }

        return false;
}
}