package leetcode;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(')
                stack.push(')');
            else if(s.charAt(i) == '{')
                stack.push('}');
            else if(s.charAt(i) == '[')
                stack.push(']');
            else if(stack.isEmpty() || s.charAt(i) != stack.pop())
                return false;
        }

        //if stack not empty then false
        return stack.isEmpty();
    }

    public static void main(String[] args){
        String s = "()[]{}";
        System.out.println(isValid(s));
    }
}
