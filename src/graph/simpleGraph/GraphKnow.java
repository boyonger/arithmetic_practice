package graph.simpleGraph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//simple 没有权值
class Graph {
    private int graphMatrix[][];
    private int vertexList[];

    public Graph(int verNumber) {
        graphMatrix = new int[verNumber][verNumber];
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix[0].length; j++) {
                graphMatrix[i][j] = 0;
            }
        }
        vertexList = new int[verNumber];
    }

    public boolean addVertex(int v1, int v2) {
        if (v1 < 0 || v1 >= vertexList.length || v1 < 0 || v2 >= vertexList.length)
            return false;
        graphMatrix[v1][v2] = 1;
        graphMatrix[v2][v1] = 1;
        return true;
    }

    public int getFirstVertex(int v) {
        for (int i = 0; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v][i] > 0)
                return i;
        }
        return -1;
    }

    //&& graphMatrix[v1][i] < Integer.MAX_VALUE
    public int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v1][i] > 0)
                return i;
        }
        return -1;
    }


    public int dfs(int v) {
        int sum = 0;
        boolean isDone = false;
        boolean[] visited = new boolean[vertexList.length];
        this.dfs(v, visited);
        sum++;
        while (isDone == false) {
            isDone = true;
            for (int i = 0; i < vertexList.length; i++) {
                if (visited[i] == false) {
                    isDone = false;
                    this.dfs(i, visited);
                    sum++;
                }
            }
        }
        return sum;
    }

    //深度遍历以及广度遍历都只访问一次连通图。
    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        int p = this.getFirstVertex(v);
        while (p != -1) {
            if (visited[p] == false) {
                dfs(p, visited);
            } else {
                p = this.getNextVertex(v, p);
            }
        }
    }

}

/*
10
0
5 3 0
8 4 0
9 0
9 0
3 0
0
7 9 0
0
9 7 0
 */
public class GraphKnow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        Graph graph = new Graph(n);
        for (int i = 0; i < n; i++) {
            data = br.readLine().split(" ");
            for (int j = 0; Integer.parseInt(data[j]) != 0; j++) {
                graph.addVertex(i, Integer.parseInt(data[j])-1);
            }
        }
        System.out.println(graph.dfs(0));
    }
}
