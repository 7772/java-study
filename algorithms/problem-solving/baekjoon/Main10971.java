import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10971 {

    private static int N;
    private static int[][] array;
    private static int[] temp;
    private static boolean[] visits;
    private static int min = Integer.MAX_VALUE;
    private static int sum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        array = new int[N][N];
        temp = new int[N];
        visits = new boolean[N];

        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dfs(0);
        System.out.println(min >= Integer.MAX_VALUE ? 0 : min);
    }

    private static void dfs(int depth) {
        if (depth == N) {
//            System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3]);

            if (
                array[temp[0]][temp[1]] != 0 &&
                array[temp[1]][temp[2]] != 0 &&
                array[temp[2]][temp[3]] != 0 &&
                array[temp[3]][temp[0]] != 0
            ) {
                sum += array[temp[0]][temp[1]] + array[temp[1]][temp[2]] + array[temp[2]][temp[3]] + array[temp[3]][temp[0]];
                min = min > sum ? sum : min;
                sum = 0;
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visits[i]) {
                visits[i] = true;
                temp[depth] = i;
                dfs(depth + 1);
                visits[i] = false;
            }
        }
    }
}
