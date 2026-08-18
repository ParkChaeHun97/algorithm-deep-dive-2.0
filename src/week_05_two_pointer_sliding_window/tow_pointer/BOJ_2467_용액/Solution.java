package week_05_two_pointer_sliding_window.tow_pointer.BOJ_2467_용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. n 입력 받기
        int n = Integer.parseInt(br.readLine());
        int[] waters = new int[n]; // waters 초기화

        // 2. n들 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            waters[i] = Integer.parseInt(st.nextToken());
        }


        int bestLeft = 0;
        int bestRight = n-1;
        int bestResult = Integer.MAX_VALUE;

        int left = 0;
        int right = n-1;

        // left와 right를 양쪽 끝으로 하고 left < right 로 시도
        while(left < right) {
            int water_1 = waters[left];
            int water_2 = waters[right];

            int result = water_1 + water_2;

            if(Math.abs(result) < Math.abs(bestResult)) {
                bestResult = result;
                bestLeft = left;
                bestRight = right;
            }

            if(result < 0) left++;
            else if (result > 0) right--;
            else break;
        }

        System.out.println(waters[bestLeft] + " " + waters[bestRight]);





    }
}
