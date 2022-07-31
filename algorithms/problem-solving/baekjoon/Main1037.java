import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main1037 {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (N-- > 0) {
            int number = Integer.parseInt(st.nextToken());

            if (max < number) {
                max = number;
            }

            if (min > number) {
                min = number;
            }
        }

        System.out.println(max * min);
    }
}
