
import java.util.Scanner;

public class Main1292 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        solve(a, b);
    }

    public static void solve(int a, int b) {
        System.out.println(calculate(b) - calculate(a - 1));
    }

    public static int calculate(int n) {
        int count = 1;
        int sum = 0;
        int numberToAdd = 1;

        while (count <= n) {
            for (int i = 1; i <= numberToAdd; i++) {
                if (count > n) {
                    break;
                }
                sum += numberToAdd;
                count++;
            }

            numberToAdd++;
        }

        return sum;
    }
}
