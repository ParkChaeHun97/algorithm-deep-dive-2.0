package implementation.problem.PGS_자연수_뒤집어_배열로_만들기;

import java.util.*;
class Solution {
    public int[] solution(long n) {
        int[] answer = new StringBuilder(Long.toString(n))
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();

        return answer;
    }
}
