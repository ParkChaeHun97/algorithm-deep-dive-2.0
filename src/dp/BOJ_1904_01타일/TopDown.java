package dp.BOJ_1904_01타일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TopDown {
    static long memo[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        memo = new long[n+1];
        Arrays.fill(memo,-1);

        System.out.println(dp(n));

    }

    static long dp(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(memo[n] != -1) return memo[n];

        long result = dp(n - 1) + dp(n - 2) % 15746;

        return memo[n] = result;

    }

}
