package normal;

/*
度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
输入描述:
第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CutPaper {
    public static void main(String[] args) throws IOException {
        //Scanner in = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str;
        Integer number = 0;
        while ((str = bf.readLine()) != null) {
        //while (in.hasNext()){
            number = Integer.parseInt(str); //number = in.nextInt();
            int[][] save = new int[number][2];
            for (int i = 0; i < number&& ((str = bf.readLine()) != null) ; i++) {     //&&
                String[] data = str.split(" ");
                save[i][0] = Integer.parseInt(data[0]);  //in.nextInt();
                save[i][1] = Integer.parseInt(data[1]);  //in.nextInt();
            }

            int maxx = save[0][0];
            int maxy = save[0][1];
            int minx = save[0][0];
            int miny = save[0][1];
            for (int i = 0; i < save.length; i++) {
                if (maxx < save[i][0]) {
                    maxx = save[i][0];
                } else if (minx > save[i][0]) {
                    minx = save[i][0];
                }
                if (maxy < save[i][1]) {
                    maxy = save[i][1];
                } else if (miny > save[i][1]) { //=save[i][0] ???
                    miny = save[i][1];
                }
            }
            int xsquare = (maxx - minx) * (maxx - minx);
            int ysquare = (maxy - miny) * (maxy - miny);

            if (xsquare > ysquare)
                System.out.println(xsquare);
            else System.out.println(ysquare);
        }
    }
}
