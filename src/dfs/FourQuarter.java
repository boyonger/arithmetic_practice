package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 题目：一个整型数组，将其划分为和相同的4个切片，例如：{ 2, 3, 5, 1, 2, 2, 1, 1, 3 }，
 * 切片操作后划分为：{2,3}，{5}，{1,2,2}，{1,1,3}，也就找到所谓的四等分点。
 * 只不过输出结果为true或者false（是否能得到这样的4个切片）。同时要求时间复杂度和空间复杂度为o(n)。
 */
/*
9
2 3 5 1 2 2 1 1 3
 */
public class FourQuarter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        String[] data = br.readLine().split(" ");
        int[] numberList = new int[count];
        int sum = 0;
        for (int i = 0; i < count; i++) {
            numberList[i] = Integer.parseInt(data[i]);
            sum +=numberList[i];
        }
        if (sum % 4 != 0) {
            System.out.println("false");
        }else {
            int equal=sum/4;
            int[] toZero={equal,equal,equal,equal};
            for (int i=0;i<numberList.length;i++){
                for (int j=0;j<4;j++){
                    if (toZero[j]>=numberList[i]){
                        toZero[j]-=numberList[i];
                        break;
                    }
                }
            }
            if (toZero[0]==0&&toZero[1]==0&&toZero[2]==0&&toZero[3]==0){
                System.out.println("true");
            }else{
                System.out.println("false");
            }
        }

    }
}
