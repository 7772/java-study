import java.io.*;
import java.util.*;

public class Main11053 {

    private static int N;
    private static int[] array;
    private static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N];
        result = new int[N];

        StringTokenizer tokenizer = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
            result[i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = result[i] > max ? result[i] : max;
        }

        System.out.println(max);
    }
}
