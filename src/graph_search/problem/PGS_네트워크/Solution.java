package graph_search.problem.PGS_네트워크;

// A - B 연결되어있고, B C와 연결되어있으면 A - C 도 정보 교환 가능
// A - B - C 가 연결되어있을 때 네트워크는 1개

// n은 컴퓨터 갯수
// computers는 연결되어 있는 좌표
// [1,1,0] = 2번 idx랑 연결되어있음
// i는 현재 컴퓨터, j는 연결되어 있는 컴퓨터
// 방문 배열을 만들고 하나씩 순회해서 이미 방문 했으면 스킵, 방문하지 않았으면 방문
// 새 네트워크가 나올때마다 카운트 늘리기

// **실수 없이 15분 걸림**

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[][] visited = new boolean[n][n]; // 방문 했는가

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(computers[i][j] == 1 && !visited[i][j]) { // 연결되어있고, 방문하지 않았으면
                    count++;
                    dfs(i,j, visited, n, computers);
                }
            }
        }

        return count;
    }

    public static void dfs(int a, int b, boolean[][] visited, int n, int[][] computers) {
        // a - b가 연결 되어있다.
        visited[a][b] = true;
        // b부터 연결되어 있는걸 찾기
        for(int i=0; i<n; i++) {
            if(computers[b][i] == 1 && !visited[b][i]) {
                dfs(b, i, visited, n, computers);
            }
        }

    }
}
