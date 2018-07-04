package graph;

import java.util.Arrays;
import java.util.Queue;
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
        if (p.vexNumber == v2) {
            mVertex[v1].firstEdge = p.nextEdge;
        }
        while (p.nextEdge != null) {
            if (p.nextEdge.vexNumber == v2) {
                break;
            }
            p = p.nextEdge;
        }
        if (p.nextEdge != null) {
            //那就是=下一个就要删除的
            p.nextEdge = p.nextEdge.nextEdge;
        } else {
            return false;
        }

        Edge q = mVertex[v2].firstEdge;
        if (q == null) return false;
        if (q.vexNumber == v1) {
            mVertex[v2].firstEdge = p.nextEdge;
        }
        while (q.nextEdge != null) {
            if (q.nextEdge.vexNumber == v1) {
                break;
            }
            q = q.nextEdge;
        }
        if (q.nextEdge != null) {
            q.nextEdge = q.nextEdge.nextEdge;
        } else {
            return false;
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
        int sum=0;
        boolean isDone=false;
        boolean[] visited = new boolean[mVertex.length];
        this.dfs(v,visited);
        while (isDone==false){
            isDone=true;
            for (int i=0;i<mVertex.length;i++){
                if (visited[i]==false){
                    isDone=false;
                    this.dfs(i,visited);
                }
            }
        }


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

    public void bfs(int v){

    }

    private void bfs(int v,boolean[] visited){
        ArrayBlockingQueue<Integer> queue=new ArrayBlockingQueue<>(mVertex.length);
        visited[v] =true;
        queue.put();



    }





}
