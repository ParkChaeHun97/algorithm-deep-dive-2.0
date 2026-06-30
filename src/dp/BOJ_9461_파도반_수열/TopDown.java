package dp.BOJ_9461_파도반_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TopDown {
    static int memo[] = new int[100 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Arrays.fill(memo, -1);

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp(n)).append("\n");
        }

        System.out.print(sb);

    }

    static int dp(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        if(n == 3) return 1;

        if(memo[n] != -1) return memo[n];

        return memo[n] = dp(n-1) + dp(n-5);

    }
}
