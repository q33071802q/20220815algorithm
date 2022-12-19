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

    /**
     * 添加边
     *
     * @param s 顶点
     * @param t 顶点
     */
    public void addEdge(int s, int t) { //无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度优先搜索 bfs Breadth-First-Search 地毯式的层层推进的搜索策略
     * s 起始顶点
     * t 终止顶点
     * <p>
     * 空间复杂度 O（V+E）V表示顶点的个数 E表示边的个数
     * 最差的情况下 每个顶点都要进出一遍队列 每个边都要被访问一次
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        //visited用来记录已经被访问的顶点，用来避免顶点被重复访问
        boolean[] visited = new boolean[v];
        visited[s] = true;
        //queue是一个队列 用来存储已经被访问 但相连的顶点还没有被访问的顶点
        Queue<Integer> queue = new LinkedList<>();
        /**
         * 初始化 存储首顶点
         */
        queue.add(s);
        //prev用来记录搜索路径
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        /**
         * 每个进队的都会在循环中找到自己的邻接表顶点
         */
        while (queue.size() != 0) {
            /**
             * 取出顶点
             */
            int w = queue.poll();
            /**
             * 遍历取出顶点的邻接表
             */
            for (int i = 0; i < adj[w].size(); ++i) {
                /**
                 * 取出邻接表中的顶点
                 */
                int q = adj[w].get(i);
                if (!visited[q]) {
                    /**
                     * 如果该邻接表的顶点没有被访问过
                     * 记录搜索路径 prev[q] = w
                     * 表示路径为w->q q的上一个路径是w
                     */
                    prev[q] = w;
                    if (q == t) {
                        /**
                         * 如果该顶点就是要查找的最终顶点的话
                         * 打印路径 并return
                         */
                        print(prev, s, t);
                        return;
                    }
                    /**
                     * 不是查找的终点路径 将查找到的顶点标记访问过
                     * 并把该顶点放入需要查询的队列中 循环继续查找下一个
                     */
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }

    /**
     * 打印s到t 的路径
     *
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            /**
             * prev[t] = -1表示该顶点是首顶点
             * prev[t]表示t的上一个顶点 递归 最终条件必然是t = s 跳出递归
             */
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        graph.bfs(0, 6);
    }

    /**
     * 表示是否找到
     */
    boolean found = false;

    /**
     * 深度优先搜索
     *
     * @param s
     * @param t
     */
    public void dfs(int s, int t) {
        /**
         * 初始化数组长度 方便后续记录
         */
        found = false;
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    /**
     * 有点没理解 深度不应该是根据一个顶点一直找
     * 找不到再回到最后一个顶点的上一个顶点寻找么
     * 0.0理解了 这里好像并没有所谓的回朔 仅仅是贪心算法
     * 对每个顶点循环 对每个顶点的邻接表顶点查找到死
     * 哦 我知道了 有回退 因为在循环中 没找到邻接表顶点对应的路径
     * 就会回到上一级 继续从那个顶点开始寻找
     * @param w
     * @param t
     * @param visited
     * @param prev
     */
    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        /**
         * 从开始的首顶点开始 对每个顶点的邻接表上的顶点进行get
         * 再对get到的每个顶点去获取对应的邻接表
         *
         */
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
