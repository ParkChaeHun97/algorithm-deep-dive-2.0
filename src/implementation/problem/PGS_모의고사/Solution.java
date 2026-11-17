package implementation.problem.PGS_모의고사;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1, 2, 3, 4, 5};
        int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (supo1[i % supo1.length] == answers[i]) score[0]++;
            if (supo2[i % supo2.length] == answers[i]) score[1]++;
            if (supo3[i % supo3.length] == answers[i]) score[2]++;
        }


        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                answer.add(i + 1);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}