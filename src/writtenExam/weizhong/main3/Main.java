package writtenExam.weizhong.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] number = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().trim().split(" ");
            number[i][0] = Integer.parseInt(data[0]);
            number[i][1] = Integer.parseInt(data[1]);
        }
        double dis=dis(number[0][0],number[0][1],number[1][0],number[1][0]);
        int x1=number[0][0],y1=number[0][1],x2=number[1][0],y2=number[1][0];
        for (int i=1;i<number.length-1;i++){
            if (dis(number[i][0],number[i][1],number[i+1][0],number[i+1][1])>1)
                System.out.println("1.000");
        }
    }

    public static double dis(int x1,int x2,int y1,int y2){
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }
}
