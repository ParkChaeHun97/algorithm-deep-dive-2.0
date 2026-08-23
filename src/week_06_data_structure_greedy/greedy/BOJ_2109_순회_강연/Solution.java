package week_06_data_structure_greedy.greedy.BOJ_2109_순회_강연;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        // 1. n 입력 받기
        int n = Integer.parseInt(br.readLine());

        int[][] lectures = new int[n][2];
        int maxDay = Integer.MIN_VALUE; // 최종 강연 일자가 필요함

        // 2. n만큼 p, d 입력 받기

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            lectures[i][0] = Integer.parseInt(st.nextToken());

            // day는 따로 필요
            int dDay = Integer.parseInt(st.nextToken());
            lectures[i][1] = dDay;
            maxDay = Math.max(maxDay, dDay);
        }

        Arrays.sort(lectures, (a, b) -> { // p, d
            if(a[0] != b[0]) return b[0] - a[0]; // p 내림차순
            return a[1]- b[1]; // d 내림 차순
        });

        boolean[] used = new boolean[maxDay + 1]; // 1~maxDay까지 사용

        for (int i = 0; i < n; i++) {
            int p = lectures[i][0];
            int d = lectures[i][1];

            // d일부터 거꾸로 내려가며 빈 날 찾기
            for (int day = d; day >= 1; day--) {
                if (!used[day]) {
                    used[day] = true;
                    result += p;
                    break; // 배치 완료, 다음 강연으로
                }
            }
        }

        System.out.println(result);

    }
}
