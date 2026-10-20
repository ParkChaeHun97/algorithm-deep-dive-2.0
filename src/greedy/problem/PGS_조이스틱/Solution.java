package greedy.problem.PGS_조이스틱;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        // 1. 문자 변경 횟수의 기본 커서 이동 값 설정 (오른쪽으로만 직진할 경우)
        int minMove = length - 1;

        for (int i = 0; i < length; i++) {
            // 알파벳 변경에 필요한 조이스틱 조작 횟수
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 2. 다음 위치부터 연속된 'A'의 끝 위치 찾기
            int nextIndex = i + 1;
            while (nextIndex < length && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            // 3. 커서 이동 최솟값 갱신
            // - i * 2 + length - nextIndex : 오른쪽으로 i만큼 갔다가 다시 시작점으로 돌아와서 끝으로 이동
            // - (length - nextIndex) * 2 + i : 끝부분으로 먼저 갔다가 돌아와서 i 위치로 이동
            minMove = Math.min(minMove, i * 2 + (length - nextIndex));
            minMove = Math.min(minMove, (length - nextIndex) * 2 + i);
        }

        return answer + minMove;
    }
}
