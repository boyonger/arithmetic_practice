package writtenExam.beike.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String operation = br.readLine().trim();
        String[] number = operation.split("\\+|-");
        for (int i = 0; i < number.length; i++) {
            if (number[i].charAt(0) == '0' && number[i].charAt(1) == 'x') {
                String temp = number[i].substring(2);
                number[i] = Integer.parseInt(temp, 16) + "";
            } else if (number[i].charAt(0) == '0') {
                String temp = number[i].substring(1);
                number[i] = Integer.parseInt(temp, 8) + "";
            }
        }
        Stack<String> numberStack = new Stack<>();
        Stack<Character> operaStack = new Stack<>();
        for (int i = operation.length() - 1; i > -1; i--) {
            if (operation.charAt(i) == '+') {
                operaStack.push('+');
            }
            if (operation.charAt(i) == '-') {
                operaStack.push('-');
            }
        }
        for (int i = number.length - 1; i > -1; i--) {
            numberStack.push(number[i]);
        }
        while (numberStack.size() != 1) {
            int a = Integer.parseInt(numberStack.pop());
            int b = Integer.parseInt(numberStack.pop());
            Character c = operaStack.pop();
            if (c == '+') {
                int d = a + b;
                numberStack.push(d + "");
            } else if (c == '-') {
                int d = a - b;
                numberStack.push(d + "");
            }
        }
        System.out.println(numberStack.peek());
    }
}
