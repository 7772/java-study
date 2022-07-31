import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main17427 {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int total = 0;

        for (int i = 1; i <= N; i++) {
            total += (N / i) * i;
        }

        System.out.println(total);
    }
}
