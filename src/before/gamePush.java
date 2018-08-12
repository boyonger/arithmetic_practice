package before;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
4
6 9
2 6
4 5
3 7
 */
public class gamePush {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        int[][] numberList = new int[count][2];
        for (int i = 0; i < count; i++) {
            String[] data = br.readLine().split(" ");
            numberList[i][0] = Integer.parseInt(data[0]);
            numberList[i][1] = Integer.parseInt(data[1]);
        }
        List<Integer> list= new ArrayList<>();
        int mid;
        for (int i=0;i<count;i++){
            mid=0;
            for (int j=i;j<count;j++){
                if (numberList[j][0] <= numberList[i][0] && numberList[j][1] >= numberList[i][1]){
                    mid++;
                }
            }
            list.add(mid);
        }

        /*
        int[] max = new int[count];
        for (int i = 0; i < count; i++) { //实际上i-1
            for (int j = 0; j <= i; j++) {
                if (numberList[j][0] <= numberList[i][0] && numberList[j][1] >= numberList[i][1]) {
                    max[i] = Integer.max(max[i], max[j] + 1);
                }
            }
        }*/
        System.out.println(Collections.max(list));
    }
}
