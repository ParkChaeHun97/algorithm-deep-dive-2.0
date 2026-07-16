package kakao_prablom.kakao_blind_2018.모의고사;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int[] solution(int[] answers) {
        int one = 0;
        int two = 0;
        int three = 0;

        int[] onePattern = {1,2,3,4,5};
        int[] twoPattern = {2,1,2,3,2,4,2,5};
        int[] threePattern = {3,3,1,1,2,2};

        for (int i = 0; i < answers.length; i++) {
            int oneIdx = i % onePattern.length;
            int twoIdx = i %twoPattern.length;
            int threeIdx = i % threePattern.length;

            if(onePattern[oneIdx] == answers[i]) one++;
            if(twoPattern[twoIdx] == answers[i]) two++;
            if(threePattern[threeIdx] == answers[i]) three++;
        }

        int max = Math.max(one, two);
        max = Math.max(max, three);

        List<Integer> list = new ArrayList<>();

        if(max == one) list.add(1);
        if(max == two) list.add(2);
        if(max == three) list.add(3);

        return list.stream().mapToInt(Integer::intValue).toArray();

    }
}
