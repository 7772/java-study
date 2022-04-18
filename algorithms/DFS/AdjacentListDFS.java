
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class AdjacentListDFS implements DFS {
    private int vertexCount;
    private ArrayList<LinkedList<Integer>> graphs;
    private boolean[] visits;

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
        System.out.print(vertex + " ");

        for (int i : graphs.get(vertex)) {
            if (!visits[i]) {
                dfs(i);
            }
        }
    }

    public void print() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " ");

            ListIterator iterator = graphs.get(i).listIterator(0);
            while (iterator.hasNext()) {
                int next = (int) iterator.next();

                System.out.print(next + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacentListDFS adjacentListDFS = new AdjacentListDFS(8);

        adjacentListDFS.edge(0, 1);
        adjacentListDFS.edge(0, 2);
        adjacentListDFS.edge(1, 3);
        adjacentListDFS.edge(1, 4);
        adjacentListDFS.edge(2, 5);
        adjacentListDFS.edge(2, 6);
        adjacentListDFS.edge(3, 7);
        adjacentListDFS.edge(4, 7);
        adjacentListDFS.edge(5, 7);
        adjacentListDFS.edge(6, 7);

        adjacentListDFS.print();
        adjacentListDFS.dfs(0);
    }
}
