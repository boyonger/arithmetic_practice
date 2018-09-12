package writtenExam.jd.main2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        int[][] product=new int[count][3];
        int sum=0;
        for (int i=0;i<count;i++){
            String[] data=br.readLine().trim().split(" ");
            product[i][0]= Integer.parseInt(data[0]);
            product[i][1]= Integer.parseInt(data[1]);
            product[i][2]= Integer.parseInt(data[2]);
        }
        for (int i=0;i<product.length;i++){
            for (int j=0;j<product.length;j++){
                if (product[i][0]<product[j][0] && product[i][1]<product[j][1] && product[i][2]<product[j][2]){
                    sum++;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
