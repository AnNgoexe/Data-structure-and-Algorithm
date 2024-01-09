package datastructure.weighedgraph;

import java.util.List;

public interface WeighedGraph {
    public boolean isValidVertex(int vertex);

    public void addVertex(int vertex);

    public void deleteVertex(int vertex);

    public int getNumberOfVertices();

    public int getDegreeOfVertex(int vertex);

    public List<Integer> getVertexNeighbors(int vertex);

    public List<Integer> getVertices();

    public boolean isValidEdge(int source, int destination);

    void addEdge(int source, int destination, int weight);

    public void deleteEdge(int source, int destination);

    public int getNumberOfEdges();

    public List<WeighedEdge> getEdges();

    public List<WeighedEdge> getEdgeNeighbors(int vertex);

    public int getWeight(int source, int destination);

    public void printGraph();
}
