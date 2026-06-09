package week_01_BFS_DFS_adj.problem.BOJ_18352_특정_거리의_도시_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static int N, M, K, X;
    static boolean[] visited;
    static Node[] nodes;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 1. N, M, K, X 입력받기 도시의 갯수, 도로의 개수, 거리 정보, 출발 도시의 번호
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 2. nodes, visited 크기 할당
        visited = new boolean[N + 1];
        nodes = new Node[N + 1];

        // 3. 노드 마다 adj 생성
        for (int i = 1; i <= N ; i++) {
            nodes[i] = new Node(i);
        }

        // 4. eddEdge
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a,b);
        }

        // 5. 오름차순 출력을 위해 adj 마다 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(nodes[i].adj);
        }

        bfs(X);

        Collections.sort(results);

        for (int i = 0; i < results.size(); i++) {
            sb.append(results.get(i)).append("\n");
        }



        System.out.println(results.size() == 0 ? -1 : sb);



        /**
         * bfs가 최단거리에 적합, 방문처리를 하면 최단거리를 따질 수 있음
         * 방문은 항상 오름차순으로 해야하기 때문에 adj마다 정렬을 해둔다.
         * 목표치에 도달했으면 출력
         * k보다 크면? queue에 넣지 않는다.
         * */
    }

    static void addEdge(int a, int b) {
        nodes[a].adj.add(nodes[b]);
    }

    static void bfs(int start) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(nodes[start]);

        visited[start] = true;

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            for (Node next : current.adj) {
                if(!visited[next.id]) {
                    visited[next.id] = true;
                    next.weight = current.weight + 1;

                    if(next.weight == K) {
                        results.add(next.id);
                        continue;
                    }
                    queue.offer(next);
                }
            }

        }

    }


    static class Node implements Comparable<Node>{
        int id;
        int weight;
        List<Node> adj;

        public Node(int id) {
            this.id = id;
            this.weight = 0;
            this.adj = new ArrayList<>();
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.id, other.id);
        }
    }
}


