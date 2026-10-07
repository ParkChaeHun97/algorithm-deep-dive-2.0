package kakao_prablom.kakao_blind_2018.압축;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution("KAKAO")));
    }

    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();

        // 1.
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), i + 1);
        }
        int idx = 27;

        // 2. LZW 압축 과정 진행
        int i = 0;
        while (i < msg.length()) {
            String w = "";
            int j = i;

            // 사전에 포함된 가장 긴 문자열 w 찾기
            while (j < msg.length() && dictionary.containsKey(msg.substring(i, j + 1))) {
                w = msg.substring(i, j + 1);
                j++;
            }

            // 찾은 문자열의 색인 번호 출력
            list.add(dictionary.get(w));

            // 입력에서 처리되지 않은 다음 글자가 남아있다면 (w + c) 사전에 등록
            if (j < msg.length()) {
                String nextWord = msg.substring(i, j + 1);
                dictionary.put(nextWord, idx++);
            }

            // 처리한 글자 수만큼 인덱스 이동
            i += w.length();
        }

        // List<Integer>를 int[]로 변환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
