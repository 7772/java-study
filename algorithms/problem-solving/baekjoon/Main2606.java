
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class Main2606 {

    private static int N;
    private static int M;
    private static List<LinkedList<Integer>> graphs;
    private static boolean[] visits;
    private static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        graphs = new ArrayList<LinkedList<Integer>>();
        visits = new boolean[N];

        StringTokenizer input2;

        for (int i = 0; i < N; i++) {
            graphs.add(new LinkedList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            input2 = new StringTokenizer(bf.readLine(), " ");

            int start = Integer.parseInt(input2.nextToken()) - 1;
            int end = Integer.parseInt(input2.nextToken()) - 1;

            graphs.get(start).add(end);
            graphs.get(end).add(start);
        }

        dfs(0);

        if (count > 0) {
            System.out.println(count - 1);
        } else {
            System.out.println(count);
        }
    }

    private static void dfs(int vertex) {
        visits[vertex] = true;

        count++;

        for (int i : graphs.get(vertex)) {
            if (!visits[i]) {
                dfs(i);
            }
        }
    }
}
