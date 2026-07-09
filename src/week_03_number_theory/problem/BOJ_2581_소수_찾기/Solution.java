package week_03_number_theory.problem.BOJ_2581_소수_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // 소수 판별
        boolean[] isPrime = new boolean[n + 1];

        // 에라토스테네스의 체
        Arrays.fill(isPrime,true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(isPrime[i]) {
                for (int j = i*i; j <= n; j+= i) {
                    isPrime[j] = false;
                }
            }

        }

        int result = 0;
        int min = Integer.MAX_VALUE;

        for (int i = m; i <= n; i++) {
            if(isPrime[i]) {
                result += i;
                min = Math.min(min, i);
            }
        }

        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(result);
            System.out.println(min);
        }

    }
}
