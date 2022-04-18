public class AdjacentMatrixDFS implements DFS {
    private int vertexCount;
    private int[][] graphs;
    private boolean[] visits;

    public AdjacentMatrixDFS(int vertexCount) {
        this.vertexCount = vertexCount;
        this.graphs = new int[vertexCount][vertexCount];
        this.visits = new boolean[vertexCount];
    }

    public void edge(int start, int end) {
        graphs[start][end] = 1;
        graphs[end][start] = 1;
    }

    public void dfs(int vertex) {
        visits[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < vertexCount; i++) {
            if (!visits[i] && graphs[vertex][i] == 1) {
                dfs(i);
            }
        }
    }

    public void print() {
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(graphs[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void main(String[] args) {
        AdjacentMatrixDFS adjacentMatrixDFS = new AdjacentMatrixDFS(10);

        adjacentMatrixDFS.edge(0, 1);
        adjacentMatrixDFS.edge(0, 2);
        adjacentMatrixDFS.edge(1, 3);
        adjacentMatrixDFS.edge(1, 4);
        adjacentMatrixDFS.edge(2, 5);
        adjacentMatrixDFS.edge(2, 6);
        adjacentMatrixDFS.edge(3, 7);
        adjacentMatrixDFS.edge(4, 7);
        adjacentMatrixDFS.edge(5, 7);
        adjacentMatrixDFS.edge(6, 7);

        adjacentMatrixDFS.print();
        adjacentMatrixDFS.dfs(0);
    }
}
