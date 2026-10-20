package programmers.가장_큰수;

// 0 또는 양의 정수가 이어 붙여 만들 수 있는 가장 큰 수 만들기
// 3 30 34 5 9 -> 9 5 34 330

import java.util.*;
class Solution {
    public String solution(int[] numbers) {

        String[] str = new String[numbers.length];

        for(int i=0; i<str.length; i++) {
            str[i] = Integer.toString(numbers[i]);
        }

        // 330이 큰가 303이 큰가
        Arrays.sort(str, (a, b) -> {
            String aAddB = a + b; // 330
            String bAddA = b + a; // 303
            return Integer.parseInt(bAddA) - Integer.parseInt(aAddB); // 내림차순은 음수 303 - 330

        });

        if(str[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }

        return sb.toString();
    }
}
