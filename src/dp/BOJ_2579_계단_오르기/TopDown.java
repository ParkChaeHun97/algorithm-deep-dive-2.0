package dp.BOJ_2579_계단_오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopDown {
    static int memo[];
    static int score[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        score = new int[n + 1];
        memo = new int[n + 1];

        // 1. 계단마다 점수 입력 받기
        for (int i = 1; i <= n; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        ;
        System.out.println(dp(n));

    }

    static int dp(int n) {
        if(n == 0) return 0;
        if(n == 1) return memo[1] = score[1];;
        if(n == 2) return memo[2] = dp(1) + score[2];

        if(memo[n] != 0) return memo[n];

        int result = Math.max(dp(n-2), dp(n-3) + score[n-1]) + score[n];

        return memo[n] = result;
    }
}
