package baekjoon;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main2460 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int N = 9;

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr.add(scanner.nextInt());
            sum += arr.get(i);
        }

        solve(arr, sum);
    }

    public static void solve(List<Integer> arr, int sum) {
        int a = 0;
        int b = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (sum - arr.get(i) - arr.get(j) == 100) {
                    a = arr.get(i);
                    b = arr.get(j);
                }
            }
        }

        arr.remove(a);
        arr.remove(b);
    }
}
