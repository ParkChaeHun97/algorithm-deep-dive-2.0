package brute_force_backtracking.problem.KAKAO_BLIND2022_양궁_대회;

// 라이언은 저번 우승자
// 이번에 결승전 까지 옴
// 상대는 어피치

// 결승전 규칙을 라이언에게 불리하게 정함

// 1 . 어피치가 n발을 다 쓴 후 라이언이 n발을 쏨

// 2. 점수 계산
// -  과녁판은 가운데 10점, 가장 바깥쪽 0점
// 만약 어피치가 k( 1 ~ 10의 자연수)점을 어피치가 맞혔고 라이언이 b발을 맞혔을 경우?
// 더 많은 화살을 k점에 맞힌 선수가 k점을 가져감
// -> 어피치 3발, 라이언 5발 -> 라이언만 k 점수 흭득, (a = b인 경우) 어피치가 가져감
// 어피치가 유리한게 예외 케이스

// 어피치가 10점 2발 맞춤, 라이언도 10점 2발 맞춤 -> 어피치가 10점 가져감
// 어피치가 10점 0발, 라이언 10점 2발 -> 라이언이 10점 가져감

// 최종 점수가 더 높은 선수를 우승자로 결정

// 현재 상황은 어피치가 화살 n발을 다 쏜 후 라이언이 화살을 쏠 차례
// 라이언은 어피치를 가장 큰 점수 차이로 이기기 위해
// n발의 화살을 어떤 과녁 점수에 맞히는지 구하려고 함

// 화살의 개수 n
// 어피치가 10점 부터 0점까지 순서대로 담은 정수 배열 info
// 라이언이 가장 큰 점수 차이로 우승하기 위해 n발의 화살을 어떤 과녁 점수에 맞혀야 하는지


// ->


// depth == 11일 경우 (10점 부터 0점 까지 모두 과녁이 정해진 경우에 결정한다.)

// 두개의 갈래로 시도한다.

// 라이언 배열 lionInfo[11];

// 시도 할때 : 화살의 갯수를 알아야함
// 화살이 그만큼 남아 있는가? arrowCount
// 화살이 어피치가 과녁맞춘만큼 없으면 시도하지않고 다음걸로 넘긴다.

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] info) {

        // 2. 라이언 배열
        int[] lion = new int[11];
        int[] maxScore = {-1};
        int[] result = new int[11];

        dfs(0, info, lion, n, maxScore, result);

        return maxScore[0] == -1 ? new int[]{-1} : result;
    }

    public static void dfs(int depth, int[] info, int[] lion, int arrowCount, int[] maxScore, int[] result) {


        if(depth == 11) {
            // 화살이 혹시 남아 있으면 끝에 다쏴버리기
            if(arrowCount > 0) {
                lion[10] += arrowCount;
            }


            // 점수 차이 구하기
            int a = 0; // 어피치
            int l = 0; //

            for(int i = 0; i < 11; i++) {
                if (info[i] == 0 && lion[i] == 0) continue; // 둘다 쏘지 못한경우는 점수 없음

                if(info[i] >= lion[i] ) { // 어피치가 많이 쏘거나 같은 경우
                    a += (10 - i); // 10 - i;
                } else { // 라이언이 많이 쏜 경우
                    l += (10 - i);
                }
            }
            // 가장 높은 점수 차이를 계산, 주소자체를 max로 넘기기 위해 배열로 넘긴 maxResult 활용
            // 가장 큰 점수 차이로 이기는 경우 중 가장 낮은 점수를 가장 많이 맞힌 경우를 반환 해야함

            if((l-a) > 0) {
                if((l-a) > maxScore[0]) {
                    maxScore[0] = l-a; // 갱신
                    System.arraycopy(lion, 0, result, 0, 11);
                } else if ((l-a) == maxScore[0]) { // 점수 차이가 같은 경우, 더 낮은 점수를 많이 맞힌 조합 선택
                    for (int i = 10; i >= 0; i--) {
                        if (lion[i] > result[i]) {
                            System.arraycopy(lion, 0, result, 0, 11);
                            break;
                        } else if (lion[i] < result[i]) {
                            break;
                        }
                    }
                }
            }

            if(arrowCount > 0) { // 백트래킹 들어가기전에 남은 화살 복구
                lion[10] -= arrowCount;
            }


            return;

        }


        // 시도는 어피치 보다 많이 쏠것인가? 아니면 포기하고 다음 과녁을 쏠것인가.
        // 화살의 남은 갯수는 arrowCount
        // 어피치 보다 많이 쏘기
        // 어피치 + 1이 arrowCount보다 크거나 같으면 시도한다.
        boolean isLionShots = false;


        if(info[depth] + 1 <= arrowCount) {
            lion[depth] = info[depth] + 1;
            arrowCount -= (info[depth] + 1);
            isLionShots = true;
        }

        // 이경우에는 화살이 충분해도, 부족한 경우는
        dfs(depth + 1, info, lion, arrowCount, maxScore, result);

        // 라이언 이 쏜경우는 백트래킹해서 새로 시도
        if(isLionShots) {
            lion[depth] -= (info[depth] + 1);
            arrowCount += (info[depth] + 1);
        }

        // 쏘지 않고 넘기기
        dfs(depth + 1, info, lion, arrowCount, maxScore, result);


    }
}
