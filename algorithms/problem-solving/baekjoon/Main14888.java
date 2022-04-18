import java.util.Scanner;
import java.lang.Math;

public class Main14888 {
    public static Scanner scanner = new Scanner(System.in);

    public static int N;
    public static int numbers[];
    public static int operators[];
    public static int MAX = -1000000000;
    public static int MIN = +1000000000;
    public static int OPERATOR_COUNT = 4;

    public static void main(String[] args) {
        N = scanner.nextInt();

        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        operators = new int[4];

        for (int i = 0; i < OPERATOR_COUNT; i++) {
            operators[i] = scanner.nextInt();
        }

        solve();
    }

    public static void solve() {
        dfs(numbers[0], 1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int number, int nextIndex) {
        if (nextIndex == N) {
            MAX = Math.max(MAX, number);
            MIN = Math.min(MIN, number);

            return;
        }

        for (int i = 0; i < OPERATOR_COUNT; i++) {
            if (operators[i] < 1) {
                continue;
            }

            operators[i]--;

            switch (i) {
                case 0:
                    dfs(number + numbers[nextIndex], nextIndex + 1);
                    break;
                case 1:
                    dfs(number - numbers[nextIndex], nextIndex + 1);
                    break;
                case 2:
                    dfs(number * numbers[nextIndex], nextIndex + 1);
                    break;
                case 3:
                    dfs(number / numbers[nextIndex], nextIndex + 1);
                    break;
            }

            operators[i]++;
        }
    }
}
