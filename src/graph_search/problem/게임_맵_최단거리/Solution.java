package graph_search.problem.게임_맵_최단거리;

// 두 팀으로 나누어 진행
// 상대 팀 진영을 먼저 파괴하면 이김
// 상대 팀 진여에 빨리 도착하는 것이 유리
// 나는 1,1에 있고 상대팀은 5,5에 있음

// map에서 1은 길, 0은 벽임
// 1인 길로 갔을 때 최대한 빠르게 가는 길을 찾기, BFS(0 이면 지나갈 수 없음)
// 핵심은 queue에서 새로 꺼내야 할때 count를 늘린다. 방문 여부도 필수(이미 방문한 값을 덮어 씌우기 방지, 미리 온게 최단거리)
// 0에서 시작, n-1, m-1에 도착

import java.util.*;

class Solution {

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {-1, 1, 0, 0};

    public int solution(int[][] maps) {

        int lenX = maps.length;
        int lenY = maps[0].length;

        boolean[][] visited = new boolean[lenX][lenY]; // 방문 여부

        bfs(0, 0, visited, maps, lenX, lenY);


        return maps[lenX-1][lenY-1] == 1 ? -1 : maps[lenX-1][lenY-1];
    }

    public static void bfs(int x, int y, boolean[][] visited, int[][] maps, int lenX, int lenY) {

        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;

        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] c = queue.poll();
            int cx = c[0];
            int cy = c[1];

            for(int i = 0; i < 4; i++) { // 네 방향 방문
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < lenX && ny >= 0 && ny < lenY && !visited[nx][ny] && maps[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    maps[nx][ny] += maps[cx][cy];
                    queue.add(new int[] {nx,ny});
                }
            }

        }


    }
}