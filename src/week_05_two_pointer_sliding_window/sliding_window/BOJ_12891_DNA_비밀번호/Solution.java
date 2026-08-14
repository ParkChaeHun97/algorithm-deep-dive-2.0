package week_05_two_pointer_sliding_window.sliding_window.BOJ_12891_DNA_비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int s, p; // dna 문자열 길이 s, 비밀번호 길이 p
    static char[] dnaArr; // dna 문자 저장
    static int[] check; // A C T G 의 갯수 저장
    static int[] count; // A C T G 의 카운트 세기용
    static boolean satisfied = false; // A C T G가 모두 높은가?
    static int result = 0; // 정답 초기는 0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // dna 문자열 길이
        s = Integer.parseInt(st.nextToken());
        // 비밀번호 길이
        p = Integer.parseInt(st.nextToken());
        // dnaArr 문자열 길이 초기화
        dnaArr = new char[s];

        // 비밀번호 check용, count용 초기화
        check = new int[4];
        count = new int[4];

        // 문자열 입력 받기
        String dna = br.readLine();
        // 문자열 초기화
        for (int i = 0; i < dna.length(); i++) {
            dnaArr[i] = dna.charAt(i);
        }

        // check 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 count를 갱신
        for (int i = 0; i < p; i++) {
            char dnaChar = dnaArr[i];
            switch (dnaChar) {
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }
        }

        // 비교 후 result 결정
        for (int i = 0; i < 4; i++) {
            if(check[i] <= count[i]) {
                satisfied = true;
            }else {
                satisfied = false;
                break;
            }
        }
        if(satisfied) result++;




        int left = 0;
        int right = p-1;

        while (right + 1 < dna.length()) {
            // 제일 왼쪽 문자를 뽑는다.
            char leftC = dnaArr[left];

            // 뺸 값 갱신
            switch (leftC) {
                case 'A':
                    count[0]--;
                    break;
                case 'C':
                    count[1]--;
                    break;
                case 'G':
                    count[2]--;
                    break;
                case 'T':
                    count[3]--;
                    break;
            }

            left++;
            right++;

            char rightC = dnaArr[right];

            // 더한 값 갱신
            switch (rightC) {
                case 'A':
                    count[0]++;
                    break;
                case 'C':
                    count[1]++;
                    break;
                case 'G':
                    count[2]++;
                    break;
                case 'T':
                    count[3]++;
                    break;
            }

            // 비교 후 result 결정
            for (int i = 0; i < 4; i++) {
                if(check[i] <= count[i]) {
                    satisfied = true;
                }else {
                    satisfied = false;
                    break;
                }
            }
            if(satisfied) result++;

        }

        System.out.println(result);


    }
}
