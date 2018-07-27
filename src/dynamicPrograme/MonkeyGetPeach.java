package dynamicPrograme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 小猴子下山，沿着下山的路由一排桃树，每棵树都结了一些套子。小猴子想摘桃子，但是有一些条件需要遵守，小猴子只能沿着下山的方向走，
 * 不能回头，每棵树最多摘一个，而且一旦摘了一棵树的桃子，就不能再摘比这棵树结的桃子少的树上的桃子了，那么小猴子最多能摘几个桃子呢？
 * 举例说明，比如有5课树，分别结了10,4,5,12,8颗桃子，那么小猴子最多能摘3颗桃子，来自于结了4,5,8颗桃子的树。
 * 5
 * 10 4 5 12 8
 */
public class MonkeyGetPeach {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine().trim());
        String[] data = br.readLine().split(" ");
        int[] peachNumber = new int[number];
        for (int i = 0; i < number; i++) {
            peachNumber[i] = Integer.parseInt(data[i]);
        }
        String[] dis = new String[number + 1];
        dis[0] = "";
        for (int i = 1; i < dis.length; i++) {
            dis[i] = peachNumber[i - 1] + "";
        }
        int[] dynamic = new int[number + 1];
        int max;
        // number -- number
        for (int i = 1; i < number + 1; i++) {
            max = 1;
            for (int j = 0; j < i - 1; j++) { //i的位置是i-1
                if (peachNumber[j] < peachNumber[i - 1]) {
                    if (dynamic[j + 1] + 1 > max) {
                        max = dynamic[j + 1] + 1;
                        dis[i] = dis[j + 1] + "," + peachNumber[i - 1];
                    }
                }
            }
            dynamic[i] = max;
        }

        System.out.println(dynamic[number]);
        System.out.println(dis[number]);


    }
}
