package kakao_prablom.kakao_winter_internship_2021.거리두기_확인하기;

import java.util.ArrayDeque;
import java.util.Queue;

//
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        String[][] places2 = {
                {"POOOO", "XOOOO", "POOOO", "OOOOO", "OOOOO"},  // F
                {"POOPO", "OOOOO", "OOOOO", "OOOOO", "OOOOO"},  // G
                {"PPOOO", "OOOOO", "OOOOO", "OOOOO", "OOOOP"},  // H
                {"POOOO", "OOOOO", "OOOOO", "OOOOO", "OOOPP"},  // I
                {"OOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOPP"}   // J
        };
        s.solution(places2);
    }

    public int[] solution(String[][] places) {

        int[] answer = new int[5];

        for(int i = 0; i < places.length; i++) {

            // 대기실로 만들 room
            String[][] room = new String[5][5];
            String[] select = places[i];

            int result = 1;

            for(int j = 0; j < select.length; j++) {
                String[] split = select[j].split("");
                for(int k = 0; k < split.length; k++ ) {
                    room[j][k] = split[k];
                }
            }


            for(int j = 0; j < room.length; j++) {
                for(int k = 0; k < room[j].length; k++) {
                    String state = room[j][k];
                    // 1. 사람일 때만 bfs실행
                    if(state.equals("P")) {
                        if(bfs(j, k, room) == 0) result = 0;
                    }
                }
            }

            answer[i] = result;





        }



        return answer;
    }

    public static int bfs(int r, int c, String[][] room) {
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;

        // [x, y, dist]
        Queue<int[]> queue = new ArrayDeque<>();
        // 기준에서 거리는 0
        queue.add(new int[]{r, c, 0});

        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cr = poll[0];
            int cc = poll[1];
            int dist = poll[2];

            // 0이나 1이어야 다음이 이동이 가능함 다음은 2니까.
            if(dist > 1) continue;

            for(int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                // 1. 이동이 가능한가?
                if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !visited[nr][nc]) {
                    // 2. 이동했을때.
                    // O이면서 방문을 하지 않았을떄
                    if(room[nr][nc].equals("O")) {
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, dist + 1});
                    }else if (room[nr][nc].equals("P")) {// P일 때는 0을 반환
                        return 0;
                    }else continue; //X일 땐 스킵

                }
            }
        }

        // 모두 순환이 끝났을 때 1을 반환
        return 1;

    }


}