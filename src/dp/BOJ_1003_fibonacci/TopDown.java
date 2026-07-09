package dp.BOJ_1003_fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TopDown {
    static int memo[][] = new int[2][41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dpZero(40);
        dpOne(40);

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // t만큼 바로 꺼내쓰기
        for (int i = 0; i < T; i++) {
            int number = Integer.parseInt(br.readLine());
            sb.append(memo[0][number]).append(" ").append(memo[1][number]).append("\n");
        }

        System.out.println(sb);
    }


    static int dpZero(int n) {
        if(n == 0) return memo[0][n] = 1;
        if(n == 1) return memo[0][n] = 0;

        if (memo[0][n] != 0) return memo[0][n];

        int result = dpZero(n-1) + dpZero(n-2);

        return memo[0][n] = result;
    }

    static int dpOne(int n) {
        if(n == 0) return memo[1][n] = 0;
        if(n == 1) return memo[1][n] = 1;

        if (memo[1][n] != 0) return memo[1][n];

        int result = dpOne(n-1) + dpOne(n-2);

        return memo[1][n] = result;
    }
}
