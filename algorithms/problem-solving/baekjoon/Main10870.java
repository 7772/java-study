package baekjoon;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main10870 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ConcurrentHashMap<Integer, Integer> memoizationMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            memoizationMap.put(i, fibo(i));
        }

        System.out.println(fibo(N));
    }

    public static Integer fibo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memoizationMap.containsKey(n)) {
            return memoizationMap.get(n);
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}
