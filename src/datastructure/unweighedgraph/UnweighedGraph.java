package datastructure.unweighedgraph;

import datastructure.weighedgraph.WeighedEdge;

import java.util.List;

public interface UnweighedGraph {
    public boolean isValidVertex(int vertex);

    public void addVertex(int vertex);

    public void deleteVertex(int vertex);

    public int getNumberOfVertices();

    public int getDegreeOfVertex(int vertex);

    public List<Integer> getVertexNeighbors(int vertex);

    public List<Integer> getVertices();

    public boolean isValidEdge(int source, int destination);

    public void addEdge(int source, int destination);

    public void deleteEdge(int source, int destination);

    public int getNumberOfEdges();

    public List<Edge> getEdgeNeighbors(int vertex);

    public List<Edge> getEdges();

    public void printGraph();
}
