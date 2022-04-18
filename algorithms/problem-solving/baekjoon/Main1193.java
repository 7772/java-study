import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main1193 {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());

        solve();
    }

    private static void solve() {
        int crossCount = 1;
        int prevIndexCount = 0;

        while (true) {
            if (N <= prevIndexCount + crossCount) {
                if (crossCount % 2 == 0) {
                    System.out.print((N - prevIndexCount) + "/" + (crossCount - (N - prevIndexCount - 1)));
                    return;
                } else {
                    System.out.print((crossCount - (N - prevIndexCount - 1)) + "/" + (N - prevIndexCount));
                    return;
                }
            } else {
                prevIndexCount += crossCount;
                crossCount++;
            }
        }
    }
}
