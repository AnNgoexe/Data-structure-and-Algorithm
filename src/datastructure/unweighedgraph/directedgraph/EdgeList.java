package datastructure.unweighedgraph.directedgraph;

import datastructure.unweighedgraph.UnweighedGraph;
import datastructure.unweighedgraph.Edge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EdgeList implements UnweighedGraph {
    private Set<Edge> edges;

    public EdgeList() {
        this.edges = new HashSet<>();
    }

    public Set<Edge> getSetEdges() {
        return this.edges;
    }

    @Override
    public boolean isValidVertex(int vertex) {
        for (Edge edge : edges) {
            if (edge.getSource() == vertex || edge.getDestination() == vertex) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addVertex(int vertex) {

    }

    @Override
    public void deleteVertex(int vertex) {
        this.edges.removeIf(edge -> edge.getSource() == vertex || edge.getDestination() == vertex);
    }

    @Override
    public int getNumberOfVertices() {
        Set<Integer> vertices = new HashSet<>();
        for (Edge edge : edges) {
            vertices.add(edge.getSource());
            vertices.add(edge.getDestination());
        }
        return vertices.size();
    }

    public int getInDegreeOfVertex(int vertex) {
        int inDegree = 0;
        for (Edge edge : this.edges) {
            if (edge.getDestination() == vertex) {
                inDegree++;
            }
        }
        return inDegree;
    }

    public int getOutDegreeOfVertex(int vertex) {
        int outDegree = 0;
        for (Edge edge : this.edges) {
            if (edge.getSource() == vertex) {
                outDegree++;
            }
        }
        return outDegree;
    }

    @Override
    public int getDegreeOfVertex(int vertex) {
        return this.getInDegreeOfVertex(vertex) + this.getOutDegreeOfVertex(vertex);
    }

    @Override
    public List<Integer> getVertexNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource() == vertex) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    @Override
    public List<Integer> getVertices() {
        Set<Integer> vertices = new HashSet<>();
        for (Edge edge : edges) {
            vertices.add(edge.getSource());
            vertices.add(edge.getDestination());
        }
        return new ArrayList<>(vertices);
    }

    @Override
    public boolean isValidEdge(int source, int destination) {
        Edge edgeToCheck = new Edge(source, destination);
        return edges.contains(edgeToCheck);
    }

    @Override
    public void addEdge(int source, int destination) {
        Edge edge = new Edge(source, destination);
        edges.add(edge);
    }

    @Override
    public void deleteEdge(int source, int destination) {
        Edge edgeToRemove = new Edge(source, destination);
        edges.removeIf(edge -> edge.equals(edgeToRemove));
    }

    @Override
    public int getNumberOfEdges() {
        return edges.size();
    }

    @Override
    public List<Edge> getEdgeNeighbors(int vertex) {
        List<Edge> weighedEdges = new ArrayList<>();
        for (Edge edge : edges) {
            if(edge.getSource() == vertex) {
                weighedEdges.add(new Edge(edge.getSource(), edge.getDestination()));
            }
        }
        return weighedEdges;
    }

    @Override
    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    @Override
    public void printGraph() {
        for (Edge edge : edges) {
            System.out.println("Edge: " + edge.toString());
        }
    }

    public static void main(String[] args) {
        EdgeList graph = new EdgeList();

        graph.addEdge(1, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("Initial Graph:");
        graph.printGraph();
        System.out.println("Number of Vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of Edges: " + graph.getNumberOfEdges());

        graph.deleteVertex(3);
        System.out.println("\nGraph after deleting vertex 3:");
        graph.printGraph();
        System.out.println("Number of Vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of Edges: " + graph.getNumberOfEdges());

        graph.deleteEdge(1, 2);
        System.out.println("\nGraph after deleting edge (1, 2):");
        graph.printGraph();
        System.out.println("Number of Vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of Edges: " + graph.getNumberOfEdges());

        int vertexToCheck = 4;
        System.out.println("\nIn-Degree of Vertex " + vertexToCheck + ": " + graph.getInDegreeOfVertex(vertexToCheck));
        System.out.println("Out-Degree of Vertex " + vertexToCheck + ": " + graph.getOutDegreeOfVertex(vertexToCheck));
        System.out.println("Total Degree of Vertex " + vertexToCheck + ": " + graph.getDegreeOfVertex(vertexToCheck));
    }
}
