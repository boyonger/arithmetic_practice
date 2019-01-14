package writtenExam.toutiao1021.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Graph {
    private int graphMatrix[][];
    private int vertex[];

    public Graph(int verNumber) {
        graphMatrix = new int[verNumber][verNumber];
        for (int i = 0; i < graphMatrix.length; i++) {
            for (int j = 0; j < graphMatrix[0].length; j++) {
                if (i == j) graphMatrix[i][j] = Integer.MAX_VALUE;
                else {
                    graphMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        vertex = new int[verNumber];
    }

    public boolean addVertex(int v1, int v2, int weight) {
        if (v1 < 0 || v1 >= vertex.length || v1 < 0 || v2 >= vertex.length)
            return false;
        graphMatrix[v1][v2] = weight;
        graphMatrix[v2][v1] = weight;
        return true;
    }

    public boolean removeVertex(int v1, int v2) {
        if (v1 < 0 || v1 >= vertex.length || v1 < 0 || v2 >= vertex.length)
            return false;
        graphMatrix[v1][v2] = Integer.MAX_VALUE;
        graphMatrix[v2][v1] = Integer.MAX_VALUE;
        return true;
    }

    public int getFirstVertex(int v) {
        for (int i = 0; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v][i] > 0 && graphMatrix[v][i] < Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }

    public int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v1][i] > 0 && graphMatrix[v1][i] < Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }

    public int dfs(int v) {
        int sum = 0;
        boolean isDone = false;
        boolean[] visited = new boolean[vertex.length];
        this.dfs(v, visited);
        sum++;
        while (isDone == false) {
            isDone = true;
            for (int i = 0; i < vertex.length; i++) {
                if (visited[i] == false) {
                    isDone = false;
                    this.dfs(i, visited);
                    sum++;
                }
            }
        }
        return sum;
    }

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

public class Main {
    public static void main(String[] args) throws IOException {
        int p = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        int[][] matrix = new int[m][2];
        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            data = br.readLine().split(" ");
            matrix[i][0] = Integer.parseInt(data[0]) - 1;
            matrix[i][1] = Integer.parseInt(data[1]) - 1;
            graph.addVertex(Integer.parseInt(data[0]) - 1, Integer.parseInt(data[1]) - 1, 1);
        }
        for (int i = 0; i < m; i++) {
            int time = Integer.parseInt(br.readLine());
            graph.removeVertex(matrix[time - 1][0], matrix[time - 1][1]);
            int count = graph.dfs(0);
            if (count > 1 && p > i + 1) {
                p = i + 1;
            }
        }
        System.out.println(p);
    }
}
