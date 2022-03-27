
import java.util.Scanner;

public class Main2581 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        solve(a, b);
    }

    public static void solve(int a, int b) {
        int firstPrimeNumber = 0;
        int sum = 0;

        for (int i = a; i <= b; i++) {
            int count = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count ++;
                }
            }

            if (count == 2) {
                if (sum == 0) {
                    firstPrimeNumber = i;
                }

                sum += i;
            }
        }

        if (sum > 0) {
            System.out.println(sum);
            System.out.println(firstPrimeNumber);
        } else {
            System.out.println(-1);
        }
    }
}
