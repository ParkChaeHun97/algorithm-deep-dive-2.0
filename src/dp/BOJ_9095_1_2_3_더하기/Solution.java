package dp.BOJ_9095_1_2_3_더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[12];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(dp[number]).append("\n");
        }
        System.out.print(sb);

    }
}
