package two_pointer.problem.PGS_숫자의_표현;

class Solution {
    public int solution(int n) {
        int result = 0;
        int sum = 0;
        int left = 1;  // 자연수 1부터 시작
        int right = 1; // 자연수 1부터 시작

        // right가 n을 초과하여 커지면 더 이상 조사할 필요가 없으므로 종료
        while (right <= n + 1) {
            if (sum < n) {
                sum += right; // 변수 right 자체를 값으로 더함
                right++;
            } else if (sum > n) {
                sum -= left;  // 변수 left 자체를 값으로 뺌
                left++;
            } else { // sum == n 인 경우
                result++;
                sum += right; // 다음 탐색을 위해 현재 right를 더해주고 이동
                right++;
            }
        }

        return result;

    }
}
