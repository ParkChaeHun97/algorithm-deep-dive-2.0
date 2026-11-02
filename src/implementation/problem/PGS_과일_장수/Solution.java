package implementation.problem.PGS_과일_장수;

// k는 최고 점수
// m은 한상자에 담기는 최대 사과 갯수
// 가격은 p * m

// 내림차순 정렬 ( 오름차순 정렬을 최저를 포함 시킴)

// 사과를 m 만큼 담고
// 최저 점수를 구해서
//  * m을 구한다.


import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        // 내림차 순 정렬은 Integer아니면 비용이 n만큼 더 들기 때문에 거꾸로 순회한다.
        int box = 0; // 사과를 담은 박스(m만큼 담기면 출고한다.)
        int minScore = 10; //


        for (int i = score.length - 1; i >= 0; i--) {
            box++; // 사과 담기
            minScore = Math.min(minScore, score[i]); // 최저 점수 갱신

            if(box == m) {// 사과를 m만큼 담았는가?
                box = 0; // 박스 출고
                answer += (minScore * m);
            }
        }



        return answer;
    }
}
