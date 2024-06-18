package algorithms.recursion.medium;

import java.util.Stack;

public class ReverseStack {

    static Stack<Integer> stack = new Stack<>();

    public static void insertAtBottom(int num){
        if (stack.isEmpty())
            stack.push(num);
        else {
            int peek = stack.pop();
            insertAtBottom(num);
            stack.push(peek);
        }
    }

    public static void reverse(){
        if (stack.isEmpty())
            return;
        int peek = stack.pop();
        reverse();
        insertAtBottom(peek);
    }

    public static void print(Stack<Integer> stack){
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args){
        for (int i=1; i<11; i++)
            stack.push(i);
        System.out.println(stack);
        reverse();
        System.out.println(stack);
    }
}
