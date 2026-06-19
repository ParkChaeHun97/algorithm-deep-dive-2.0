package week_03_number_theory.template;

public class Euclidean {

    public static void main(String[] args) {
        int a = 48;
        int b = 18;
        System.out.println(lcm(a,b));
        System.out.println(gcd(a,b));
    }

    //최소 공배수 구하는 식
    public static long lcm(int a, int b) {
        return ((long) a * b) / gcd(a, b);
    }

    // 최대 공약수 구하는 식
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
