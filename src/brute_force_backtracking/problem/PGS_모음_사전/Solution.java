package brute_force_backtracking.problem.PGS_모음_사전;

import java.util.*;

class Solution {
    List<String> list = new ArrayList<>();
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        dfs("", 0);
        return list.indexOf(word) + 1;
    }

    private void dfs(String str, int depth) {
        if (depth > 5) {
            return;
        }

        if (!str.equals("")) {
            list.add(str);
        }

        for (int i = 0; i < 5; i++) {
            dfs(str + vowels[i], depth + 1);
        }
    }
}
