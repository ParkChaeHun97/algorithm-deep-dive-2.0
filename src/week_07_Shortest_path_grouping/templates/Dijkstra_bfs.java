package week_07_Shortest_path_grouping.templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Dijkstra_bfs {
    static int V, E, start;
    static List<List<int[]>> graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(start);
        printResult();



    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void dijkstra(int start) {
        dist = new int[V + 1]; // 가중치 공간 생성
        Arrays.fill(dist, INF); // 가중치에 INF값으로 모두 채움
        dist[start] = 0; // start는 자기 자신이라 0임

        // 우선순위 큐 : 가중치 오름차순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); // 큐에서 꺼내서
            int node = cur[0];
            int d = cur[1];

            if (d > dist[node]) continue; // 오래된 정보 스킵

            for(int[] edge : graph.get(node)) {
                int next = edge[0]; // 다음 노드
                int weight = edge[1]; // 다음 노드의 가중치
                if(dist[node] + weight < dist[next]) { // 현재 가중치 + 다음 노드로 가는 가중치 보다 원래 저장 되어있는 가중치 크면?
                    dist[next] = dist[node] + weight; // 현재 가중치 + 다음 노드로 가는 가중치 저장
                    pq.offer(new int[]{next, dist[next]}); // pq에 넣음
                }
            }
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        start = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new int[]{v,w});
        }

    }

}
