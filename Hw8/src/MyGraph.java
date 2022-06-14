import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.management.RuntimeErrorException;

public class MyGraph implements DynamicGraph {

    // Definations
    private List<Edge> edges[];
    private List<Vertex> vertexes = new ArrayList<Vertex>();
    private boolean isDirected;
    private int numberOfVertex;
    private int edgeArraySize;

    // Constructures
    public MyGraph(boolean isDirected, int numberOfVertex) {
        this.isDirected = isDirected;
        this.edgeArraySize = (numberOfVertex * 2) + 1;

        // Creaete edge arrays with edgeArraySize (edgeArraySize = (numberOfVertexSize *
        // 2) + 1 for create array is expensive)
        edges = new List[edgeArraySize];
        for (int i = 0; i < edgeArraySize; i++) {
            edges[i] = new LinkedList<Edge>();
        }
    }

    // Create New vertex with label and weight
    @Override
    public Vertex newVertex(String label, double weight) {
        // Find the max vertex index and new vertex id is more than one
        int max = findMaxVertexIndex() + 1;
        return new Vertex(max, label, weight);
    }

    // Add vertex to vertex list
    @Override
    public void addVertex(Vertex newVertex) {
        // Check if vertex index is already using. (Should be uniuqe)
        if (findVertexWithIndex(newVertex.getIndex()) == null) {
            vertexes.add(newVertex);
            numberOfVertex++;
        } else
            throw new RuntimeErrorException(null, "The index is already using please try with another index.");
    }

    // Add an Edge with source and destination vertex id and weight.
    @Override
    public void addEdge(int vertexId1, int vertexId2, double weight) {
        // If Edge array is full increase the edge array size
        increaseEdgeArrayIfFull();

        // Check there is have a vertexes with these id's
        if (findVertexWithIndex(vertexId1) != null && findVertexWithIndex(vertexId1) != null) {
            edges[vertexId1].add(new Edge(vertexId1, vertexId2, weight));
            if (isDirected)
                edges[vertexId2].add(new Edge(vertexId2, vertexId1, weight));
        } else
            throw new RuntimeErrorException(null,
                    "There is no vertex with these id, please try with using vertex id.");

    }

    // Add an Edge with source and destination vertex id and weight.
    private void addEdgeForSubGraph(int vertexId1, int vertexId2, double weight) {
        if (findVertexWithIndex(vertexId1) != null && findVertexWithIndex(vertexId1) != null)
            edges[vertexId1].add(new Edge(vertexId1, vertexId2, weight));
        else {
            throw new RuntimeErrorException(null, "There is no vertex with these id, please try with using vertex id.");
        }
    }

    // Remove edge with vertex id's
    @Override
    public void removeEdge(int vertexId1, int vertexId2) {
        for (Edge item : edges[vertexId1]) {
            if (item.getDest() == vertexId2)
                edges[vertexId1].remove(item);
        }
        if (isDirected) {
            for (Edge item : edges[vertexId2]) {
                if (item.getDest() == vertexId1)
                    edges[vertexId2].remove(item);
            }
        }
    }

    // Remove vertex with id's and also remove edges if there is have with this
    // vertex id
    @Override
    public void removeVertex(int vertexId) {
        if (!edges[vertexId].isEmpty())
            edges[vertexId].clear();
        vertexes.remove(findVertexWithIndex(vertexId));
    }

    // Filter vertex with given key and filter string
    @Override
    public MyGraph filterVertices(String key, String filter) {
        MyGraph subGraph = new MyGraph(isDirected, numberOfVertex);

        // Find vertex and add this on mg (Sub graph )
        for (Vertex item : vertexes) {
            if (!item.getProperties().isEmpty() && item.getProperties().get(key).equals(filter))
                subGraph.addVertex(item);

        }

        // Find edges and add this to on mg (Sub graph )
        for (Vertex item : subGraph.vertexes) {
            if (edges[item.getIndex()] != null) {
                for (Edge edge : edges[item.getIndex()]) {
                    if (subGraph.findVertexWithIndex(edge.getDest()) != null)
                        subGraph.addEdgeForSubGraph(item.getIndex(), subGraph.findVertexWithIndex(edge.getDest()).getIndex(), edge.getWeight());
                }
            }
        }
        return subGraph;
    }

