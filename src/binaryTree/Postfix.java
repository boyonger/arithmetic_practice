package binaryTree;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class expressNote { // 二叉树节点类
    String data;
    String front;
    String behind;
    expressNote leftChild, rightChild;

    public expressNote() {
        // TODO Auto-generated constructor stub
    }

    public expressNote(String data) {
        // TODO Auto-generated constructor stub
        this.data = data;
    }

    public void show() {
        System.out.println(this.data);
    }
}

class expressTree { // 二叉树类
    private expressNote root = null;
    private List<String> arrayList = new ArrayList<>();

    public expressTree() {
        // TODO Auto-generated constructor stub
    }

    public expressTree(String value) {
        // TODO Auto-generated constructor stub
        this.root.data = value;
        root.leftChild = null;
        root.rightChild = null;
        root.front = null;
        root.behind = null;
    }

    public List<String> preOrd() {
        preOrd(root);
        return arrayList;
    }

    private void preOrd(expressNote subTree) {
        if (subTree != null) {
            if (subTree.front != null)
                // System.out.print(subTree.front);
                this.arrayList.add(subTree.front);
            preOrd(subTree.leftChild);
            // System.out.print(subTree.data);
            this.arrayList.add(subTree.data);
            preOrd(subTree.rightChild);
            if (subTree.behind != null)
                // System.out.print(subTree.behind);
                this.arrayList.add(subTree.behind);
        }
    }

    public void proError() {
        int notLeafNumber = (int) (3 + Math.random() * 10);
        for (int i = 0; i < notLeafNumber; i++) {
            if (proBracket()) {
                String ranOperation = proOperation((int) (1 + Math.random() * 4));
                inserTree(ranOperation, false);
            } else
                inserTree(proNumber(), false);
        }

    }

    public void inserNumber() {
        inserNumber(root);
    }

    private void inserNumber(expressNote subTree) {
        if (subTree.leftChild == null) {
            expressNote q = new expressNote(proNumber());
            subTree.leftChild = q;
        } else {
            inserNumber(subTree.leftChild);
        }

        if (subTree.rightChild == null) {
            expressNote q = new expressNote(proNumber());
            subTree.rightChild = q;
        } else {
            inserNumber(subTree.rightChild);
        }
    }

    public void insertExpress() {
        int notLeafNumber = (int) (1 + Math.random() * 10);
        for (int i = 0; i < notLeafNumber; i++) {
            String ranOperation = proOperation((int) (1 + Math.random() * 4));
            inserTree(ranOperation, true);
        }

    }

    public boolean proBracket() {
        int a = (int) (1 + Math.random() * 4);
        if (a == 1) {
            return true;
        } else
            return false;
    }

    public void inserTree(String value, boolean judge) {
        expressNote node = new expressNote(value);
        if (judge == true) {
            if (proBracket()) {
                node.front = "(";
                node.behind = ")";
            }
        } else if (judge == false) {
            if (proBracket())
                node.front = "(";

            if (proBracket())
                node.behind = ")";

        }
        if (this.root == null) {
            this.root = node;
        } else {
            expressNote q = root;
            while (true) {
                if (q.leftChild == null) {
                    q.leftChild = node;
                    break;
                } else if (q.rightChild == null) {
                    q.rightChild = node;
                    break;
                } else {
                    q = q.leftChild;
                }
            }
        }
    }

    public String proNumber() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(-100 + Math.random() * 200);
    }

    public String proOperation(int number) {
        switch (number) {
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "*";
            case 4:
                return "/";
            default:
                return "%";
        }
    }
}

