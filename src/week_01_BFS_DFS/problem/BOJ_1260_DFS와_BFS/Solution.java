package week_01_BFS_DFS.problem.BOJ_1260_DFS와_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static Node[] nodes;
    static boolean[] visited;
    static int N,M,V;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        // 1. 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V 입력 받기
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 2. Node, visited 초기화
        nodes = new Node[N + 1];
        visited = new boolean[N + 1];

        // 3. 인접 리스트 생성
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node(i);
        }

        // 4. 간선 잇기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a, b);
        }

        // 5. 인접 리스트내에 작은 값부터 방문하기 위해 정렬 수행
        for(int i = 1; i <= N + 1; i++) {
            Collections.sort(nodes[i].adj);
        }

        // 6. dfs와 bfs를 실행, 간격을 두고 visited를 초기화 한다.
        dfs(V);
        sb.append("\n"); // 다음 bfs 출력을 위해 개행
        visited = new boolean[N + 1];
        bfs(V);

        // 7. 출력
        System.out.println(sb);





    }
    static void dfs(int start) {
        // 1. 방문 처리
        visited[start] = true;

        // 2. builder에 append
        sb.append(start).append(" ");

        // 3. 인접리스트 뽑아 내기
        List<Node> adj = nodes[start].adj;

        // 정점 번호가 작은 것부터 방문하기 위해 정렬을 수행.
//        Collections.sort(adj);

        // 4. 인접 리스트 순회
        for(Node next : adj) {
            if(!visited[next.id]) {
                dfs(next.id);
            }
        }


    }

    static void bfs(int start) {

        // 1. queue 생성 후 넣기
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[start]);

        // 2. 방문 처리
        visited[start] = true;
        sb.append(start).append(" ");

        // 3. 인접리스트 방문 처리
        while (!queue.isEmpty()) {

            // 1. 큐에서 꺼내기
            Node now = queue.poll();

            // 2. bulider에 넣기
            sb.append(now.id).append(" ");

            // 2. 인접리스트 뽑아낸 후 정렬 수행
            List<Node> adj = now.adj;
//            Collections.sort(adj);

            // 3. 인접 리스트 방문
            for (Node next : adj) {
                if(!visited[next.id]) {
                    visited[next.id] = true;
                    queue.add(next);
                }
            }
        }
    }


    // 인접 리스트 클래스
    static class Node implements Comparable<Node> {
        int id;
        List<Node> adj;

        public Node(int id) {
            this.id = id;
            this.adj = new ArrayList<>();
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.id, other.id);
        }
    }

    // 간선을 이을 메서드
    static void addEdge(int a, int b) {
        nodes[a].adj.add(nodes[b]);
        nodes[b].adj.add(nodes[a]);
    }
}
