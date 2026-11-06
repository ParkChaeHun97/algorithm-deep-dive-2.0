package implementation.problem.PGS_정수_내림차순으로_배치하기;

import java.util.*;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        String[] arr = Long.toString(n).split("");
        Arrays.sort(arr, Collections.reverseOrder());

        return Long.parseLong(String.join("", arr));
    }
}