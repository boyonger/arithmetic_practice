package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
现在按照以下规则将A数组中的元素插入到B数组中进行合并：
对于A数组中任一元素可以插入到B数组中任意位置。
对于A数组中任一元素a(i)，在合并之后的数组中a(i)对应的下标小于a(i+1)对应的下标。（如果a(i+1)存在的话）
问题：
对合并之后的数组中相邻元素两两相乘，然后求其累加值，请给出所有合并可能形成的数组对应累加值的最小值。
以长度为4的两个数组为例：
A：{a1，a2，a3，a4}
B：{b1，b2，b3，b4}
插入完成后的数组可能为：
{a1，a2，b1，b2，b3，b4，a3，a4}、
{b1，a1，b2，b3，a2，a3，b4，a4}等。
其对应的累加值分别对应为
a1*a2 + b1*b2 + b3*b4 + a3*a4、
b1*a1 + b2*b3 + a2*a3 + b4*a4等。
2
1 2
3
3 4 5
 */
public class AArrayToBArray {
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int aCount = Integer.parseInt(br.readLine().trim());
        String[] data = br.readLine().split(" ");
        List<Integer> aNumberList = new ArrayList<>();
        for (int i = 0; i < aCount; i++) {
            aNumberList.add(Integer.parseInt(data[i]));
        }
        int bCount = Integer.parseInt(br.readLine().trim());
        sum = aCount + bCount;
        data = br.readLine().split(" ");
        List<Integer> bNumberList = new ArrayList<>();
        for (int i = 0; i < bCount; i++) {
            bNumberList.add(Integer.parseInt(data[i]));
        }
        List<List<Integer>> allNumberList = new ArrayList<>();
        addNumber(0, allNumberList, aNumberList, bNumberList);
        System.out.println(allNumberList.toString());
    }

    //position从0开始
    public static void addNumber(int position, List<List<Integer>> allNumberList, List<Integer> aNumberList, List<Integer> bNumberList) {
        //List<Integer> bNumberList = new ArrayList<>(bNumberList);
        //List<Integer> aNumberListCopy = new ArrayList<>(aNumberList);
        for (int i = position; i < bNumberList.size() + 1 && aNumberList.size() > 0; i++) { //有length+1的空隙
            int mid = aNumberList.remove(0);
            bNumberList.add(i, mid);
            addNumber(i + 1, allNumberList, aNumberList, bNumberList);
            aNumberList.add(0, mid);
            bNumberList.remove(i);
        }
        if (bNumberList.size() == sum)
            allNumberList.add(new ArrayList<>(bNumberList));
    }
}
