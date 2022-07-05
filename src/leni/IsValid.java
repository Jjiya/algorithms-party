package leni;
/*
* URL : https://leetcode.com/problems/valid-parentheses/
* */

import java.util.Stack;

public class IsValid implements Solution {

    IsValid(){
        run(this);
    }

    @Override
    public void process() {
        String s = "()[]{}";

        System.out.println(this.isValid(s));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (!stack.isEmpty() && closeBrackets(c, stack.peek())){
                stack.pop();
            }
            else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean closeBrackets(char ch, char peek){
        boolean result = false;
        if (peek == '(' && ch == ')'){
            result = true;
        }
        else if (peek == '[' && ch == ']'){
            result = true;
        }
        else if (peek == '{' && ch == '}'){
            result = true;
        }
        return result;
    }
}
