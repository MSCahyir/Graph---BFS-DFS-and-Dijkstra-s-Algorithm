
public interface DynamicGraph extends Graph{

    // TO GENERATE NEW VERTEX WITH PARAMATERS
    public Vertex newVertex(String label, double weight);

    // ADD THE GIVEN VERTEX TO GRAPH
    public void addVertex(Vertex newVertex);

    // ADD AN EDGE BETWEEN THE GIVEN TWO VERTEX TO GRAPH
    public void addEdge(int vertexId1, int vertexId2, double weight);

    // REMOVE THE EDGE BETWEEN TWO GIVEN VERTEX
    public void removeEdge(int vertexId1, int vertexId2);

    // REMOVE THE VERTEX WITH GIVEN BY ID 
    public void removeVertex(int vertexId);
    
    // FILTER THE VERTICES BY GIVEN USER DEFINED PROPERTY AND RETURNS A SUBGRAPH OF GRAPH
    public MyGraph filterVertices(String key, String filter);

    // GENERATE THE ADJACENCY MATRIX REPRESANTATION OF THE GRAPH AND RETURNS THE MATRIX 
    public double[][] exportMatrix();

    // PRINT THE GRAPH IN ADJACENCY LIST FORMAT
    public void printGraph();



}
