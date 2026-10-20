package graph_search.problem.PGS_여행_경로;

import java.util.*;

class Solution {
    boolean[] visited;
    String bestRoute = null;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        // 1. 티켓의 도착지 기준으로 미리 정렬
        // 이렇게 하면 DFS가 알파벳 순서대로 먼저 탐색함
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        dfs("ICN", "ICN", tickets, 0);

        return bestRoute.split(" ");
    }

    private boolean dfs(String current, String route, String[][] tickets, int count) {
        // 모든 티켓을 사용한 경우
        if (count == tickets.length) {
            bestRoute = route;
            return true; // 첫 번째로 찾아낸 경로가 곧 알파벳 최우선 경로이므로 탐색 종료
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                visited[i] = true;
                // 이미 정렬된 상태이므로 먼저 탐색되는 것이 알파벳 순으로 가장 빠름
                if (dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1)) {
                    return true; // 찾았으면 더 이상 다른 길 볼 필요 없이 쭉 빠져나감
                }
                visited[i] = false; // 백트래킹
            }
        }
        return false;
    }
}
