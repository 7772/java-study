import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main1476 {

    private static int E;
    private static int S;
    private static int M;

    private static int eMax = 15;
    private static int sMax = 28;
    private static int mMax = 19;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");

        E = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());

        int e = 0;
        int s = 0;
        int m = 0;

        int count = 0;

        while (true) {
            e++;
            if (e > eMax) {
                e = 1;
            }

            s++;
            if (s > sMax) {
                s = 1;
            }

            m++;
            if (m > mMax) {
                m = 1;
            }

            count++;

            if (e == E && s == S && m == M) {
                break;
            }
        }

        System.out.println(count);
    }
}
