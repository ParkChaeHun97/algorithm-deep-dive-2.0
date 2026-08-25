package week_07_Shortest_path_grouping.templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra_O_V2 {
    static final int INF = Integer.MAX_VALUE;
    static List<List<int[]>> graph = new ArrayList<>(); // List<다음정점, 가중치]>
    public static void main(String[] args) {
        int V = 4; // 정점 개수
        int start = 1; // 시작 정점


        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        addEdge(1, 2, 2);
        addEdge(1, 3,5);
        addEdge(2, 3, 1);
        addEdge(2, 4, 7);
        addEdge(3, 4, 3);

        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean[] visited = new boolean[V + 1];

        for (int i = 0; i < V; i++) {
            // 1. 미방문 정점 중 dist가 가장 작은 정점 찾기
            int minNode = -1;
            int minDist = INF;
            for (int j = 1; j <= V; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minNode = j;
                }
            }

            if (minNode == -1) break; // 남은 정점이 전부 도달 불가능

            visited[minNode] = true; // 최단거리 확정

            // 2. minNode를 거쳐서 갈 수 있는 인접 정점들 거리 갱신 (relaxation)
            for (int[] edge : graph.get(minNode)) {
                int next = edge[0];
                int weight = edge[1];

                if (dist[minNode] != INF && dist[minNode] + weight < dist[next]) {
                    dist[next] = dist[minNode] + weight;
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    private static void addEdge(int a, int b, int weight) {
        graph.get(a).add(new int[] {b, weight});
        graph.get(b).add(new int[] {a, weight});
    }
}
