package dp.problem.BOJ_2156_포도주_시식;

/**
 * 포도주가 일렬로 놓여있는데, 연속으로 놓여 있는 3잔을 모두 마실 수 없다.
 * 6잔
 * 0 6 10 13 9 8 1
 *   o o     o o
 *     o  o    o o
 * 0 1 2  3  4 5 6
 * 0 1 2  3  4 5 6
 * */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(dp());
    }

    public static int dp() {
        dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = array[1];
        if (n >= 2) {
            dp[2] = array[1] + array[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                    dp[i - 1],
                    Math.max(
                            dp[i - 2] + array[i],
                            dp[i - 3] + array[i - 1] + array[i]
                    )
            );
        }

        return dp[n];

    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n + 1];
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
    }

}
