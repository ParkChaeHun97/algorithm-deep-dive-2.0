package recursive.BOJ_10870_피보나치_수_5;

public class Solution {

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }


    static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return fibonacci(n - 1) + fibonacci (n -2 );

    }
}
