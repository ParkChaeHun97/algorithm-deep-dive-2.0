package two_pointer.problem.PGS_할인_행사;

// 일정한 금액을 지불하면 10일 동안 회원 자격 부여
// 매일 한 가지 제품을 할인하는 행사를 함
// 할인 하는 제품은 하루에 하나씩만 구매 가능
// 자신이 원하는? 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우 맞춰서 회원가입 하려함

// 첫째날 열흘 간에는 냄비 할인이 없음, 회원가입 x
// 둘째 날부터 열흘 간에는 바나나를 원하는 만큼 할인구매할 수 없음 -> 가입 x
// 셋째날 넷째날 다섯째 날 부터 각각 열흘은 원하는 제품과 수량이 일치하기 때문에 셋중 하루에 회원가입

// want = [사고 싶은 과일,...]
// number = [사고 싶은 과일의 갯수]

// 해당 날짜에 가입하거나? 그 다음 날짜에 가입하거나
// 연속 10일을 시도했을 때, 전부 다 살 수 있는 최소 날짜.



import java.util.*;

class Solution {
    final static int WINDOW_SIZE = 10;

    public int solution(String[] want, int[] number, String[] discount) {

        int count = 0;


        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int left = 0;
        int right = -1;

        while(right < WINDOW_SIZE - 1) {

            right++;
            if(map.containsKey(discount[right])) {
                map.put(discount[right], map.get(discount[right]) - 1);
            }

        }


        boolean isZero =  isAllZero(map);
        if(isZero) count++;

        while(right < discount.length - 1) {
            if(map.containsKey(discount[left])) map.put(discount[left], map.get(discount[left]) + 1);

            left++;
            right++;

            if(map.containsKey(discount[right])) map.put(discount[right], map.get(discount[right]) - 1);

            isZero = isAllZero(map);
            if(isZero) count++;

        }


        return count;

    }

    public static boolean isAllZero(Map<String, Integer> map) {
        boolean isZero = true;

        for(int value : map.values()) {
            if(value != 0) {
                isZero = false;
                break;
            }
        }

        return isZero;

    }

}

/**
 * 회고
 *
 * "10일 연속", "수량 일치"라는 조건에서 고정 길이 슬라이딩 윈도우를 떠올렸다.
 * - 디버깅 출력이 1 -1 1 0 0 으로 나와 값이 틀린 줄 알았으나, HashMap의 순회 순서가
 *   보장되지 않는다는 걸 잊고 있었다. want[i] 순서로 꺼내니 1 -1 0 0 1로 정상이었다.
 * - right를 0에서 시작해 코드를 짜다 보니 윈도우 크기가 11이 되어버렸고,
 *   right-- 로 보정해 통과했다. 하지만 보정 코드는 취약하다고 판단했다.
 * - right를 -1에서 시작해 right++ 후 처리하는 구조로 바꿨다. 첫 윈도우 세팅과
 *   슬라이딩이 같은 규칙을 따르게 되어 인덱스 보정이 필요 없어졌다.
 * - 배운 점: 값이 이상해 보일 때는 로직을 의심하기 전에 출력 방식부터 확인한다.
 */
