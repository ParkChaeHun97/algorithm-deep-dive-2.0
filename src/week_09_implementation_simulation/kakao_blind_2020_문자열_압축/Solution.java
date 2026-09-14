package week_09_implementation_simulation.kakao_blind_2020_문자열_압축;

import java.util.ArrayList;
import java.util.List;

/**
 * "ababcdcdababcdcd" 가 주어졌을 때
 * 2개 단위 -> 2ab2cd2ab2cd로 자를 수 있음
 * 근데 8개 단위 2abcdabcd로 자를 수 있음
 *
 * 완전 탐색
 * abcabcdede
 * a b c a b c d e d e -> 1
 * ab ca bc de de -> 2
 * abc abc ded e -> 3
 * abca abcd ded -> 4
 * .....
 *
 * 문자열 length만 큼 시도 해야함 aaaaaaaab가 나올수도?
 *
 * 구현은?
 * 1이 주어졌을 때 -> length로 반환
 * 2이 주어졌을 때 -> ab ca bc de de -> de de가 같음 2de로 변경해서 붙이기 -> length 반환 -> bestLength를 정해야함
 *  - 0 2
 *  - 2 4
 *  - 4 6
 *
 *
 * abc abc ded e -> abc abc랑 같네? -> abc 합침.
 *
 *
 * */

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("abababababababababab"));
    }

    public int solution(String s) {

        int bestLength = s.length();

        if(bestLength == 1) return 1;

        //i는 1글자씩, 2글자씩 자르는 단위
        for (int i = 1; i < s.length(); i++) {
            List<String> cutString = new ArrayList<>();

            int num = 0;
            // 1, 2, 3글자씩 자름
            while(num < s.length()) {
                if( num+i <= s.length()) {
                    cutString.add(s.substring(num, num + i));
                    num += i;
                }else {
                    cutString.add(s.substring(num, s.length()));
                    num += i;
                }
            }

    //            String currentString = cutString.get(0);
    //            int currentLength = currentString.length();
    //
    //            int sameCount = 1;
    //
    //            for (int j = 1; j < cutString.size(); j++) {
    //                if(currentString.equals(cutString.get(j))) { // ab ab일 경우
    //                    if(sameCount >= 2) { // 이전과 중복으로 같을 때
    //                        currentLength -= (cutString.get(j).length() + String.valueOf(sameCount).length()); // 9ab
    //                        sameCount++; // 10ab;
    //                        currentLength += (cutString.get(j).length() + String.valueOf(sameCount).length()); // 10ab
    //                        continue;
    //
    //                    }else { // 이전과 같을 때
    //                        currentLength += 1; // 2ab로 만듬
    //                        sameCount++; // 이전과 같다고 명시
    //                    }
    //                } else {
    //                    currentLength += cutString.get(j).length();
    //                    sameCount = 1;
    //                }
    //                currentString = cutString.get(j);
    //            }

            // 가독성 개선
            String currentString = cutString.get(0);
            int count = 1;
            int currentLength = 0;

            for (int j = 1; j <= cutString.size(); j++) {
                if (j < cutString.size() && currentString.equals(cutString.get(j))) {
                    count++;
                } else {
                    // 그룹이 끝남 -> 이 시점에 한 번만 길이 계산
                    currentLength += currentString.length() + (count > 1 ? String.valueOf(count).length() : 0);
                    if (j < cutString.size()) {
                        currentString = cutString.get(j);
                        count = 1;
                    }
                }
            }

            bestLength = Math.min(bestLength, currentLength);

        }

        return bestLength;
    }
}
