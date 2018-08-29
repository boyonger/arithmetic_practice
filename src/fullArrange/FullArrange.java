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

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        fullArrangeByRecur(a, 0);
        for (String b : list) {
            System.out.println(b);
        }
    }
}
