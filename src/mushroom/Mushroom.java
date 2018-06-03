package mushroom;

import java.io.*;

public class Mushroom {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=bf.readLine())!=null){
            String[] a=str.split(" ");
            int n=Integer.parseInt(a[0]);
            int m=Integer.parseInt(a[1]);
            int k=Integer.parseInt(a[2]);
            int[][] kMatrix=new int[n][m];
            for (int i=0;i<k&&(str=bf.readLine())!=null;i++){
                String[] kData=str.split(" ");
                int kDataX=Integer.parseInt(kData[0]);
                int kDataY=Integer.parseInt(kData[1]);
                kMatrix[kDataX-1][kDataY-1]=1;
            }
            int max=n>m?n:m;
            int min=n>m?m:n;
            int pEach;
            for (int i=1;i<max;i++){
                if (i<min){
                    pEach=i+1; //计算
                }else{
                    pEach=min;
                }
            }
        }
    }
}
