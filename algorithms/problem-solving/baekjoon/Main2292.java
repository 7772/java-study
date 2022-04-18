import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;

public class Main2292 {

    private static long N;
    private static long MAX = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        solve();
    }

    private static void solve() {
        for (long i = 1; i < MAX / 6; i++) {
            if (N < getStartPoint(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static long getStartPoint(long n) {
        long sum = 0;

        for (long i = 1; i <= n - 1; i++) {
            sum += 6 * i;
        }

        return 2 + sum;
    }
}
