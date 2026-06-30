package dp.BOJ_1463_1로_만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TopDown {
    static int[] memo = new int[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(dp(n));
    }

    static int dp(int n) {
        if (n == 1) return 0;
        if (memo[n] != 0) return memo[n];

        int current = dp(n-1) + 1;

        if(n % 3 == 0) {
            current = Math.min(current, dp(n/3) + 1);
        }

        if(n % 2 == 0) {
            current = Math.min(current, dp(n/2) + 1);
        }

        return memo[n] = current;
    }
}
