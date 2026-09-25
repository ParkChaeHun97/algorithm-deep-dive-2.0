package kakao_prablom.kakao_winter_internship_2020.보석_쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] solution(String[] gems) {
        Map<String, Integer> count = new HashMap<>();
        int totalTypes = (int) Arrays.stream(gems).distinct().count();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int answerLeft = 0, answerRight = 0;

        for (int right = 0; right < gems.length; right++) {
            count.put(gems[right], count.getOrDefault(gems[right], 0) + 1);

            // 조건(모든 종류 포함)을 만족하는 동안 계속 왼쪽을 당김
            while (count.size() == totalTypes) {
                int currentLength = right - left + 1;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    answerLeft = left;
                    answerRight = right;
                }

                // 왼쪽 보석을 구간에서 뺌
                String leftGem = gems[left];
                count.put(leftGem, count.get(leftGem) - 1);
                if (count.get(leftGem) == 0) {
                    count.remove(leftGem);  // 완전히 빠지면 map에서 제거 (0개 상태를 명확히 표현)
                }
                left++;
            }
        }

        return new int[] {answerLeft + 1, answerRight + 1};
    }

}