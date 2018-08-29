package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;

//邻接表无向图
public class GraphLink {

    private class Edge {
        int vexNumber; //指后一个顶点
        int weight; //权值
        Edge nextEdge;

        public Edge() {

        }

        public Edge(int vexNumber, int weight) {
            this.vexNumber = vexNumber;
            this.weight = weight;
            this.nextEdge = null;
        }
    }

    private class Vertex {
        char data; //顶点定义，如顶点名字
        Edge firstEdge;

        public Vertex() {

        }

        public Vertex(char data) {
            this.data = data;
            this.firstEdge = null;
        }
    }

    private Vertex[] mVertex;

    //构造函数，编号从0开始
    public GraphLink(int number, int edge[][]) {
        mVertex = new Vertex[number];
        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            int weight = 0;
            this.insertEdge(v1, v2, weight);
        }

    }

    public boolean insertEdge(int v1, int v2, int weight) {
        if (v1 >= mVertex.length || v2 >= mVertex.length) return false;
        Edge p = mVertex[v1].firstEdge;
        while (p != null) {
            if (p.vexNumber == v2) return false;
            p = p.nextEdge;
        }
        p = new Edge(v2, weight);
        //头插法,每次都会插入两个，判断一次即可
        p.nextEdge = mVertex[v1].firstEdge;
        mVertex[v1].firstEdge = p;

        Edge q = new Edge(v1, weight);
        q.nextEdge = mVertex[v2].firstEdge;
        mVertex[v2].firstEdge = q;
        return true;
    }

    public boolean removeEdge(int v1, int v2) {
        if (v1 >= mVertex.length || v2 >= mVertex.length) return false;
        Edge p = mVertex[v1].firstEdge;
        if (p == null) {
            return false;
        }
        //没有附加头结点，则需要处理头结点分开得情况
        if (p.vexNumber == v2) {
            mVertex[v1].firstEdge = p.nextEdge;
        } else {
            while (p.nextEdge != null) {
                if (p.nextEdge.vexNumber == v2)
                    break;
            }
            if (p.nextEdge != null) {
                p.nextEdge = p.nextEdge.nextEdge;
            } else {
                return false;
            }
        }

        //对应的
        Edge q = mVertex[v2].firstEdge;
        if (q == null) {
            return false;
        }
        if (q.vexNumber == v1) {
            mVertex[v2].firstEdge = p.nextEdge;
        } else {
            while (q.nextEdge != null) {
                if (q.nextEdge.vexNumber == v1) {
                    break;
                }
            }
            if (q.nextEdge != null) {
                q.nextEdge = q.nextEdge.nextEdge;
            } else {
                return false;
            }
        }
        return true;
    }


    public boolean removeVertex(int v) {
        if (v >= mVertex.length) return false;
        while (mVertex[v].firstEdge != null) {
            this.removeEdge(v, mVertex[v].firstEdge.vexNumber);
        }
        return true;
    }

    //顺便返回多少连通块
    public int dfs(int v) {
        int sum = 0;
        boolean isDone = false;
        boolean[] visited = new boolean[mVertex.length];
        this.dfs(v, visited);
        sum++;
        while (isDone == false) {
            isDone = true;
            for (int i = 0; i < mVertex.length; i++) {
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
        Edge p = mVertex[v].firstEdge;
        while (p != null) {
            if (visited[p.vexNumber] == false) {
                dfs(p.vexNumber, visited);
            } else {
                p = p.nextEdge;
            }
        }
    }

    //广度优先遍历
    private void bfs(int v) {
        boolean[] visited = new boolean[mVertex.length];
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(mVertex.length);
        visited[v] = true;
        queue.add(v);
        while (!queue.isEmpty()){
            int vertexPos=queue.poll();
            Edge p=mVertex[vertexPos].firstEdge;
            while (p!=null){
                if (visited[vertexPos]!=true){
                    visited[v]=true;
                    queue.add(p.vexNumber);
                }
                p=p.nextEdge;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int n= Integer.parseInt(data[0]);
        int[] edge=new int[][2];
        GraphLink graphLink=new GraphLink(n);
        for (int i=0;i<n;i++){
            data=br.readLine().split(" ");

        }

    }


}
