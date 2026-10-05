package kakao_prablom.kakao_try_out_2017.카카오프렌즈_컬러링북;
/**
 * 방문하지 않은 구역일떄 ++
 * 같은 번호일때만 주변 경로 방문
 * bfs로 체크
 */

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] array = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}
        };
        s.solution(6, 4, array);
    }

    final static int[] dx = {0, 0, -1, 1};
    final static int[] dy = {-1, 1, 0, 0};

    public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] != 0 && !visited[i][j]) {
                    int number = picture[i][j];
                    numberOfArea++;

                    int value = bfs(new int[]{i, j}, number, visited, m, n, picture);
                    if(value > maxSizeOfOneArea) {
                        maxSizeOfOneArea = value;
                    }

                }
            }
        }



        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static int bfs(int[] current, int number,
                          boolean[][] visited, int m, int n, int[][] picture) {
        Queue<int[]> queue = new ArrayDeque<>();

        visited[current[0]][current[1]] = true;

        int count = 1;

        queue.add(current);

        while(!queue.isEmpty()) {
            int[] cr = queue.poll();
            int cx = cr[0];
            int cy = cr[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 방문 가능하고, number랑 같으면? (0은 이미 제외)
                if(nx >= 0 && nx < m && ny >= 0 && ny < n &&
                        !visited[nx][ny] && picture[nx][ny] == number) {
                    visited[nx][ny] = true;
                    count++;
                    queue.add(new int[]{nx, ny});
                }

            }

        }

        return count;

    }


}
