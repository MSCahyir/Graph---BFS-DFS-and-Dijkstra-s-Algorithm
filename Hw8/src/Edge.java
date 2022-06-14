public class Edge {

    // Definations 
    private int source;
    private int dest;
    private double weight;

    public Edge() {
    }

    // Constructures (weight is default 1)
    public Edge(int source, int dest) {
        this.source = source;
        this.dest = dest;
        this.weight = 1.0;
    }

    public Edge(int source, int dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    // Getter and setters 
    public int getDest() {
        return this.dest;
    }

    public int getSource() {
        return this.source;
    }

    public double getWeight() {
        return this.weight;
    }

    // If destination and source is equal it's true 
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Edge)) {
            return false;
        }
        Edge edge = (Edge) o;
        return dest == edge.dest && source == edge.source;
    }

    // Print the edges 
    @Override
    public String toString() {
        return "{" +
                " dest='" + getDest() + "'" +
                ", source='" + getSource() + "'" +
                ", weight='" + getWeight() + "'" +
                "}";
    }

}
