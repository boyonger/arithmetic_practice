package dynamicPrograme;

import java.io.*;

public class Mushroom {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bf.readLine()) != null) {
            String[] a = str.split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            int k = Integer.parseInt(a[2]);
            int[][] kMatrix = new int[n][m];
            double[][] pMatrix = new double[n][m];
            for (int i = 0; i < k && (str = bf.readLine()) != null; i++) {
                String[] kData = str.split(" ");
                int kDataX = Integer.parseInt(kData[0]);
                int kDataY = Integer.parseInt(kData[1]);
                kMatrix[kDataX - 1][kDataY - 1] = 1;
            }
            for (int i = 0; i < n; i++) {   //行数
                for (int j = 0; j < m; j++) {             //列数
                    if (i == 0 && j == 0) {
                        pMatrix[i][j] = 1;
                    } else if (kMatrix[i][j] == 1) {
                        pMatrix[i][j] = 0;
                    } else {
                        pMatrix[i][j] = (i == 0 ? 0 : (j + 1 == m ? pMatrix[i - 1][j] : pMatrix[i - 1][j] * 0.5)) + (j == 0 ? 0 : (i + 1 == n ? pMatrix[i][j-1] : pMatrix[i][j-1] * 0.5));
                    }
                }
            }
            System.out.printf("%.2f\n", pMatrix[n-1][m-1]);
        }
        bf.close();
    }
}

