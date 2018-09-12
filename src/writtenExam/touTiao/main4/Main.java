package writtenExam.touTiao.main4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Graph {
    private int graphMatrix[][];
    private int vertexList[];
    public Set<Integer> set=new HashSet<>();

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
        graphMatrix[v1][v2] = 1;
        return true;
    }

    public int getFirstVertex(int v) {
        for (int i = 0; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v][i] > 0)
                return i;
        }
        return -1;
    }

    public int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v1][i] > 0)
                return i;
        }
        return -1;
    }


    public int dfs(int v) {
        int sum = 0;
        boolean isDone = true;
        boolean[] visited = new boolean[vertexList.length];
        this.dfs(v, visited);
        for (int i = 0; i < vertexList.length; i++) {
            if (visited[i] == false) {
                isDone = false;
            }
        }
        if (isDone == true) sum++;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int m = Integer.parseInt(br.readLine().trim());
        Graph graph = new Graph(n);
        String[] data = br.readLine().trim().split(" ");
        for (int i = 0; i < m; i++) {
            graph.addVertex(Integer.parseInt(data[2 * i + 1])-1,Integer.parseInt(data[2 * i])-1);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = graph.dfs(i) + sum;
        }
        System.out.println(sum);
    }
}
