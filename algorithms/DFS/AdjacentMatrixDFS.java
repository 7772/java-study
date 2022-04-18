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
        adjacentMatrixDFS.edge(0, 3);
        adjacentMatrixDFS.edge(0, 6);
        adjacentMatrixDFS.edge(0, 8);
        adjacentMatrixDFS.edge(0, 9);
        adjacentMatrixDFS.edge(2, 1);
        adjacentMatrixDFS.edge(3, 5);
        adjacentMatrixDFS.edge(7, 9);
        adjacentMatrixDFS.edge(5, 3);
        adjacentMatrixDFS.edge(5, 1);
        adjacentMatrixDFS.edge(8, 4);
        adjacentMatrixDFS.edge(9, 3);

        adjacentMatrixDFS.print();
        adjacentMatrixDFS.dfs(0);
    }
}
