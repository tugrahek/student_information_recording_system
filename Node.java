
package student_information_recording_system;


public class Node {
    Student student;
    Node next;
    Node prev;
    
    public Node(Student student){
        this.student = student;
        this.next = null;
        this.prev = null;
    }
}
