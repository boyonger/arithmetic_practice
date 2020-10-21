package dynamicPrograme;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
题目：给定一个数组，里面全是正整数。数字大小表示这一步最多可以向后移动几个节点。总是从数组第一个元素开始移动。
问如何移动，可以以最少步数移动到最后一个节点。
例如：[3,4,2,1,3,1]初始状态指向3表示下一步可以移动1格，或者2格，或者3格。
最优的方式是指向3的时候移动一步，第二次选择移动4步，一共只需要两步即可移动到数组尾。

输入：3,4,2,1,3,1
输出：步经的点3,4,1
6
3 4 2 1 3 1
 */
public class MinStepToEnd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        String[] data = br.readLine().split(" ");
        int[] numberList = new int[count];
        for (int i = 0; i < count; i++) {
            numberList[i] = Integer.parseInt(data[i]);
        }
        int[][] minDis = new int[count][2]; //0表示前一个的位置，1表示最短距离。
        minDis[0][0] = -1;
        minDis[0][1] = 0;
        for (int i = 1; i < numberList.length; i++) {
            minDis[i][1] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < count; i++) {   //在计数中，1代表着numberList的0
            for (int j = 0; j < i; j++) {
                if (j + numberList[j] >= i) {
                    if (minDis[j][1] + 1 < minDis[i][1]) {
                        minDis[i][0] = j;
                        minDis[i][1] = minDis[j][1] + 1;
                    }
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        int mid = minDis[count - 1][0];
        stack.push(numberList[count - 1]);
        while (true) {
            if (mid < 0) break;
            stack.push(numberList[mid]);
            mid = minDis[mid][0];
        }
        StringBuilder stringBuffer = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop()).append(",");
        }
        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));
    }

}
