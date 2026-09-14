package week_10_brush_up_on_algorithm.BOJ_2579_계단_오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int n;
    static int[] dp_one, dp_two;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        if(input() == 1) {
            System.out.println(br.readLine());
            return;
        };
        System.out.println(dp());
    }

    public static int dp() throws IOException {
        for (int i = 3; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            dp_one[i] = dp_two[i-1] + num;
            dp_two[i] = Math.max(dp_one[i-2], dp_two[i-2]) + num;
        }

        return Math.max(dp_one[n], dp_two[n]);
    }

    public static int input() throws IOException {

        n = Integer.parseInt(br.readLine());

        if(n == 1) {
            return 1;
        }

        dp_one = new int[n+1];
        dp_two = new int[n+1];

        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());

        dp_one[1] = first;
        dp_two[1] = 0;
        dp_one[2] = dp_two[1] + second;
        dp_two[2] = second;

        return 0;
    }
}
