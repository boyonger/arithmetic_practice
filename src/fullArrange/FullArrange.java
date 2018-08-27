package fullArrange;

import java.util.ArrayList;
import java.util.List;

public class FullArrange {

    public static List<String> list = new ArrayList<>();

    //两种，第一种递归（byRecur），第二种字典排序(byDictionary)
    public static void swap(int[] numberList, int i, int index) {
        int temp = numberList[i];
        numberList[i] = numberList[index];
        numberList[index] = temp;
    }

    public static void fullArrangeByRecur(int numberList[], int index) {
        if (index >= numberList.length - 1) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < numberList.length; i++) {
                stringBuffer.append(numberList[i]);
            }
            list.add(stringBuffer.toString());
        } else {
            for (int i = index + 1; i < numberList.length; i++) {
                swap(numberList, i, index);
                fullArrangeByRecur(numberList, i);
                swap(numberList, i, index);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        fullArrangeByRecur(a, 0);
        for (String b : list) {
            System.out.println(b);
        }
    }
}
