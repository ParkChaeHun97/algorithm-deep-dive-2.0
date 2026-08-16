package week_05_two_pointer_sliding_window.tow_pointer.BOJ_1644_소수의_연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int n;
    static List<Integer> primeList = new ArrayList<>(); // n이하의 prime을 걸러내기 위한 list
    static int[] primes; // 리스트는 오버헤드가 크기 때문에 배열로 이관하기.
    static int sum = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        boolean[] isComposite = new boolean[n+1];

        // 미리 합성 수 처리
        if(n >= 0) isComposite[0] = true;
        if(n >= 1) isComposite[1] = true;

        for (int i = 2; (long) i * i <= n; i++) {
            if(isComposite[i]) continue; // 이미 합성수는 스킵
            for (int j = i * i; j <= n; j += i) { // 2 4 6 8, 3 6 9 12
                isComposite[j] = true;
            }
        }

        for (int i = 2; i <= n; i++) {
            if(!isComposite[i]) {
                primeList.add(i);
            }
        }

        primes = new int[primeList.size()];
        for (int i = 0; i < primeList.size(); i++) {
            primes[i] = primeList.get(i);
        }

        int left = 0;
        int right = 0;

        while(left < primes.length) {

           if(sum < n && right < primes.length) { // 1. sum이 n보다 작음
                // sum에 더한 후 이동
                sum += primes[right];
                right++;

            }else if (sum >= n) {  // 2. sum이 n보다 작거나 같음
                if( sum == n) {
                    result++;
                }
                sum -= primes[left];
                left++;
            }else break;
        }

        System.out.println(result);


    }
}
