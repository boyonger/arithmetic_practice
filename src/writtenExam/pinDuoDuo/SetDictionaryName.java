package writtenExam.pinDuoDuo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/*
3 4
CAKE
TORN
SHOW
 */
public class SetDictionaryName {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int n = Integer.parseInt(data[0]);
        int l = Integer.parseInt(data[1]);
        //存一个二维数组来存放首字母开始的名字
        Character[][] chooseList = new Character[l][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine().trim();
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
/*        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < getName.length; i++) {
            stringBuffer.append(getName[i].charAt(0));
        }
        System.out.println(stringBuffer.toString());*/
    }

    //开始深度遍历 我就不行写这么多dfs我还不会写！
    public static void dfs(Character[][] chooseList,int row, int col){
        String words="";


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
