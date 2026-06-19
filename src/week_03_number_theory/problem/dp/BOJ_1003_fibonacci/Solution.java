package week_03_number_theory.problem.dp.BOJ_1003_fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // 정수는 최대 40, 0부터 40까지는 총 41개의 공간 필요
        dp = new int[2][41];

        // fib 0일때 0은 1번 1은 0번
        dp[0][0] = 1;
        dp[1][0] = 0;

        // fi 1일때 0은 0번 1은 1번
        dp[0][1] = 0;
        dp[1][1] = 1;

        // dp[0][i] = dp[0][i-1] + dp[0][i-2]
        for (int i = 2; i <= 40; i++) {
            dp[0][i] = dp[0][i-1] + dp[0][i-2];
            dp[1][i] = dp[1][i-1] + dp[1][i-2];
        }

        // t만큼 바로 꺼내쓰기
        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(dp[0][number]).append(" ").append(dp[1][number]).append("\n");
        }

        System.out.println(sb);
    }
}
