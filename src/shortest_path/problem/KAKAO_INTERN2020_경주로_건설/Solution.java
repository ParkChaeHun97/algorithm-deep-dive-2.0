package shortest_path.problem.KAKAO_INTERN2020_경주로_건설;

// 죠르디는 고객사로 부터 경주 건설에 필요한 견적 의뢰받음
// 경주 부지는 N x N
// 각 격자는 1 x 1
// 도면에는 0 또는 1
// 0은 칸이 비어있음 1은 칸이 벽으로 채워져 있음

// 출발 지점은 0,0
// 도착 지점은 N-1 N-1칸

// N-1, N-1칸 까지 끊기지 않도록 경주로 건설 -> BFS?
// 경주로는 상 하 좌 우 인접한 두 빈 칸을 건설 가능
// 벽이 있는 칸에는 경주로를 건설 할 수 없음

// 두 빈 칸을 상하 또는 좌우로 연결한 경주로를 "직선 도로"
// 두 직선 도로가 서로 직각으로 만나는 지점을 "코너"

// 직선 도로를 하나 만들 때는 100원
// 코너를 하나 만들 때는 500원

// 죠르디는 견적서 작성을 위해 건설하는 데 최소 비용 계산

// bfs로 돌리는데
// 최소 비용 기준으로 앞으로 나아간다.

// 다음 가는 비용이 코너인지 확인하는 상태가 필요함
// isConer == += 500;
// PQ에 넎는다.,
// 방문 여부 필요없음 (이미 가격이 갱신 되어있음)


// dx dy 필요

// 47 : 27 60점
// 예외케이스
// 완주를 못하는 경우는 없음
// n이 1이라면? 0 -> 배열 크기는 3이상 25 이하임 처리 x


// 먼저 발견한 경로가 항상 최저가가 아닐 수도 있음


import java.util.*;

class Solution {
    // 상, 하, 좌, 우
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length;
        return bfs(board, n);
    }

    public int bfs(int[][] board, int n) {
        // 우선순위 큐: [x, y, cost, direction]
        // cost가 작은 순서대로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));

        // 3차원 배열 선언: [x][y][direction] (direction: 0~3)
        // 각 위치에 특정 방향으로 들어왔을 때의 최소 비용을 저장
        int[][][] cost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }

        // (0, 0)에서 출발할 때는 아직 방향이 없으므로 4가지 방향 모두 초기 비용 0으로 시작
        // (실제 첫 이동 시에는 방향 전환 비용이 붙지 않도록 처리하기 위함)
        for (int i = 0; i < 4; i++) {
            pq.add(new int[]{0, 0, 0, i});
            cost[0][0][i] = 0;
        }

        int minCost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cx = curr[0];
            int cy = curr[1];
            int cCost = curr[2];
            int cDir = curr[3];

            // 목적지 도착 시 최솟값 갱신 (PQ 특성상 먼저 도달한 것이 최소 비용 아닐 수 있으므로 계속 탐색)
            if (cx == n - 1 && cy == n - 1) {
                minCost = Math.min(minCost, cCost);
                continue;
            }

            // 이미 기록된 비용보다 현재 비용이 크다면 탐색할 필요 없음 (가지치기)
            if (cCost > cost[cx][cy][cDir]) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nDir = i;

                // 범위를 벗어나거나 벽인 경우 스킵
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) continue;

                // 비용 계산: 직선 도로는 100원, 방향이 바뀌면 코너(500원) 추가
                // 단, 출발점(0,0)에서 첫 칸으로 갈 때는 방향이 고정되어 있지 않으므로 코너 비용을 추가하지 않음
                int nextCost = cCost;
                if (cx == 0 && cy == 0) {
                    nextCost += 100;
                } else {
                    if (cDir == nDir) {
                        nextCost += 100; // 직선
                    } else {
                        nextCost += 600; // 직선(100) + 코너(500)
                    }
                }

                // 더 적은 비용으로 해당 방향에 도달할 수 있는 경우에만 큐에 삽입
                if (nextCost < cost[nx][ny][nDir]) {
                    cost[nx][ny][nDir] = nextCost;
                    pq.add(new int[]{nx, ny, nextCost, nDir});
                }
            }
        }

        return minCost;
    }
}



