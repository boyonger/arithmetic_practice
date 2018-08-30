package fullArrange;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.List;

public class FullArrange {

    public static List<String> list = new ArrayList<>();
    public static List<String> dictionaryList = new ArrayList<>();

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
            //因为本身不动已经算是一个排列了，所以从自己的位置开始
            /*
            理解index是要交换的数，i是从index遍历到结尾，index分别与每个i交换
            每交换一次，会继续递归遍历至后面
            123

             */
            for (int i = index; i < numberList.length; i++) {
                swap(numberList, i, index);
                fullArrangeByRecur(numberList, index + 1);
                swap(numberList, i, index);
            }
        }
    }

    //字典序 从后往前找一对递增序列 从前面的开始计算 找最小的大数交换 翻转。
    public static void fullArrangeByDictionary(int numberList[]) {
        if (numberList.length < 2) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numberList.length; i++) {
            stringBuffer.append(numberList[i]);
        }
        dictionaryList.add(stringBuffer.toString());
        int back, pre;
        boolean isEnd = true;
        for (back = numberList.length - 1, pre = numberList.length - 2; pre > -1; back--, pre--) {
            if (numberList[pre] < numberList[back]) {
                isEnd = false;
                break;
            }
        }
        if (isEnd == false) {
            int biggerPos = back;
            for (int i = back + 1; i < numberList.length; i++) {
                if (numberList[i] > numberList[pre] && numberList[i] < numberList[back]) {
                    biggerPos = i;
                }
            }
            swap(numberList, pre, biggerPos);
            for (int i = 1; i + pre < numberList.length - i; i++) {
                swap(numberList, pre + i, numberList.length - i);
            }
            fullArrangeByDictionary(numberList);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        //fullArrangeByRecur(a, 0);
        //调用字典全排之前先排序
        fullArrangeByDictionary(a);
        for (String b : dictionaryList) {
            System.out.println(b);
        }
    }
}
