package week_05_two_pointer_sliding_window.tow_pointer.BOJ_2003_수들의_합_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. n과 m 입력 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        // 2. n만큼 입력 받기
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int count = 0;


        int left = 0;
        int right = 0;

        // right가 idx 범위를 넘어가면 종료

        // right가 끝에 도달했어도 sum이 아직 M 이상이면 계속 left를 줄여야 한다.
        // while 조건 자체를 바꾸거나? right가 arr 범위를 벗어나지 않도록 조건 조정...

        while (left < n) {
            // 오른쪽 포인터 이동 조건
            if (right < n && sum < m) { // right가 n을 안넘고, sum이 m을 안넘음, 이러면 right가 끝에 도달해도? left를 움직일 수 있음.
                sum += arr[right];
                right++;

            // 왼쪽 포인터 이동 조건
            } else if (sum >= m) { // sum이 m 크거나 같은데
                // 값을 찾음
                if (sum == m) { // sum이 m이랑 같음
                    count++;
                }
                sum -= arr[left];
                left++;
            } else {
                break;
            }
        }

        System.out.println(count);


    }
}
