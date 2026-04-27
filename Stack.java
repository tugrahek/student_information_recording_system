package student_information_recording_system;

public class Stack {
    private Object [] stack;
    private int capacity;
    private int index;

    //constructor
    public Stack() {
        this.stack = null;
        this.capacity =0;
        this.index = -1;
    }
    public Stack(Object[] stack, int capacity, int index) {
        this.stack = stack;
        this.capacity = capacity;
        this.index = index;
    }
     //push,pop,isEmpty,isFull methods
    public void push(int element){
        if(index== capacity-1){
            System.out.println("Stack overflow");
            return;
        }else{
            stack[index++] = element;
        }
    }
    public Object pop(){
        if(index == -1){
            System.out.println("Stack is empty");
            return null;
        }
        return stack[index--];
        
    }
    
    public boolean isEmpty(){
        if(index == -1){
            System.out.println("Stack is empty");
            return true;
        }
        return false;
    }
    
    public boolean isFull(){
        if (index == capacity-1){
            return true;
        }
        return false;
    }
            
         
    
}


