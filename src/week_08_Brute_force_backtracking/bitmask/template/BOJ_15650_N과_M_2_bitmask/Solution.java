package week_08_Brute_force_backtracking.bitmask.template.BOJ_15650_N과_M_2_bitmask;

import java.util.*;
import java.io.*;


/**
 * N과 M이 주어졌을 때, 1부터 N까지의 자연수 중 M개를 고른 수열 중 오름차순으로 정렬된 것만 사전순으로 출력
 * */
public class Solution {

    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static int state = 0;
    static boolean used;


    public static void main(String[] args) throws IOException{
        input();
        backtracking(0, 1);
        System.out.println(sb);
    }

    private static void backtracking(int depth, int start) {
        if(depth == M) {
            for (int i = 1; i <= N; i++) {
                // 1부터 체크해서 N까지 비트가 켜져있는것?
                if( (state & (1 << i)) != 0 ) {
                    sb.append(i).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            if( (state & (1 << i)) == 0 ) {
                state = state | (1 << i);
                backtracking(depth + 1, i + 1);
                state = state & ~(1 << i);
            }
        }

    }


    private static void input() throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

    }
}
