/**
 * GKislin
 * 24.05.2016
 */
public class MainIsPowerOfTwo {
    public static void main(String[] args) {
        print(-5);
        print(0);
        print(1);
        print(2);
        print(3);
        print(17);
        print(2048);
        print(Integer.MAX_VALUE);
    }

    static boolean isPowerOfTwo(int value) {
        if (value <= 0) {
            return false;
        }
        return (value & value - 1) == 0;
    }

    static void print(int value) {
        System.out.println(value + (isPowerOfTwo(value) ? " is power of 2" : " is not power of 2"));
    }
}
