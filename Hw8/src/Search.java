import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Search {
    public static double[][] breadthFirstSearch(MyGraph grap, int start) {
        Queue<Integer> theQueue = new LinkedList<Integer>();

        // This is diffirent part from BST (Used the double 2D array to check possibilities )
        double[][] parent = new double[grap.getNumberOfVertex()][grap.getNumberOfVertex()];

        for (int i = 0; i < grap.getNumberOfVertex(); i++) {
            for (int j = 0; j < grap.getNumberOfVertex(); j++) {
                if (i == j)
                    parent[i][j] = 0.0;
                else
                    parent[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        
        boolean[] identified = new boolean[grap.getNumberOfVertex()];
        identified[start] = true;

        theQueue.offer(start);

        while (!theQueue.isEmpty()) {
            int current = theQueue.remove();

            Iterator<Edge> itr = grap.edgeIterator(current);
            identified[current] = true;

            while (itr.hasNext()) {
                Edge edge = itr.next();

                int neighbor = edge.getDest();

                if (!identified[neighbor]) {
                    theQueue.offer(neighbor);
                    parent[edge.getSource()][edge.getDest()] = edge.getWeight();
                    parent[edge.getDest()][edge.getSource()] = edge.getWeight();

                    // This is the diffirent part form BST (Check 0 to Destination value and if short change with new path)
                    if (parent[0][edge.getDest()] > parent[0][edge.getSource()] + edge.getWeight())
                        parent[0][edge.getDest()] = parent[0][edge.getSource()] + edge.getWeight();
                }
            }
        }
        return parent;
    }

    public static double[][] depthFirstSearch(MyGraph graph) {
        DepthFirstSearch dfs = new DepthFirstSearch(graph);
        return dfs.getParent();
    }

    public static double[] dijkstasAlgorithm(MyGraph graph, int start, int[] pred, double[] dist) {

        int numV = graph.getNumberOfVertex();
        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);

        // Initialize
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }

        // Initialize pred and dist.
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }

        // Main loop
        while (vMinusS.size() != 0) {
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;

            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }

            if (u != -1) {
                // Remove u from vMinusS.
                vMinusS.remove(u);
                // Update the distances.

                for (int v : vMinusS) {
                    if (graph.isEdge(u, v)) {
                        int boosting = Integer.parseInt(graph.getVertexes().get(3).getProperties().get("Boosting"));
                        double weight = graph.getEdge(u, v).getWeight() - boosting;
                        if (dist[u] + weight < dist[v]) {
                            dist[v] = dist[u] + weight;
                            pred[v] = u;
                        }
                    }
                }
            } else
                vMinusS.clear();
        }
        return dist;
    }
}
