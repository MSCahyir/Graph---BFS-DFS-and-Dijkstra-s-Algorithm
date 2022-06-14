import java.util.Iterator;

public interface Graph {
    // Insert new edge
    void insert(Edge edge);

    // Check it's edge
    boolean isEdge(int source, int dest);

    // Get the edge 
    Edge getEdge(int source, int dest);

    // Iterator
    Iterator<Edge> edgeIterator(int source);
}
