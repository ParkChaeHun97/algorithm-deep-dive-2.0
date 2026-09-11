package week_09_implementation_simulation.kakao_blind_2023_이모티콘_할인행사;

/**
 * 이모티콘 플러스 서비스 가입자 수를 늘리려고 이모티콘 할인 해사 진행 중
 * 1. 이모티콘 플러스 가입자를 최대한 늘리기
 * 2. 이모티콘 판매액을 최대한 늘리기
 *  - *** 1번 목표가 우선, 2번 목표가 그 다음
 *
 * 할인 행사 진행 방식
 * - n명의 카카오톡 사용자들에게 이모티콘 m개를 할인하여 판매
 * - 이모티콘마다 할인율은 다름, 할인율은 10%, 20%, 30%, 40% 중 하나
 *
 * 카톡 사용자들은 다음 기준을 따라 이모티콘을 사거나 이모티콘 플러스에 가입함
 * - 각 사용자들은 자신의 기준에 따라 일정 비율 이상 할인하는 이모티콘 모두 구매
 * - 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면, 이모티콘 구매를 모두 취소하고 이모티콘 플러스에 가입 됨
 *
 *  {할인비율, 가격}, {할인비율, 가격} 으로 주어짐
 *  사용자 - {40, 10000}, {25, 100000}
 *   -
 *  이모티콘 가격 - {7000, 9000}
 *
 * */

public class Solution {

    static int[] discount = new int[] {10, 20, 30, 40}; // backtracking 순회용
    static int[] emoticonsDiscount; // 이모티콘 2개면 depth 2..

    static int bestRevenue = -1;
    static int bestServe = -1;

    public static void main(String[] args) {

        int[][] users1 = {{40, 10000}, {25, 10000}};
        int[] emoticons1 = {7000, 9000};
        System.out.println(java.util.Arrays.toString(solution(users1, emoticons1)));
        // 기대: [1, 5400]

        int[][] users2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = {1300, 1500, 1600, 4900};
        System.out.println(java.util.Arrays.toString(solution(users2, emoticons2)));
        // 기대: [4, 13860]
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        emoticonsDiscount = new int[emoticons.length];
        backtrack(0, emoticonsDiscount.length, users, emoticons);

        return new int[] {bestServe, bestRevenue};
    }

    public static void backtrack(int depth, int m, int[][] users, int[] emoticons) {
        if(depth == m) {
            simulation(emoticons, users);
            return;
        }

        for (int i = 0; i < 4; i++) {
            emoticonsDiscount[depth] = discount[i];
            backtrack(depth+1, m, users,emoticons);
        }
    }

    public static void simulation(int[] emoticons, int[][] users) {
        // 이모티콘 가격 채우기
        int[] emoticonPrice = new int[emoticonsDiscount.length];
        for (int i = 0; i < emoticons.length; i++) {
            // 할인율 = 1- 10/100)
            emoticonPrice[i] = (int) (emoticons[i] * (1 - emoticonsDiscount[i] / 100.0));
        }

        int totalRevenue = 0; // 전체 유저에 대한 수익
        int serve = 0;

        // 각 유저가 구매를 할것인가?
        for (int[] user : users) {
            int discount = user[0];
            int money = user[1];

            int userRevenue = 0; // 한 유저에 대한 수익

            for (int i = 0; i < emoticonsDiscount.length; i++) {
                // 1. 할인율이 적절한가?
                if(discount <= emoticonsDiscount[i]) {
                    userRevenue += emoticonPrice[i];
                }else continue; // 아니면 안삼
            }

            // 구매 가격이 구독가격을 넘었나?
            if(money <= userRevenue) {
                // 넘었으면 구독
                serve++;
            }else { // 안넘었으면 토탈에 더함
                totalRevenue += userRevenue;
            }
        }

        if (serve > bestServe) {
            // 가입자 수가 더 많으면 무조건 갱신 (매출 비교 필요 없음)
            bestServe = serve;
            bestRevenue = totalRevenue;
        } else if (serve == bestServe && totalRevenue > bestRevenue) {
            // 가입자 수가 같을 때만 매출 비교
            bestRevenue = totalRevenue;
        }





    }


}
