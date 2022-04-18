
import java.util.Scanner;

public class Main10872 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        System.out.println(factorial(N));
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        if (n <= 1) {
            return n;
        }

        return n * factorial(n - 1);
    }
}
