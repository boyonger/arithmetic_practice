package writtenExam.touTiao1008.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static Stack<Integer> stack=new Stack<>();
    public static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        for (int i=0;i<count;i++){
            String word=br.readLine();

        }
    }

    public static void dfs(Stack<Integer> stack){
        for (int i=0;i<3;i++){
            calculator(stack,i);
            if (stack.size()==1){
                if (stack.peek()==0){
                    count++;
                }else{
                    dfs(stack);
                }
            }
        }
    }

    public static void calculator(Stack<Integer> stack,int count) {
        switch (count) {
            case 0:
                String a=stack.pop()+"";
                String b=stack.pop()+"";
                stack.push(Integer.parseInt(a+b));
            case 1:
                stack.push(stack.pop()+stack.pop());
            case 2:
                stack.push(stack.pop()-stack.pop());
        }
    }

    public static void revert(Stack<Integer> stack,int count){
        switch (count) {
            case 0:
                String a=stack.pop()+"";
                String b=a.substring(0,a.length()-1);
                String c=a.substring(a.length()-2,a.length());
                stack.push(Integer.parseInt(c));
                stack.push(Integer.parseInt(b));
            case 1:
                stack.push(stack.pop()-stack.pop());
            case 2:
                stack.push(stack.pop()+stack.pop());
        }
    }
}

