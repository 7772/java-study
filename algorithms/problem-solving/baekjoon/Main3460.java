package baekjoon;

import java.util.Scanner;

public class Main3460 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();

            solve(N);
        }
    }

    public static void solve(int n) {
        int index = 0;

        while (n > 0) {

            if (n % 2 == 1) {
                System.out.print(index + " ");
            }

            index++;

            n = n / 2;
        }
    }
}
