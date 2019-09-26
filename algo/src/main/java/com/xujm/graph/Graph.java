package com.xujm.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * 用邻接表来存储图
 *
 * @author xujm
 * @date 2019/09/26
 */
public class Graph {
    /**
     * 顶点个数
     */
    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        //无向图一条边存2次
        adj[s].add(t);
        adj[t].add(s);
    }

    /**
     * 广度搜索
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        while (queue.size() > 0) {
            int node = queue.poll();
            for (Integer next : adj[node]) {
                if (visited[next]) {
                    continue;
                }
                pre[next] = node;
                if (next == t) {
                    print(pre, s, t);
                    return;
                } else {

                }
                visited[next] = true;
                queue.add(next);
            }
        }
    }

    private void print(int[] pre, int s, int t) {
        if (-1 != pre[t] && s != pre[t]) {
            print(pre, s, pre[t]);
        }
        System.out.print(t + ",");
    }

    boolean found = false; // 全局变量或者类成员变量


    /**
     * 深度搜索
     */
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int[] pre = new int[v];
        for (int i = 0; i < v; i++) {
            pre[i] = -1;
        }
        recurDfs(s, t, visited, pre);
        print(pre, s, t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }
}
