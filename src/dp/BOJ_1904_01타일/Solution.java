package dp.BOJ_1904_01타일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static long dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. dp 초기화
        dpInitialization();

        System.out.println(dp[n]);

    }

    static void dpInitialization() {
        dp = new long[1_000_000 + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 1_000_000; i++) {
            dp[i] = dp[i-1] + dp[i-2]  % 15746 ;
        }
    }
}
