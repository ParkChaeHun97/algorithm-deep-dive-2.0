package recursive.BOJ_10872_팩토리얼;

public class Solution {


    public static void main(String[] args) {
        System.out.println(factorial(10));
    }

    static int factorial(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        return n * factorial(n-1);
    }
}
