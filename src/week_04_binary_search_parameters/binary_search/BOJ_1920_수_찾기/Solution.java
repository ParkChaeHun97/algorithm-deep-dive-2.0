package week_04_binary_search_parameters.binary_search.BOJ_1920_수_찾기;

import week_04_binary_search_parameters.binary_search.template.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 1. 배열 초기화 및 정렬
        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            numbers[i] = number;
        }
        Arrays.sort(numbers);

        // 2. m 입력 받기
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean search = BinarySearch(target, 0, n-1);
            if(search) {
                sb.append(1).append("\n");
            }else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);

    }

    static boolean BinarySearch(int target, int left, int right) {
        if(left > right) return false;

        int mid = (left + right) / 2;

        if(numbers[mid] == target) return true;

        if(numbers[mid] < target) { // 1. 타겟이 더 큰 경우
          return BinarySearch(target, mid + 1, right);
        } else { // 2. 타겟이 더 작은 경우
          return BinarySearch(target, left, mid -1);
        }
    }
}
