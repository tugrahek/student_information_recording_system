package student_information_recording_system;
import java.util.ArrayList;
import java.util.Objects;
 
public class Student implements Comparable<Student>{
    private int studentID;
    private String fullName;
    private ArrayList<Integer> phonerNumbers;

    //no argument constructor
    public Student() {
        this.studentID = 0;
        this.fullName = null;
        this.phonerNumbers = new ArrayList<Integer>();
    }

    //constructor that takes all parameters
    public Student(int studentID, String fullName) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.phonerNumbers = phonerNumbers;
    }

    
    //copy constructor
    public Student(Student other) {
        this.studentID = other.studentID;
        this.fullName = other.fullName;
        this.phonerNumbers = other.phonerNumbers;
    }
    
    //getter methods
    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<Integer> getPhonerNumbers() {
        return phonerNumbers;
    }

    //setter methods
    public void setStudentID(int studentID) {
        if(studentID<0){
            System.out.println("Student ID can not be below 0");
        }else{
        this.studentID = studentID;
        }
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPhonerNumbers(ArrayList<Integer> phonerNumbers) {
        this.phonerNumbers = phonerNumbers;
    }

    //toString method
    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", fullName=" + fullName + ", phonerNumbers=" + phonerNumbers + '}';
    }
    
    //equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        if (this.studentID != other.studentID) {
            return false;
        }
        if (!Objects.equals(this.fullName, other.fullName)) {
            return false;
        }
        return Objects.equals(this.phonerNumbers, other.phonerNumbers);
    }
    
    //compareTo method
    @Override
    public int compareTo(Student other){
       return Integer.compare(this.studentID, other.studentID);
    }
    
    
    
    
    
    
    
    
    
    
    


            
    

    
}
