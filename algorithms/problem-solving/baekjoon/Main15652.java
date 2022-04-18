import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.StringTokenizer;

public class Main15652 {

    private static int N;
    private static int M;
    private static int[] array;
    private static boolean[] visits;
    private static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());

        array = new int[M];

        dfs(1, 0);
        System.out.println(stringBuilder);
    }

    public static void dfs(int min, int depth) {
        if (depth == M) {
            for (int i : array) {
                stringBuilder.append(i).append(" ");
            }

            stringBuilder.append("\n");
            return;
        }

        for (int i = min; i <= N; i++) {
            array[depth] = i;
            dfs(i, depth + 1);
        }
    }
}
