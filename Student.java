package student_information_recording_system;
import java.util.ArrayList;
import java.util.Objects;
 
public class Student implements Comparable<Student>{
    private int studentID;
    private String fullName;
    private ArrayList<String> phoneNumbers;

    //no argument constructor
    public Student() {
        this.studentID = 0;
        this.fullName = null;
        this.phoneNumbers = new ArrayList<String>();
    }

    //constructor that takes all parameters
    public Student(int studentID, String fullName, ArrayList<String> phoneNumbers) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.phoneNumbers = phoneNumbers;
    }

    
    //copy constructor
    public Student(Student other) {
        this.studentID = other.studentID;
        this.fullName = other.fullName;
        this.phoneNumbers = other.phoneNumbers;
    }
    
    //getter methods
    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public ArrayList<String> getPhonerNumbers() {
        return phoneNumbers;
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

    public void setPhonerNumbers(ArrayList<String> phonerNumbers) {
        this.phoneNumbers = phonerNumbers;
    }

    //toString method
    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", fullName=" + fullName + ", phonerNumbers=" + phoneNumbers + '}';
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
        return Objects.equals(this.phoneNumbers, other.phoneNumbers);
    }
    
    //compareTo method
    @Override
    public int compareTo(Student other){
       return Integer.compare(this.studentID, other.studentID);
    }
    
    
    
    
    
    
    
    
    
    
    


            
    

    
}
