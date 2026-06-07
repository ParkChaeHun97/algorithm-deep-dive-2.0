package week_01_BFS_DFS.problem.BOJ_11724_연결_요소의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static Node[] nodes;
    static boolean[] visited;
    static int N, M;
    static BufferedReader br;
    static StringTokenizer st;

    static int count;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nodes = new Node[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N ; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            addEdge(u, v);
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);


    }

    static void dfs(int start) {
        visited[start] = true;

        for (Node next : nodes[start].adj) {
            if(!visited[next.id]) {
                dfs(next.id);
            }
        }

    }


    static class Node {
        int id;
        List<Node> adj;

        public Node(int id) {
            this.id = id;
            this.adj = new ArrayList<>();
        }
    }

    static void addEdge(int a, int b) {
        nodes[a].adj.add(nodes[b]);
        nodes[b].adj.add(nodes[a]);
    }

}