    // Find a vertex with index if already exits
    private Vertex findVertexWithIndex(int index) {
        for (Vertex item : vertexes) {
            if (item.getIndex() == index)
                return item;
        }

        return null;
    }

    // Find max vertex index
    private int findMaxVertexIndex() {
        int max = 0;
        for (Vertex item : vertexes) {
            if (item.getIndex() > max)
                max = item.getIndex();
        }
        return max;
    }

    // Check if array size same or bigger than edge size
    private void increaseEdgeArrayIfFull() {
        if (this.vertexes.size() >= (edgeArraySize))
            edgesNumberIncrease();
    }

    // If edge array size is same with vertex increase the array size
    private void edgesNumberIncrease() {
        this.edgeArraySize = (this.numberOfVertex * 2) + 1;
        List<Edge> tempEdges[] = new List[this.edgeArraySize];

        for (int i = 0; i < edgeArraySize; i++) {
            tempEdges[i] = new LinkedList<Edge>();

            if (edges.length - 1 >= i && !edges[i].isEmpty()) {
                for (Edge edge : edges[i]) {
                    tempEdges[i].add(edge);
                }
            }

        }
        edges = tempEdges;
    }

    // Export the matrix
    @Override
    public double[][] exportMatrix() {
        double[][] mat = new double[vertexes.size()][vertexes.size()];
        int i = 0;
        int j = 0;
        for (Vertex vertex : vertexes) {
            j = 0;
            for (Vertex vertex2 : vertexes) {
                mat[i][j] = getEdge(vertex.getIndex(), vertex2.getIndex()).getWeight();
                j++;
            }
            i++;

        }
        return mat;
    }

    // Print the exported matrix
    public void print2D(double[][] mat) {
        System.out.print("\t");
        for (Vertex vertex : vertexes) {
            String s1 = Double.toString(vertex.getIndex());
            String s1Padding = " ".repeat(10 - s1.length());
            System.out.print(s1 + s1Padding);
        }
        System.out.println();

        int i = 0;
        int j = 0;

        for (Vertex vertex : vertexes) {
            System.out.print(vertex.getIndex() + "\t");
            j = 0;
            for (Vertex vertex2 : vertexes) {
                String s1 = Double.toString(mat[i][j]);
                String s1Padding = " ".repeat(10 - s1.length());
                System.out.print(s1 + s1Padding);
                j++;

            }
            System.out.println();
            i++;
        }
    }

    // Print Graph
    @Override
    public void printGraph() {
        for (List<Edge> list : edges) {
            for (Edge item : list) {
                StringBuffer sb = new StringBuffer("[(");
                sb.append(Integer.toString(item.getSource()));
                sb.append(", ");
                sb.append(Integer.toString(item.getDest()));
                sb.append("): ");
                sb.append(Double.toString(item.getWeight()));
                sb.append("]");
                System.out.println(sb);
            }
        }
    }

    // Getters
    public List<Vertex> getVertexes() {
        return this.vertexes;
    }

    public boolean isIsDirected() {
        return this.isDirected;
    }

    public int getNumberOfVertex() {
        return this.numberOfVertex;
    }

    @Override
    public void insert(Edge edge) {
        addEdge(edge.getSource(), edge.getDest(), edge.getWeight());
    }

    public boolean isDirected() {
        return this.isDirected;
    }

    @Override
    public boolean isEdge(int source, int dest) {
        return getEdge(source, dest).getWeight() != Double.POSITIVE_INFINITY;
    }

    @Override
    public Edge getEdge(int source, int dest) {
        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);

        if (source != -1) {
            for (Edge edge : edges[source]) {
                if (edge.equals(target))
                    return edge;
            }
        }
        return target;
    }

    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }
}
