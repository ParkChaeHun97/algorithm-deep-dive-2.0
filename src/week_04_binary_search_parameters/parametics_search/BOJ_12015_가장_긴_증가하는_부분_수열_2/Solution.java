package week_04_binary_search_parameters.parametics_search.BOJ_12015_가장_긴_증가하는_부분_수열_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 1. 입력 받기
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[n];

        int size = 0;
        for (int i = 0; i < n; i++ ) {
            int x = a[i];

            // lowerbound(tails, size, x) 호출해서 pos 구하기
            int pos = lowerBound(tails, size, x);

            tails[pos] = x; // 교체 or 신규 추가

            if (pos == size) {
                size++; // 맨 뒤에 새로 추가된 경우
            }

        }

        System.out.println(size);

    }

    static int lowerBound(int[] tails, int size, int x) {
        int lo = 0;
        int hi = size;

        while (lo < hi) {
           int mid = (lo + hi) / 2;

           if(x <= tails[mid]) {
               hi = mid;
           }else {
               lo = mid + 1;
           }
        }

        return lo;
    }
}
