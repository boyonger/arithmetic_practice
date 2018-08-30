package graph.simpleGraph;

//simple 没有权值
class Graph{
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
                p = this.getNextVertex();
            }
        }
    }

}
public class GraphKnow {

}
