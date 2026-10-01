package kakao_prablom.kakao_blind_2018.다트_게임;

public class Solution {


    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("1S2D*3T");
    }

    public int solution(String dartResult) {

        int result = 0;

        // 점수들
        int[] scores = new int[3 + 1];

        // 이전 char가 점수인지 확인하는 용도
        boolean isNumber = false;

        //
        int shootScore = 0;
        int shootIdx = 1;

        for(char c : dartResult.toCharArray()) {

            // 숫자 인경우
            if(Character.isDigit(c)) {
                if(isNumber) { // 이전이 숫자이면? 숫자를 다시 갱신
                    shootScore = Integer.parseInt(Integer.toString(shootScore) + c);
                } else { // 아니면 그냥 점수 갱신
                    isNumber = true;
                    shootScore = c - '0';
                }
            } else if (Character.isLetter(c)) { // 영어인 경우 배열에 점수 저장
                if(c == 'S') scores[shootIdx] = shootScore;
                if(c == 'D') scores[shootIdx] = shootScore * shootScore;
                if(c == 'T') scores[shootIdx] = shootScore * shootScore * shootScore;
                isNumber = false;

                // 슛차례 넘기기
                shootIdx++;
            }else { // 보너스에서 슛차례를 넘김, * #이 뜰 경우 적용을 idx는 -1부터 시작
                int bonusIdx = shootIdx - 1;
                if(c == '*'){
                    scores[bonusIdx] *= 2;
                    scores[bonusIdx - 1] *= 2;
                }else {
                    scores[bonusIdx] *= (-1);
                }
            }
        }

        // 점수 합산
        for(int i = 1; i <= 3; i++) {
            result += scores[i];
        }

        return result;



    }
}
