package week_01_BFS_DFS.problem.BOJ_11725_트리의_부모_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static int N; // 노드의 개수
    static boolean[] visited; // 방문 여부
    static Node[] nodes; // 노드들이 담긴 배열
    static int[] parents; // 부모를 기록할 배열

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. N 입력 받기
        N = Integer.parseInt(br.readLine());

        // 2. visited, nodes, parents 초기화
        visited = new boolean[N + 1]; // N이 7이면 7번까지 사용

        nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        parents = new int[N + 1];

        // 3. 간선 추가, 간선은 N-1만큼 추가된다.
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a, b);
        }

        // 4. dfs
        dfs(1);

        // 5. 2번 부터 N번까지 sb에 append
        for (int i = 2; i <= N; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);


    }


    // dfs는 구현이 간단해서 선택
    static void dfs(int start) {
        visited[start] = true;
        for (Node next : nodes[start].adj) {
            if(!visited[next.id]) {
                // parnets에 기록
                parents[next.id] = start;
                dfs(next.id);
            }
        }
    }

    static void addEdge(int a, int b) {
        nodes[a].adj.add(nodes[b]);
        nodes[b].adj.add(nodes[a]);
    }

    static class Node {
        int id;
        List<Node> adj;

        public Node(int id) {
            this.id = id;
            this.adj = new ArrayList<>();
        }
    }
}
