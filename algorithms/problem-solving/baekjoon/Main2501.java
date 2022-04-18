package baekjoon;

import java.util.Scanner;

// 2501
public class Main2501 {

    public static void main(String[] args) {
        int n;
        int k;
        int count = 0;
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }

            if (count == k) {
                result = i;
                break;
            }
        }

        System.out.println(result);
        scanner.close();
    }
}
