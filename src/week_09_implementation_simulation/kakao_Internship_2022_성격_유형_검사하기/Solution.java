package week_09_implementation_simulation.kakao_Internship_2022_성격_유형_검사하기;

public class Solution {
    static int[][] score = new int[4][2];
    static char[][] type = new char[][] {{'R', 'T'}, {'C', 'F'}, {'J','M'},{'A','N'}};
    static int RTy = 0;
    static int CFy = 1;
    static int JMy = 2;
    static int ANy = 3;

    static int RCJAx = 0;
    static int TFMNx = 1;

    static int[] choiceScore = new int[]{0, 3, 2, 1, 0, 1, 2, 3};

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"AN", "CF", "MJ", "RT", "NA"}, new int[]{5, 3, 2, 7, 5}));

        score = new int[4][2];
        System.out.println(solution(new String[]{"RT", "CF", "JM", "AN"}, new int[]{4, 4, 4, 4}));
    }


    public static String solution(String[] survey, int[] choices){
        scoreUpdate(survey, choices);
        String result = typeDeco(score);
        return result;
    }

    private static String typeDeco(int[][] score) {
        StringBuilder sb = new StringBuilder();

        // 같은 행 끼리 비교
        for (int i = 0; i < score.length; i++) {
            int type1 = score[i][0];
            int type2 = score[i][1];

            if(type1 > type2) sb.append(type[i][0]);
            else if (type2 > type1) sb.append(type[i][1]);
            else {
                if(type[i][0] > type[i][1]) sb.append(type[i][1]);
                else sb.append(type[i][0]);
            }

        }

        return sb.toString();

    }


    public static void scoreUpdate(String[] survey, int[] choices) {
        int surveyNumber = survey.length;

        for (int i = 0; i < surveyNumber; i++) {
            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);

            int y;
            int x;

            if (choices[i] >= 1 && 3 >= choices[i]) { // 첫번째 번호가 1~3 일 경우

                // 유형 좌표 찾기
                if (c1 == 'R' || c1 == 'T') y = RTy;
                else if (c1 == 'C' || c1 == 'F') y = CFy;
                else if (c1 == 'J' || c1 == 'M') y = JMy;
                else y = ANy;

                if (c1 == 'R' || c1 == 'C' || c1 == 'J' || c1 == 'A') x = RCJAx;
                else x = TFMNx;

                // 유형에 점수 더하기
                score[y][x] += choiceScore[choices[i]];

            } else if (choices[i] >= 5 && 7 >= choices[i]) {

                // 유형 좌표 찾기
                if (c2 == 'R' || c2 == 'T') y = RTy;
                else if (c2 == 'C' || c2 == 'F') y = CFy;
                else if (c2 == 'J' || c2 == 'M') y = JMy;
                else y = ANy;

                if (c2 == 'R' || c2 == 'C' || c2 == 'J' || c2 == 'A') x = RCJAx;
                else x = TFMNx;

                // 유형에 점수 더하기
                score[y][x] += choiceScore[choices[i]];

            } else continue;
        }
    }
}
