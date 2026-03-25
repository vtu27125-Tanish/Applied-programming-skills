import java.util.*;

class MyQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Push element to back
    public void push(int x) {
        inStack.push(x);
    }

    // Remove element from front
    public int pop() {
        move();
        return outStack.pop();
    }

    // Get front element
    public int peek() {
        move();
        return outStack.peek();
    }

    // Check if empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    // Transfer elements only when needed
    private void move() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }
}