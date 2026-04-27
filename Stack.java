package student_information_recording_system;

public class Stack {
    private Object [] stack;
    private int capacity;
    private int index;

    //constructor
    public Stack(int capacity) {
        this.stack =  new Object[capacity];
        this.capacity = capacity;
        this.index = -1;
    }
    //push,pop,isEmpty,isFull methods
    public void push(Object element){
        if(index== capacity-1){
            System.out.println("Stack overflow");
            return;
        }else{
            stack[++index] = element;
        }
    }
    public Object pop(){
        if(index == -1){
            System.out.println("Stack is empty");
            return null;
        }
        Object removedElement = stack[index];
        stack[index]= null;
        index--;
        return removedElement;
            
    }
    
    public boolean isEmpty(){
        if(index == -1){
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


