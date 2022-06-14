import java.util.*;

public class DepthFirstSearch {
    private Graph graph;
    private double[][] parent;
    private boolean[] visited;
    private int[] discoveryOrder;
    private int[] finishOrder;
    private int discoverIndex = 0;
    private int finishIndex = 0;

    public DepthFirstSearch(MyGraph graph) {

        // Definations
        this.graph = graph;
        int n = graph.getNumberOfVertex();
        parent = new double[n][n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];

        // Make all weight to infinity to compare other weights
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    parent[i][j] = 0.0;
                else
                    parent[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        // depthFirstSearch recursively all nodes
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                depthFirstSearch(i);
        }
    }

    public void depthFirstSearch(int current) {

        // Mark the current vertex visited.
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;

        // Currenct vertex to neighbor vertexes
        Iterator<Edge> itr = graph.edgeIterator(current);
        while (itr.hasNext()) {
            Edge neighbor = itr.next();
            // Neighbor didn't visited

            if (parent[0][neighbor.getDest()] > parent[0][neighbor.getSource()] + neighbor.getWeight())
                parent[0][neighbor.getDest()] = parent[0][neighbor.getSource()] + neighbor.getWeight();

            if (!visited[neighbor.getDest()]) {

                // This is the diffirent part from DFS
                // (Checking the initial state to source weight and if less than the currenct
                // weight change the weight)
                parent[neighbor.getSource()][neighbor.getDest()] = neighbor.getWeight();

                depthFirstSearch(neighbor.getDest());
            }
        }
        // Store which node is finished first
        finishOrder[finishIndex++] = current;
    }

    // Get parent
    public double[][] getParent() {
        return parent;
    }

}
