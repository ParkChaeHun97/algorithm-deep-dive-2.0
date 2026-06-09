package week_01_BFS_DFS_adj.template.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * O(V + E)
 * V = Vertex, 노드의 개수
 * E = Edge, 연결선의 개수
 *
 * 노드가 30개고 연결이 100개면
 * 130번 순회
 *
 * */


public class _DFS_Template {

    static class Node {
        int id;
        List<Node> adj;

        public Node(int id, List<Node> adj) {
            this.id = id;
            this.adj = adj;
        }
    }

    public static void main(String[] args) {
        int N = 5;

        Node[] nodes = new Node[N + 1];
        boolean[] visited = new boolean[N + 1];

        //   1
        //  / \
        // 2   3
        // |   |
        // 4   5

        // 노드 5개 생성
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i, new ArrayList<>());
        }

        nodes[1].adj.add(nodes[2]);
        nodes[1].adj.add(nodes[3]);
        nodes[2].adj.add(nodes[4]);
        nodes[3].adj.add(nodes[5]);

        dfs(nodes[1], visited);
    }

    static void dfs(Node now,  boolean[] visited) {
        visited[now.id] = true;
        for(Node next : now.adj) {
            if(!visited[next.id]) {
                dfs(next, visited);
            }
        }
    }
}
