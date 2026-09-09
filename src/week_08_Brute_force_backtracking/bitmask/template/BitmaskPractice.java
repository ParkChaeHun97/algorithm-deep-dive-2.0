package week_08_Brute_force_backtracking.bitmask.template;

public class BitmaskPractice {
    public static void main(String[] args) {
        int state = 0; // 0000 아무것도 선택 하지 않은 상태
        System.out.println(Integer.toBinaryString(state)); // 0임

        state = state | (1 << 0); // 0번 켜기
        System.out.println(Integer.toBinaryString(state)); // 1

        state = state | (1 << 2); // 2번 켜기
        System.out.println(Integer.toBinaryString(state)); // 101
        System.out.println("\n\n");

        //-----------------------------------------------------------

        int state2 = 0;
        state2 = state2 | (1 << 0); // 0번 키고
        state2 = state2 | (1 << 2); // 2번 키기

        // 각 자리가 켜져 있는지 확인, 0번 부터 3번 까지
        for (int i = 0; i < 4; i++) {
            boolean used = (state2 & (1 << i)) != 0;
            System.out.println(i + "번: " + used);
        }

        // ---------------------------------------------------
        // 비트 끄기
        int state3 = 0;
        state3 = state3 | (1 << 0);
        state3 = state3 | (1 << 2);

        state3 = state3 & ~(1 << 0);

        System.out.println((state3 & (1 << 0)) != 0);



    }
}
