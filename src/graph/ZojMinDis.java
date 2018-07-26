package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GraphWithP {
    private int graphMatrix[][][]; //带有花费的图矩阵
    private int vertex[]; //顶点

    public GraphWithP(int verNumber) {
        graphMatrix = new int[verNumber][verNumber][2];
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix[0].length; j++) {
                for (int t = 0; t < graphMatrix[0][0].length; t++) {
                    if (i == j) graphMatrix[i][j][t] = 0;
                    else {
                        graphMatrix[i][j][t] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        vertex = new int[verNumber];
    }

    public boolean addEdge(int v1, int v2, int weight, int p) {
        if (v1 < 0 || v1 >= vertex.length || v1 < 0 || v2 >= vertex.length)
            return false;
        graphMatrix[v1][v2][0] = weight;
        graphMatrix[v2][v1][0] = weight;
        graphMatrix[v1][v2][1] = p;
        graphMatrix[v2][v1][1] = p;
        return true;
    }

    public boolean removeVertex(int v1, int v2) {
        if (v1 < 0 || v1 >= vertex.length || v1 < 0 || v2 >= vertex.length)
            return false;
        graphMatrix[v1][v2][0] = Integer.MAX_VALUE;
        graphMatrix[v2][v1][0] = Integer.MAX_VALUE;
        graphMatrix[v1][v2][1] = Integer.MAX_VALUE;
        graphMatrix[v2][v1][1] = Integer.MAX_VALUE;
        return true;
    }

    public int getFirstVertex(int v) {
        for (int i = 0; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v][i][0] > 0 && graphMatrix[v][i][0] < Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }

    public int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v1][i][0] > 0 && graphMatrix[v1][i][0] < Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }

    public int[][] distanceMin(int v) {
        int vertexNumber = this.vertex.length;
        int dis[][] = new int[vertexNumber][2];
        int vIn[] = new int[vertexNumber];
        vIn[v] = 1;
        dis[v][0] = 0; //权值为0
        dis[v][1] = 0;
        for (int i = 0; i < dis.length; i++) {
            dis[i][0] = graphMatrix[v][i][0];
            dis[i][1] = graphMatrix[v][i][1];
        }
        for (int i = 0; i < vertexNumber - 1; i++) {
            for (int j = 0; j < vertexNumber; j++) {
                if (dis[j][0] < Integer.MAX_VALUE) {
                    if (vIn[j] == 0) {
                        vIn[j] = 1;
                        for (int t = 0; t < vertexNumber; t++) {
                            if (dis[j][0] + graphMatrix[j][t][0] < dis[t][0]) {
                                dis[t][0] = dis[j][0] + graphMatrix[j][t][0];
                                dis[t][1] = dis[j][1] + graphMatrix[j][t][1];
                            } else if (dis[j][0] + graphMatrix[j][t][0] < dis[t][0]) {
                                if (dis[j][1] + graphMatrix[j][t][1] < dis[t][1]) {
                                    dis[t][1] = dis[j][1] + graphMatrix[j][t][1];
                                }
                            }
                        }
                    }
                }
            }
        }
        return dis;
    }
}

/***
 * 3 2
 * 1 2 5 6
 * 2 3 4 5
 * 1 3
 * 0 0
 */
public class ZojMinDis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            String[] a = str.split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            if (n==0&&m==0){
                break;
            }
            GraphWithP graphWithP = new GraphWithP(n);
            for (int i = 0; i < m; i++) {
                String[] b = br.readLine().split(" ");
                graphWithP.addEdge(Integer.parseInt(b[0])-1, Integer.parseInt(b[1])-1, Integer.parseInt(b[2])       , Integer.parseInt(b[3]));
            }
            String[] c=br.readLine().split(" ");
            int s=Integer.parseInt(c[0]);
            int t=Integer.parseInt(c[1]);
            int p[][]=graphWithP.distanceMin(s-1);
            System.out.println(p[t-1][0]+" "+p[t-1][1]);
        }
    }
}
