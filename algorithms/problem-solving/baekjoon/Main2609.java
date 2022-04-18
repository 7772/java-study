//package baekjoon;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main2609 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = solve(a, b);

        System.out.println(gcd + " " + a * b / gcd);
    }

    public static int solve(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return solve(b, a % b);
    }
}
