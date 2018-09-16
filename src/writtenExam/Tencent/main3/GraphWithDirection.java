package writtenExam.Tencent.main3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//两个有向图，检测每个点可达点以及所有可达这个点的点。
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

    //计算到达的城市数
    public int dfs(int v) {
        int sum = 0;
        boolean[] visited = new boolean[vertexList.length];
        this.dfs(v, visited);
        for (int i = 0; i < vertexList.length; i++) {
            if (visited[i]==true){
                sum++;
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

public class GraphWithDirection {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n = Integer.parseInt(data[0]);
        int m = Integer.parseInt(data[1]);
        Graph graphCanTo = new Graph(n);
        Graph graphCanFrom = new Graph(n);
        for (int i = 0; i < m; i++) {
            data = br.readLine().trim().split(" ");
            graphCanTo.addVertex(Integer.parseInt(data[0]) - 1, Integer.parseInt(data[1]) - 1);
            graphCanFrom.addVertex(Integer.parseInt(data[1]) - 1, Integer.parseInt(data[0]) - 1);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int sumGo = graphCanTo.dfs(i);
            int sumFrom = graphCanFrom.dfs(i);
            if (sumFrom > sumGo) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
