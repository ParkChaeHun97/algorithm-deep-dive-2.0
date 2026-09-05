package week_08_Brute_force_backtracking.BOJ_9663_N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static int N;
    private static int count = 0;

    // 중복 체크를 위한 배열
    private static boolean[] colUsed;       // 열(Vertical) 체크
    private static boolean[] diag1Used;     // 우하향 대각선 (row - col) 체크
    private static boolean[] diag2Used;     // 우상향 대각선 (row + col) 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        colUsed = new boolean[N];
        diag1Used = new boolean[2 * N - 1];
        diag2Used = new boolean[2 * N - 1];

        backtracking(0);

        System.out.println(count);


    }

    private static boolean isVaild(int row, int col) {
        return !colUsed[col] && !diag1Used[row - col + (N - 1)] && !diag2Used[row + col];
    }

    private static void backtracking(int row) {
        // 모든 행에 퀸을 다 놓았다면 해를 하나 찾은 것임
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            // 현재 위치(row, col)에 퀸을 놓을 수 있는지 판단
            if (isVaild(row, col)) {

                // 1. 퀸 배치 (가지치기 마킹)
                colUsed[col] = true;
                diag1Used[row - col + (N - 1)] = true;
                diag2Used[row + col] = true;

                // 2. 다음 행으로 이동
                backtracking(row + 1);

                // 3. 백트래킹 (마킹 해제)
                colUsed[col] = false;
                diag1Used[row - col + (N - 1)] = false;
                diag2Used[row + col] = false;
            }
        }
    }
}
