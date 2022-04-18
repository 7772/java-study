import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Integer;

public class Main1712 {

    private static long A;
    private static long B;
    private static long C;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bf.readLine(), " ");

        A = Integer.parseInt(input.nextToken());
        B = Integer.parseInt(input.nextToken());
        C = Integer.parseInt(input.nextToken());

        solve();
    }

    private static void solve() {
        if (B >= C) {
            System.out.println(-1);

            return;
        }

        System.out.println((A / (C - B)) + 1);
    }
}
