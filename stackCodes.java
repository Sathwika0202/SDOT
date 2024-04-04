// infix to postfix conversion.

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int precedence(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '/' || ch == '*')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return -1;
    }
    static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            }
            
            else if (c == '(') {
                stack.push(c);
            }
            
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid expression"; 
            }
            result.append(stack.pop());
        }
        
        return result.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String infixExpression = scanner.nextLine();
        System.out.println(infixToPostfix(infixExpression));
        scanner.close();
    }
}
