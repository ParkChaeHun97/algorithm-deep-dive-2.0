package brute_force_backtracking.problem.PGS_소수_찾기;

// 소수를 몇개 만들 수 있는가
// numbers 길이 1 ~ 7
// 013 은 0, 1, 3 숫자가 적힌 종이 조각
// 0, 01, 013,



import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>(); // 중복되는 숫자를 제외시키기 위한 set

    public int solution(String numbers) {

        boolean[] used = new boolean[numbers.length()];
        set.clear(); // 다음 테스트 케이스에서 중복 방지를 위한 set 비우기

        dfs("", numbers, used);

        return set.size();

    }

    public void dfs(String number, String numbers, boolean[] used) {
        if(!number.equals("")) { // 1, 7, 17, 71 모두 비교하려면 문자가 빈 것이 아니면 모두 비교
            int currentNum = Integer.parseInt(number);
            if(isPrime(currentNum)) {
                set.add(currentNum);
            }
        }

        // 모든 숫자를 사용했으면 백트래킹 시키기
        if(number.length() == numbers.length()) {
            return;
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(used[i]) continue;
            used[i] = true;
            dfs(number + numbers.charAt(i), numbers, used);
            used[i] = false;
        }


    }


    // 소수 판별 함수
    public static boolean isPrime(int number) {

        if(number < 2) { // 2보다 작으면 소수가 아님
            return false;
        }

        for(int i = 2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }

        return true;
    }

}
