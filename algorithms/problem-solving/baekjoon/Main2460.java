package baekjoon;

import java.util.Scanner;

public class Main2460 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = 9;

        scanner.nextInt();
        int n2 = scanner.nextInt();

        solve(N, n2);
    }

    public static void solve(int n, int max) {
        while (n > 0) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();

            if (max < max - (n1 - n2)) {
                max = max - (n1 - n2);
            }

            n--;
        }

        System.out.println(max);
    }
}
