package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 输入描述:
 * 第一行五个整数n,m,x,y,t(1≤n,m,t≤1000,1≤x≤n,1≤y≤m);
 * 接下来为一个n＊m的矩阵，每行m个一位小数，共n行，第i行第j个数代表坐标为(i,j)的格子钓到鱼的概率为p(0≤p≤1)
 * 输出描述:
 * 输出两行。第一行为概率大的人的名字(cc/ss/equal),第二行为这个概率(保留2位小数)
 */
public class Fishing {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str=null;
        while ((str = bf.readLine()) != null) {
            String[] data = str.split(" ");
            int n = Integer.parseInt(data[0]);
            int m = Integer.parseInt(data[1]);
            int x = Integer.parseInt(data[2]);
            int y = Integer.parseInt(data[3]);
            int t = Integer.parseInt(data[4]);
            double[][] fishMatrix = new double[n][m];
            double sum = 0;
            for (int i = 0; i < fishMatrix.length && (str = bf.readLine()) != null; i++) {
                String[] rowData = str.split(" ");
                for (int j = 0; j < fishMatrix[0].length; j++) {
                    fishMatrix[i][j] = Double.parseDouble(rowData[j]);
                    sum += Double.parseDouble(rowData[j]);
                }
            }
            double pAverage = 1 - Math.pow(1 - sum / (n * m), t);
            double locatedAverage = 1 - Math.pow(1 - fishMatrix[x - 1][y - 1], t);
            if (pAverage>locatedAverage){
                System.out.println("ss");
                System.out.printf("%.2f\n",pAverage);
            }else if(locatedAverage>pAverage){
                System.out.println("cc");
                System.out.printf("%.2f\n",locatedAverage);
            }else {
                System.out.println("equal");
                System.out.printf("%.2f\n",locatedAverage);
            }
            /*if (pAverage == locatedAverage) {
                System.out.println("equal");
            } else {
                System.out.println((pAverage > locatedAverage) ? "ss" : "cc");
            }
            System.out.printf("%.2f\n",(pAverage > locatedAverage) ? pAverage : locatedAverage);*/
        }
        bf.close();

    }

}
