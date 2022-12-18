package datastruct.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Graph { //无向图
    private int v; //顶点个数
    private LinkedList<Integer> adj[]; //邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { //无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索 bfs Breadth-First-Search 地毯式的层层推进的搜索策略
     * s 起始顶点
     * t 终止顶点
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (queue.size() != 0) {
//            int w =
        }
    }
}
