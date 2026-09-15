package week_10_brush_up_on_algorithm.dijkstra.BOJ_1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int start;
    static int V, E;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Graph graph = input();
        graph.addEdge(E);
        int[] result = graph.dijkstra(start);
        printDist(result);
    }

    private static void printDist(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i] == Integer.MAX_VALUE ? "INF" : result[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }


    public static Graph input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        
        Graph graph = new Graph(V);


        return graph;
    }

static class Graph {
    List<List<int[]>> list = new ArrayList<>();

    public Graph(int V) {
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void addEdge(int E) throws IOException {
        for (int i = 1; i <= E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            this.list.get(a).add(new int[]{b, weight});
        }
    }

    public int[] dijkstra(int start) {
        int[] dist = new int[this.list.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        dist[start] = 0;

        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int d = current[1];

            // 현재 저장되 있는값 보다 가중치가 더크면? 스킵
            if (d > dist[node]) continue;


            for (int[] edge : this.list.get(node)) {
                int next = edge[0];
                int weight = edge[1];

                if (dist[next] > dist[node] + weight) {
                    dist[next] = dist[node] + weight;
                    pq.add(new int[]{next, dist[next]});
                }
            }

        }

        return dist;

    }

}
}
