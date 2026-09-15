package week_10_brush_up_on_algorithm.dijkstra.BOJ_1261_알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3 3
 * 011
 * 111
 * 110
 *
 * 핵심 아이디어 0-1 bfs
 * 0이면 앞에 넣고 1이면 뒤에 넣는다.
 *
 * 3
 * */
public class Solution {
    final static int[] dy = {-1, 1, 0, 0};
    final static int[] dx = {0, 0, -1, 1};
    static int M, N;

    static int[][] map;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로 M
        M = Integer.parseInt(st.nextToken());
        // 세로 N
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        // map 입력받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(new int[] {0,0}));


    }

    public static int bfs(int[] start) {
        for(int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;

        Deque<int[]> deque = new ArrayDeque<>();

        deque.offerFirst(start);

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny >= 0 && ny < N && nx >= 0 && nx < M) {

                    int newDist = dist[cy][cx] + map[ny][nx];

                    if(newDist > dist[ny][nx]) continue;

                    dist[ny][nx] = newDist;


                    if(map[ny][nx] == 1) {
                        deque.offerLast(new int[]{ny,nx});
                    }else {
                        deque.offerFirst(new int[]{ny,nx});
                    }

                }

            }

        }
        return dist[N-1][M-1];
    }

}
