package brush_up_on.backtracking.타겟_넘버;

// 이 함수가 한 번 불리면 뭘 하나 정하나? -> 다음 번호를 뺄지 더할지 정한다.
// depth는 몇 번째 뭘 가리키나? ->
// 언제 결과를 처리하고 돌아가나? -> number를 모두 사용할때
// 돌아오면 뭘 원래대로 돌려나야 하나? -> 번호를 더한걸 되돌리거나 뺀걸 되돌린다.

class Solution {
    public int solution(int[] numbers, int target) {
        // 0번째 인덱스부터, 누적 합 0으로 DFS 탐색 시작
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        // 기저 조건: 모든 숫자를 다 사용한 경우
        if (depth == numbers.length) {
            // 현재까지의 누적 합이 타겟 넘버와 같다면 1(방법 1가지 찾음)을 반환, 아니면 0 반환
            return sum == target ? 1 : 0;
        }

        // 현재 숫자를 더하는 경우와 빼는 경우의 모든 결과를 합산하여 반환
        int add = dfs(numbers, target, depth + 1, sum + numbers[depth]);
        int subtract = dfs(numbers, target, depth + 1, sum - numbers[depth]);

        return add + subtract;
    }
}