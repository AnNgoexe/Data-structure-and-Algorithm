package datastructure.unweighedgraph;

public class Edge {
    protected int source;
    protected int destination;

    public Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getSource() {
        return this.source;
    }

    public int getDestination() {
        return this.destination;
    }

    @Override
    public String toString() {
        return "(" + this.source + ", " + this.destination + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Edge edge = (Edge) obj;
        return source == edge.source && destination == edge.destination;
    }

    @Override
    public int hashCode() {
        return 13 * source + destination;
    }
}
