package dp.BOJ_1463_1로_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BottomUp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;


        for (int i = 4; i <= n ; i++) {
            int current = i;

            if(i % 3 == 0) {
                current = Math.min(current, 1 + dp[i / 3]);
            }

            if(i % 2 == 0) {
                current = Math.min(current, 1 + dp[i / 2]);
            }

            current = Math.min(current, 1 + dp[i-1]);

            dp[i] = current;
        }

        System.out.println(dp[n]);
    }
}
