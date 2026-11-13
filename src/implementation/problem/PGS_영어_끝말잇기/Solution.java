package implementation.problem.PGS_영어_끝말잇기;

// Set<String> words[i] 가 들어감
// n 이 3이라면? 사람의 순서는 i % n
// int[] count -> n번째 사람이 몇번 말했는가를 세는 배열

// 1. count[i % n]++; -> 차례를 카운트를 늘리기.

// 2. 이전 끝 문자와 현재 첫 문자가 맞지 않으면

// return  [(i % n) + 1, count[i % n] ]

// 3. 이미 나온 단어 비교

// 단어가 있지 않으면?
// set에 삽입

// 단어가 이미 있으면
// return  [(i % n) + 1, count[i % n] ] 을 반환

// 모두 통과면 [0,0]을 반환



import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        Set<String> set = new HashSet<>();
        int[] count = new int[n];

        for(int i = 0; i < words.length; i++) {

            count[i % n]++;

            if (i != 0) {
                char prevLast = words[i - 1].charAt(words[i - 1].length() - 1);
                char currentFirst = words[i].charAt(0);
                if (prevLast != currentFirst) return new int[]{ (i % n) + 1, count[i % n]};
            }

            if (set.contains(words[i])) {
                return new int[]{ (i % n) + 1, count[i % n]};
            } else {
                set.add(words[i]);
            }
        }

        return new int[]{0, 0};
    }
}
