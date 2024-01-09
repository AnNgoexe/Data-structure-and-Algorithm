package datastructure.weighedgraph;

import datastructure.unweighedgraph.Edge;

public class WeighedEdge extends Edge implements Comparable<WeighedEdge> {
    private int weight;

    public WeighedEdge(int source, int destination, int weight) {
        super(source, destination);
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "(" + this.source + ", " + this.destination + ", " + this.weight + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        WeighedEdge that = (WeighedEdge) obj;
        return weight == that.weight;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + weight;
        return result;
    }

    @Override
    public int compareTo(WeighedEdge otherEdge) {
        return Integer.compare(this.weight, otherEdge.weight);
    }
}