package Stacks;

public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    Stack(int size){
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Push element into stack
    public void push(int value){
        if(ifFull()){
            System.out.println("Stack is full.");
        }

        System.out.println("Pushing " + value);
        arr[++top] = value;
    }

    // Check if stack is full
    private boolean ifFull() {
        return top == capacity - 1;
    }

    // Pop element from stack
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty.");
        }
        return arr[top--];
    }

    // Check if stack is empty
    private boolean isEmpty() {
        return top == -1;
    }

    // Print stack
    public void printStack(){
        for(int i = 0; i <= top; i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args){
        Stack stack = new Stack(4);

        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);

        stack.printStack();

        stack.pop();

        stack.printStack();

    }
}
