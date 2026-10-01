package kakao_prablom.kakao_winter_internship_2019.크레인_인형뽑기_게임;

import java.util.*;
class Solution {

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        Solution s = new Solution();
        s.solution(board, moves);
    }

    public int solution(int[][] board, int[] moves) {
        List<Deque<Integer>> dolls = new ArrayList<>();

        int boomDolls = 0;

        for(int i = 0; i <= board.length; i++ ) {
            dolls.add(new ArrayDeque<>());
        }

        // 회전한 큐에 넣기
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] != 0) {
                    dolls.get(j+1).offerFirst(board[i][j]);
                }
            }
        }

        // 인형 비교 Stack
        Stack<Integer> getDolls = new Stack<>();

        // 인형 뽑기
        for(int i = 0; i < moves.length; i++) {

            int moveNumber = moves[i];

            // 인형을 뽑았을때 인형이 없을 수도 있음, 인형이 있을 때만
            if(!dolls.get(moveNumber).isEmpty()) {

                // 인형 선택
                int pickDoll = dolls.get(moveNumber).pollLast();


                // 같은 인형이면 터트려야하는데 인형이 없을 수도 있음, 인형이 있으면 비교할거
                if(!getDolls.isEmpty()) {

                    // 제일 위에있는 인형이랑 pick인형이랑 같은가
                    if(getDolls.peek() == pickDoll) {
                        // 제일위에 있는 인형 터트리고
                        getDolls.pop();
                        // 터트린 인형은 두개
                        boomDolls += 2;
                    } else { // 같지 않으면 인형 쌓기
                        getDolls.push(pickDoll);
                    }

                } else { // 인형이 없는 경우는 그냥 쌓기
                    getDolls.push(pickDoll);
                }



            }


        }







        return boomDolls;
    }


}
