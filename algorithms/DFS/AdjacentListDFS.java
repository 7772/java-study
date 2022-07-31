
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.HashMap;

class AdjacentListDFS {
    private int vertexCount;
    private ArrayList<LinkedList<Integer>> graphs;
    private boolean[] visits;
    private int count = 0;

    public AdjacentListDFS(int vertexCount) {
        this.vertexCount = vertexCount;
        this.graphs = new ArrayList<LinkedList<Integer>>();

        for (int i = 0; i < vertexCount; i++) {
            this.graphs.add(new LinkedList<Integer>());
        }

        this.visits = new boolean[vertexCount];
    }

    public void edge(int start, int end) {
        graphs.get(start).add(end);
        graphs.get(end).add(start);
    }

    public void dfs(int vertex) {
        visits[vertex] = true;
        count++;

        for (int i : graphs.get(vertex)) {
            if (!visits[i]) {
                dfs(i);
            }
        }
    }

    public int getClusterCount() {
        int clusterCount = 0;

        for (int i = 0; i < vertexCount; i++) {
            dfs(i);

            if (adjacentListDFS.count > 1) {
                clusterCount++;
            }

            this.count = 0;
        }

        return count;
    }
}

public class Solution {
    private static int N = 100000;
    private static int a;
    private static int b;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        AdjacentListDFS adjacentListDFS = new AdjacentListDFS(N);

        StringTokenizer tokenizer;
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");

            a = Integer.parseInt(tokenizer.nextToken());
            b = Integer.parseInt(tokenizer.nextToken());

            adjacentListDFS.edge(a, b);
        }

        System.out.println(adjacentListDFS.getClusterCount());
    }
}
