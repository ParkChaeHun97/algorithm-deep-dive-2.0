package week_07_Shortest_path_grouping.Remind;

import java.util.ArrayList;
import java.util.List;

/**
 * 깊이 우선 탐색
 * Stack이나 재귀를 활용 한다.
 * */

public class DFS_Remind {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited; // 방문 여부
    public static void main(String[] args) {

        int n = 5;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];


        /**
         *    1
         *   / \
         *  2   3
         *  |   |
         *  4 - 5
         * */

        // 그래프 생성
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(2, 4);
        addEdge(3, 5);
        addEdge(4, 5);

        dfs(1);


    }

    private static void dfs(int start) {
        // 1. 들어왔으면 방문 처리
        visited[start] = true;
        System.out.println(start);

        for (int next : graph.get(start)) {
            if(!visited[next]) {
                dfs(next);
            }
        }

    }

    // 양방향으로 생성
    private static void addEdge(int a, int b) {
        graph.get(a).add(b);
        graph.get(b).add(a);
    }
}
