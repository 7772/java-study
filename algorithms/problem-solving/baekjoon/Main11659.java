import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.Integer;

public class Main11659 {

    private static int N;
    private static int M;
    private static int[] array;
    private static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input1 = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(input1.nextToken());
        M = Integer.parseInt(input1.nextToken());
        array = new int[N];

        StringTokenizer input2 = new StringTokenizer(bf.readLine(), " ");
        array[0] = Integer.parseInt(input2.nextToken());

        for (int i = 1; i < N; i++) {
            array[i] = array[i - 1] + Integer.parseInt(input2.nextToken());
        }

        StringTokenizer input3;

        for (int i = 0; i < M; i++) {
            input3 = new StringTokenizer(bf.readLine(), " ");
            int start = Integer.parseInt(input3.nextToken());
            int end = Integer.parseInt(input3.nextToken());

            if (start - 2 >= 0) {
                sb.append(array[end - 1] - array[start - 2]);
            } else {
                sb.append(array[end - 1]);
            }

            if (i < M - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
