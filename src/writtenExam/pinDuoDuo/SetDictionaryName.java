package writtenExam.pinDuoDuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
3 4
CAKE
TORN
SHOW
 */
public class SetDictionaryName {


    public static Set<String> existSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int n = Integer.parseInt(data[0]);
        int l = Integer.parseInt(data[1]);
        //存一个二维数组来存放首字母开始的名字
        Character[][] chooseList = new Character[l][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
            existSet.add(s);
            for (int j = 0; j < l; j++) {
                chooseList[j][i] = s.charAt(j); //颠倒顺序
            }
        }
        for (int i = 0; i < chooseList.length; i++) {
            bubbleSort(chooseList, i);
        }
        for (int i = 0; i < chooseList.length; i++) {
            for (int j = 0; j < chooseList[0].length; j++) {
                System.out.print(chooseList[i][j]);
            }
            System.out.println("");
        }
        List<Character> list = new ArrayList<>();
        dfs(chooseList, 0, list);
        System.out.println(list.toString());
/*        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < getName.length; i++) {
            stringBuffer.append(getName[i].charAt(0));
        }
        System.out.println(stringBuffer.toString());*/
    }

    //开始深度遍历 我就不行写这么多dfs我还不会写！ 0.0 多练习 递归深度遍历字典查找
    public static void dfs(Character[][] chooseList, int row, List<Character> wordList) {
        boolean flag=false;
        for (int i = 0; i < chooseList[0].length; i++) {
            wordList.add(chooseList[row][i]);
            if (row == chooseList.length - 1) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Character a : wordList) {
                    stringBuffer.append(a);
                }
                if (!existSet.contains(stringBuffer.toString())) {
                    flag=true;
                    break;
                    //若要全部 list.changeTo
                }
            }else{
                dfs(chooseList, row + 1, wordList);
            }
            wordList.remove(wordList.size() - 1);
        }
    }


    public static void bubbleSort(Character[][] list, int row) {
        for (int i = 0; i < list[row].length; i++) {
            for (int j = i + 1; j < list[row].length; j++) {
                if (list[row][i] > list[row][j]) {
                    char mid = list[row][i];
                    list[row][i] = list[row][j];
                    list[row][j] = mid;
                }
            }
        }
    }
}
