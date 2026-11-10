package implementation.problem.PGS_자릿수_더하기;

import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = Arrays.stream(Integer.toString(n).split(""))
                .mapToInt(Integer::parseInt)
                .sum();

        return answer;
    }
}