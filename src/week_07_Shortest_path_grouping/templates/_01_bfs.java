package week_07_Shortest_path_grouping.templates;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 가중치가 0 아니면 1뿐인 그래프에서 우선순위 큐 없이 Deque만으로 아기스트라와 같은 효과를 내는 기법
 *
 * 가중치 1인 간선을 타고 가면 back에 넣고
 * 가중치 0인 간선을 타고 가면 덱 앞에 넣음
 * 덱 안의 원소들은 거리 오름차순을 유지함
 *
 *
 * */

public class _01_bfs{
    static List<List<int[]>> graph = new ArrayList<>();
    static int[] dist;

    public static void zeroOneBFS(int start) {
        Deque<int[]> deque = new ArrayDeque<>();
        dist[start] = 0;
        deque.addFirst(new int[]{start, 0});

        while (!deque.isEmpty()) {
            int[] cur = deque.getFirst();
            int node = cur[0];
            int d = cur[1];

            if(d > dist[node]) continue;

            for (int[] edge : graph.get(node)) {
                int next = edge[0];
                int weight = edge[1];
                if(dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    if(weight == 0) deque.addFirst(new int[]{next, weight});
                    else deque.addLast(new int[]{next, weight});
                }
            }

        }
    }
}