public class Postfix {
    public static int isp(Character symbol) {
        switch (symbol) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 3;
            case '(':
                return 0;

            default:
                System.out.println("no");
                return 0;
        }
    }

    public static boolean judgeOperation(Character operation) {
        if (operation == '+' || operation == '-' || operation == '*' || operation == '/' || operation == '%') {
            return true;
        } else
            return false;
    }

    public static boolean judgeOperationNoMinus(Character operation) {
        if (operation == '+' || operation == '*' || operation == '/' || operation == '%') {
            return true;
        } else
            return false;
    }



    public static void coutError(String operation) {
        Stack<Character> pointStack=new Stack<>();
        Stack<Character> bracketStack = new Stack<>();
        for (int i = 0; i < operation.length(); i++) {
            Character inOperation = operation.charAt(i);
            if (i == 0 && judgeOperation(inOperation)) {
                if (judgeOperationNoMinus(inOperation)
                        || i + 1 >= operation.length() && inOperation == '-' && !Character.isDigit(i + 1))
                    System.out.println("第" + (i + 1) + "的位置出现操作符左侧无数字错误");
            } else if (judgeOperation(inOperation)) {
                if (!pointStack.empty() && pointStack.peek() == '.')
                    pointStack.pop();
                if (i - 1 >= 0 && judgeOperationNoMinus(inOperation) && (judgeOperation(operation.charAt(i - 1))||operation.charAt(i-1)=='('))
                    System.out.println("第" + (i + 1) + "的位置出现操作符左侧无数字错误");
                else if (inOperation == '-' && i - 2 >= 0 && operation.charAt(i-2)=='-')
                    //(judgeOperation(operation.charAt(i - 2))||operation.charAt(i-2)==')')
                    System.out.println("第" + i + "的位置出现操作符左侧无数字错误");
            } else if (inOperation == '.') {
                if (!pointStack.empty() && pointStack.peek() == '.') {
                    System.out.println("第" + (i - 2) + "的位置所在数字出现数字间无操作符");
                    pointStack.pop();
                }
                pointStack.push(inOperation);
            } else if (inOperation == '(') {
                bracketStack.push(inOperation);
            } else if (inOperation == ')') {
                if (i-1>=0&&judgeOperation(operation.charAt(i-1)))
                    System.out.println("第"+i+"个位置所在的操作符没有右侧操作数");
                if (!bracketStack.empty())
                    bracketStack.pop();
                else
                    System.out.println("第" + (i+1) + "的位置所在右括号没有左括号匹配");
            }
            if (i == operation.length() - 1 && judgeOperation(inOperation))
                System.out.println("第" + operation.length() + "个位置缺少右操作符");
        }
        if (!bracketStack.isEmpty())
            System.out.println("第" + operation.length() + "个位置缺少" + bracketStack.size() + "个左括号");

    }

    public static void convert(String operation, Stack<Character> operationStack) {
        for (int i = 0; i < operation.length(); i++) {
            Character inOperation = operation.charAt(i);
            if (Character.isDigit(inOperation)) {
                if ((i - 1 < 0 || judgeOperation(operation.charAt(i - 1)) || operation.charAt(i - 1) == '(') // 数字前面为空或者符号
                        && i + 1 < operation.length() // 不是最后一个
                        && (Character.isDigit(operation.charAt(i + 1)) || operation.charAt(i + 1) == '.')
                        && !(i == 1 && operation.charAt(i - 1) == '-') && (i - 2 < 0 || !(operation.charAt(i - 1) == '-'
                        && (judgeOperation(operation.charAt(i - 2)) || operation.charAt(i - 2) == '(')))) //
                    System.out.print("(");
                System.out.print(inOperation);
                if ((i + 1 >= operation.length() || judgeOperation(operation.charAt(i + 1))
                        || operation.charAt(i + 1) == '(' || operation.charAt(i + 1) == ')')
                        && ((i - 1 >= 0
                        && (Character.isDigit(operation.charAt(i - 1)) || operation.charAt(i - 1) == '.'))
                        || (i - 2 >= 0 && operation.charAt(i - 1) == '-'
                        && judgeOperation(operation.charAt(i - 2)))
                        || (i - 1 >= 0 && i - 2 < 0 && operation.charAt(i - 1) == '-')))
                    System.out.print(")"); // 后面为空或者操作符 . 前面为数字
            } else if (inOperation == '-' && (i - 1 < 0 || (i + 1 < operation.length() && i - 1 >= 0
                    && (judgeOperation(operation.charAt(i - 1)) || operation.charAt(i - 1) == '(')
                    && Character.isDigit(operation.charAt(i + 1))))) {
                System.out.print("(" + inOperation);
            } else if (judgeOperation(inOperation)) {
                if (operationStack.isEmpty() || isp(inOperation) > isp(operationStack.peek()))
                    operationStack.push(inOperation);
                else {
                    do {
                        System.out.print(operationStack.pop());
                    } while (!operationStack.isEmpty() && isp(inOperation) <= isp(operationStack.peek()));
                    operationStack.push(inOperation);
                }
            } else if (inOperation == '(')
                operationStack.push(inOperation);
            else if (inOperation == ')') {
                while (operationStack.peek() != '(') {
                    if (operationStack.isEmpty()) {
                        System.out.print("括号不匹配");
                        break;
                    }
                    System.out.print(operationStack.pop());
                }
                operationStack.pop();
            } else if (inOperation == '.') {
                System.out.print(inOperation);
            } else {
                System.out.print("输入不符合规范");
                break;
            }
        }
        while (!operationStack.isEmpty()) {
            System.out.print(operationStack.pop());
        }
    }

    public static void creatFile(String fileName, StringBuffer sb) {
        File file = new File(fileName);
        if (file.isFile()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            // 将编码设置为UTF-8格式
            fos.write(sb.toString().getBytes("UTF-8"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    // 关闭文件流
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Stack<Character> inStringStack = new Stack<>();
        List<String> arrayList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入生成表达式数量");
        int expressCount = Integer.parseInt(sc.nextLine());
        System.out.println("输入1代表正确表达式，输入0代表不正确表达式");
        int trueOrFalse = Integer.parseInt(sc.nextLine());
        if (trueOrFalse == 1) {
            for (int i = 0; i < expressCount; i++) {
                expressTree expression = new expressTree();
                expression.insertExpress();
                expression.inserNumber();
                arrayList = expression.preOrd();
                for (String a : arrayList)
                    sb.append(a);
                sb.append(";\r\n");
            }
        } else {
            for (int i = 0; i < expressCount; i++) {
                expressTree expression = new expressTree();
                expression.proError();
                arrayList = expression.preOrd();
                for (String a : arrayList)
                    sb.append(a);
                sb.append(";\r\n");
            }
        }
        creatFile("test.txt", sb);
        File filename = new File("test.txt"); // 要读取以上路径的input.txt文件
        InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(reader);
        String line = br.readLine();
        if (trueOrFalse == 1) {
            while (line != null) {
                line = line.replace(";", "");
                line=line.replaceAll("\\s*", "");
                System.out.println("中缀" + '\n' + line + '\n' + "后缀");
                convert(line, inStringStack);
                System.out.println("");
                line = br.readLine(); // 一次读入一行数据
            }
        } else {
            while (line != null) {
                line = line.replace(";", "");
                line=line.replaceAll("\\s*", "");
                System.out.println("中缀错误表达式" + '\n' + line);
                coutError(line);
                System.out.println("");
                line = br.readLine(); // 一次读入一行数据
            }
        }

		/*
		 * for (int i = 0; i < 10; i++) { System.out.println("请输入中缀表达式"); String
		 * inString = sc.nextLine(); convert(inString, inStringStack);
		 * System.out.println(' '); }
		 */

        sc.close();
    }

}
