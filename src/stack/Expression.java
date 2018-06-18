package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Expression {
    public boolean chkLegal(String A) {
        // write code here
        Stack<Character> operationStack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            Character operation=A.charAt(i);
            if (operation=='['||operation=='{'||operation=='('){
                operationStack.push(A.charAt(i));
            }
            if (operation=='}'||operation==']'||operation==')'){
                if (operationStack.pop()!=this.getCorrespondence(operation)){
                    return false;
                }
            }
        }
        return true;
    }

    public Character getCorrespondence(Character operation) {
        switch (operation) {
            case '}':
                return '{';
            case ')':
                return '(';
            case ']':
                return '[';
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str="[a+b*(5-4)]*{x+b+b*(({1+2)}}";
        System.out.println(new Expression().chkLegal(str));
    }
}
