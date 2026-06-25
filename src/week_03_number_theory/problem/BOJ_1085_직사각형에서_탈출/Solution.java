package week_03_number_theory.problem.BOJ_1085_직사각형에서_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 직사각형 탈출
 * 현재 위치 x,y
 * 왼쪽 아래 꼭짓점 0,0
 * 오른쪽 위 꼭짓점 w,h
 *
 * 1. 왼쪽 경계길이 = x
 * 2. 아래쪽 경계 길이 = y
 * 3. 오른쪽 역계 길이 w - x
 * 4. 위쪽 경계 길이 h - y
 *
 * */

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int result = x;

        result = Math.min(result, y);
        result = Math.min(result, w - x);
        result = Math.min(result, h - y);

        System.out.println(result);


    }
}
