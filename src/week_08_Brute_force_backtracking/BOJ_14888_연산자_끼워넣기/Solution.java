package week_08_Brute_force_backtracking.BOJ_14888_연산자_끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] numbers;
    static int[] operators;

    static long maxResult = Integer.MIN_VALUE;
    static long minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        backtracking(0, numbers[0]);
        printInfo();
    }

    private static void printInfo() {
        System.out.println(maxResult + "\n" + minResult);
    }

    private static void backtracking(int depth, long result) {


        if(depth == N-1) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operators[i] != 0) {

                switch (i) {
                    case 0:
                        operators[i]--;
                        backtracking(depth + 1, result + numbers[depth + 1]);
                        break;
                    case 1:
                        operators[i]--;
                        backtracking(depth + 1, result - numbers[depth + 1]);
                        break;
                    case 2:
                        operators[i]--;
                        backtracking(depth + 1, result * numbers[depth + 1]);
                        break;
                    case 3:
                        operators[i]--;
                        backtracking(depth + 1, result / numbers[depth + 1]);
                        break;
                }

                operators[i]++;

            }
        }

    }


    /**
     * 첫줄 N
     * 둘째 줄 N만큼의 숫자가 공백으로 주어짐
     * 더하기, 빼기, 곱하기, 나누기 순서로 몇 개씩 있는지 주어짐
     * */
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[4];

        // 숫자 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

    }
}
