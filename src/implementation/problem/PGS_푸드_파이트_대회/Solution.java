package implementation.problem.PGS_푸드_파이트_대회;

// 수웅이는 매달 주어진 음식을 빨리 먹는 푸드 파이트 대회를 개최한다.
// 선수들은 1:1로 대결한다.
// 매 대결마다 음식 종류와 양이 바뀐다.
// 대결은 준비된 음식들을 일렬로 배치한 뒤, 한 선수는 제일 왼쪽에 있는 음식 부터 오른쪽으로
// 다른 선수는 제일 오른쪽에 있는 거부터 왼쪽으로 먹는다.
// 중아에 물을 배치, 물을 먼저 먹는 선수가 승리
// 공정성 위해서 두 선수가 음식의 종류와 양이 같아야 하며
// 음식 먹는 순서도 같아야 한다.
// 이번 대회부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하여
// 선수들이 음식을 더 잘 먹을 수 있게 할려고 한다.

// [1, 3, 4, 6]
// 물 1개
// 1번 3개
// 2번 4개
// 3번 6개

// sb 에 1/2, 2/2, 3/2 번 넣기
// 0번 넣고
// 새 스트링 = sb + sb.reverse()


class Solution {
    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }

        return sb.toString() + "0" + sb.reverse().toString();
    }
}
