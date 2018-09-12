package writtenExam.jd.main1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

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

    public int getNextVertex(int v1, int v2) {
        for (int i = v2 + 1; i < this.graphMatrix.length; i++) {
            if (graphMatrix[v1][i] > 0)
                return i;
        }
        return -1;
    }


    public boolean dfs(int v) {
        Set<Set<Integer>> set = new HashSet<>(); //不能
        for (int i = 0; i < vertexList.length; i++) {
            boolean[] visited = new boolean[vertexList.length];
            this.dfs(v, visited);
            for (int  j= 0; j < vertexList.length; j++) {
                if (visited[j] == true) {
                    for (int k=0;k<set.size();k++){
                        if(!set.contains(j)){
                            Set<Integer> twoSet=new HashSet<>();
                            twoSet.add(j);
                            set.add(twoSet);
                        }
                    }

                }
            }
        }
        return false;
    }


    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        int p = this.getFirstVertex(v);
        while (p != -1) {
            if (visited[p] == false) {
                visited[p] = true;
                //dfs(p, visited);
            } else {
                p = this.getNextVertex(v, p);
            }
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < count; i++) {
            String[] data = br.readLine().split(" ");
            int n = Integer.parseInt(data[0]);
            Graph graph = new Graph(n);
            int m = Integer.parseInt(data[1]);
            for (int j = 0; j < m; j++) {
                data = br.readLine().split(" ");
                graph.addVertex(Integer.parseInt(data[0]) - 1, Integer.parseInt(data[1]) - 1);
            }
            if (graph.dfs(0)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
