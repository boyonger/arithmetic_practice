package writtenExam.xiecheng.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        int queryTime = Integer.parseInt(br.readLine().trim());
        int[][] matrix = new int[count][3];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String[] data = br.readLine().split(" ");
            if (queryTime >= Integer.parseInt(data[1]) && queryTime <= Integer.parseInt(data[2])){
                list.add(Integer.parseInt(data[0]));
            }
/*                for (int j = 0; j < 3; j++) {
                    matrix[i][j] = Integer.parseInt(data[j]);
                }*/
        }
        Collections.sort(list);
        if (list.isEmpty()){
            System.out.println("null");
        }else{

            for (int a:list){
                System.out.println(a);
            }
        }
    }
}
