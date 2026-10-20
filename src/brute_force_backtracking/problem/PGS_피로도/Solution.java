package brute_force_backtracking.problem.PGS_피로도;

// 최소 필요 피로도 : 던전을 탐험하기 위해 가지고 있어야하는 최소 피로도
// 소모 피로도 : 던전을 탐험한 후 소모되는 피로도
// 최소 필요 80, 소모 20 = 소모는 20

// 던전이 여러개가 있는데 유저가 탐험할 수 있는 최대 던전 수 리턴하기
// 던전은 최대 8개

class Solution {


    public int solution(int k, int[][] dungeons) {
        boolean[] used = new boolean[dungeons.length];
        int[] numbers = new int[dungeons.length];

        return dfs(0, k, dungeons, used, numbers);
    }


    public static int dfs(int depth, int k, int[][] dungeons,
                          boolean[] used, int[] numbers) {

        if(depth == dungeons.length) {
            // 돌수 있는 던전 갯수
            int count = 0;
            int p = k; // 현재 피로도


            for(int i = 0; i < dungeons.length; i++) {
                // 조회할 던전 idx
                int idx = numbers[i];

                // 최소 필요 피로도
                int m = dungeons[idx][0];
                // 소모 필요도
                int s = dungeons[idx][1];

                if(m > p) break;

                p -= s;
                count++;
            }


            return count;


        }

        int max = 0;

        // 순열로 시도
        for(int i = 0; i < dungeons.length; i++) {
            if(used[i]) continue;
            numbers[depth] = i;
            used[i] = true;
            max = Math.max(dfs(depth + 1, k, dungeons, used, numbers), max);
            used[i] = false;
        }

        return max;


    }
}
