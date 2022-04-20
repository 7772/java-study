import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Queue;

public class Main1260 {

    private static int N;
    private static int M;
    private static int V;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(input.nextToken());
        M = Integer.parseInt(input.nextToken());
        V = Integer.parseInt(input.nextToken());

        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            input = new StringTokenizer(bf.readLine(), " ");

            int start = Integer.parseInt(input.nextToken());
            int end = Integer.parseInt(input.nextToken());

            graph.edge(start - 1, end - 1);
        }

        graph.sort();
        graph.dfs(V - 1);
        graph.clearVisits();
        System.out.println();
        graph.bfs(V - 1);
    }

    static class Graph {

        private int vertexCount;
        private List<LinkedList<Integer>> graphs;
        private boolean[] visits;

        public Graph(int vertexCount) {
            this.vertexCount = vertexCount;
            this.graphs = new ArrayList<LinkedList<Integer>>();
            for (int i = 0; i < vertexCount; i++) {
                this.graphs.add(new LinkedList<Integer>());
            }

            this.visits = new boolean[vertexCount];
        }

        public void sort() {
            for (int i = 0; i < graphs.size(); i++) {
                Collections.sort(graphs.get(i));
            }
        }

        public void edge(int start, int end) {
            graphs.get(start).add(end);
            graphs.get(end).add(start);
        }

        public void dfs(int vertex) {
            visits[vertex] = true;
            System.out.print(vertex + 1 + " ");

            for (int i : graphs.get(vertex)) {
                if (!visits[i]) {
                    dfs(i);
                }
            }
        }

        public void bfs(int vertex) {
            Queue<Integer> queue = new LinkedList<Integer>();

            queue.add(vertex);
            visits[vertex] = true;

            while (!queue.isEmpty()) {
                int number = queue.poll();
                System.out.print(number + 1 + " ");

                for (int i = 0; i < graphs.get(number).size(); i++) {
                    int v = graphs.get(number).get(i);

                    if (!visits[v]) {
                        queue.add(v);
                        visits[v] = true;
                    }
                }
            }

        }

        public void clearVisits() {
            visits = new boolean[visits.length];
        }
    }
}
