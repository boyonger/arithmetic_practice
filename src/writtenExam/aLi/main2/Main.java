package writtenExam.aLi.main2;
/*
小广附近有家盒马店，该店提供配送服务，配送范围是系统根据各项指标决策出的一个多边形，假设小广现在的位置为（x,y），请问小广是否在该盒马店的配送范围内，如果不在配送范围内请问他要最少要走多少距离才能到盒马店配送范围内。假设坐标点在二维平面上，不考虑地球曲率等因素。



输入：

x,y(代表小广所在的位置，x表示横坐标，y表示纵坐标)

x1,y1,x2,y2,x3,y3....xn,yn(代表该盒马店的配送范围多边形，其中x表示横坐标，y表示纵坐标，xi和yi代表多边形一个点，点与点按顺序相连形成边，并且最后一个点(xn,yn)与第一个点(x1,y1)相连）

输出：

请问小广是否在盒马店的配送范围内，如果不在配送范围内请问他要最少走多少距离才能到盒马店配送范围内，输出结果为整数（四舍五入）



举例说明：

输入：

1,1
0,0,0,2,2,2,2,0

输出：

yes,0



输入：

2,2
0,0,0,2,2,2,2,0

输出：

yes,0



输入：

3,0
0,0,0,2,2,2,2,0

输出：

no,1



输入：

3,4
0,0,0,2,2,2,2,0

输出：

no,2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(",");
        int[] pos = new int[2];
        boolean isIn = false;
        pos[0] = Integer.parseInt(data[0]);
        pos[1] = Integer.parseInt(data[1]);
        data = br.readLine().split(",");
        int[][] pointList = new int[data.length / 2][2];
        for (int i = 0; i < data.length / 4; i++) {
            for (int j = 0; j < 2; j++) {
                pointList[i][j] = Integer.parseInt(data[2 * i + j]);
            }
        }
        double[][] functionList = new double[data.length / 2 - 1][2];
        int east = 0, west = 0;
        for (int i = 0; i < pointList.length - 1; i++) {
            if (pointList[i][0] == pos[0] && pointList[i][1] == pos[1]) {
                isIn = true;
                break;
            }
            functionList[i] = solve(pointList[i][0], pointList[i][1], pointList[i + 1][0], pointList[i + 1][1]);
        }
        if (isIn == false) {
            for (int i = 0; i < pointList.length; i++) {
                double bananaPointX = (pos[1] - functionList[i][1]) / functionList[i][0];
                if (bananaPointX < pos[0]) {
                    west++;
                } else {
                    east++;
                }
            }
            if (east % 2 != 0 && west % 2 != 0) {
                isIn = true;
            }
        }

        if (isIn == true) {
            System.out.println("yes,0");
        } else {
            double min = Double.MAX_VALUE;
            for (int i = 0; i < pointList.length - 1; i++) {
                double b;
                b = analyzeDis(pos[0], pos[1], pointList[i][0], pointList[i][1], pointList[i + 1][0], pointList[i + 1][1]);
                if (min > b) {
                    min = b;
                }
            }
            System.out.println("no" + Math.round(min));
        }


    }

    public static double[] solve(int x1, int y1, int x2, int y2) { //求k.z
        double k;
        if ((x2 - x1) == 0) {
            k = 1;
        } else {
            k = (y2 - y1) / (x2 - x1);
        }
        double z = (y1 + y2) - k * (x1 + x2);
        double[] a = new double[2];
        a[0] = k;
        a[1] = z;
        return a;
    }

    public static double analyzeDis(int x0, int y0, int x1, int y1, int x2, int y2) {
        double a, b, c;
        double distance = 0;
        a = lineDis(x1, y1, x2, y2);// 线段的长度
        b = lineDis(x1, y1, x0, y0);// (x1,y1)到点的距离
        c = lineDis(x2, y2, x0, y0);// (x2,y2)到点的距离
        if (c <= 0.000001 || b <= 0.000001) {
            distance = 0;
            return distance;
        }
        if (a <= 0.000001) {
            distance = b;
            return distance;
        }
        if (c * c >= a * a + b * b) {
            distance = b;
            return distance;
        }
        if (b * b >= a * a + c * c) {
            distance = c;
            return distance;
        }
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        distance = 2 * s / a;
        return distance;
    }

    private static double lineDis(int x1, int y1, int x2, int y2) {

        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

    }
}
