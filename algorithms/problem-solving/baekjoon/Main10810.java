package baekjoon;

import java.util.Scanner;

public class Main10810 {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();

        solve(N);
    }

    public static void solve(int n) {
        int min = 1_000_000;
        int max = -1_000_000;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            if (min > num) {
                min = num;
            }

            if (max < num) {
                max = num;
            }
        }

        System.out.println(min + " " + max);
    }
}
