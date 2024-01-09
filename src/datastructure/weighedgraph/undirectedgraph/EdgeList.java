package datastructure.weighedgraph.undirectedgraph;

import datastructure.unweighedgraph.Edge;
import datastructure.weighedgraph.WeighedEdge;
import datastructure.weighedgraph.WeighedGraph;
import java.util.*;

public class EdgeList implements WeighedGraph
{
    private HashMap<Edge, Integer> edges;

    public EdgeList() {
        this.edges = new HashMap<>();
    }

    public HashMap<Edge, Integer> getHashMapEdges() {
        return this.edges;
    }

    @Override
    public boolean isValidVertex(int vertex) {
        for (Edge edge : edges.keySet()) {
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
        edges.keySet().removeIf(edge -> edge.getSource() == vertex || edge.getDestination() == vertex);
    }


    @Override
    public int getNumberOfVertices() {
        Set<Integer> vertices = new HashSet<>();
        for (Edge edge : edges.keySet()) {
            vertices.add(edge.getSource());
            vertices.add(edge.getDestination());
        }
        return vertices.size();
    }

    @Override
    public int getDegreeOfVertex(int vertex) {
        int degree = 0;
        for (Edge edge : edges.keySet()) {
            if (edge.getSource() == vertex || edge.getDestination() == vertex) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public List<Integer> getVertexNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (Edge edge : edges.keySet()) {
            if (edge.getSource() == vertex) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }


    @Override
    public List<Integer> getVertices() {
        List<Integer> vertices = new ArrayList<>();
        for (Edge edge : edges.keySet()) {
            vertices.add(edge.getSource());
            vertices.add(edge.getDestination());
        }
        return new ArrayList<>(vertices);
    }

    @Override
    public boolean isValidEdge(int source, int destination) {
        Edge edgeToCheck = new Edge(source, destination);
        return edges.containsKey(edgeToCheck);
    }


    @Override
    public void addEdge(int source, int destination, int weight) {
        if (source > destination) {
            int temp = source;
            source = destination;
            destination = temp;
        }
        Edge edge = new Edge(source, destination);
        if (!isValidEdge(source, destination)) {
            edges.put(edge, weight);
        } else {
            System.out.println("Edge (" + source + ", " + destination + ") already exists in the list.");
        }
    }

    @Override
    public void deleteEdge(int source, int destination) {
        if (source > destination) {
            int temp = source;
            source = destination;
            destination = temp;
        }
        Edge edgeToDelete = new Edge(source, destination);
        edges.remove(edgeToDelete);
    }

    @Override
    public int getNumberOfEdges() {
        return edges.size();
    }

    @Override
    public List<WeighedEdge> getEdges() {
        List<WeighedEdge> weighedEdges = new ArrayList<>();
        for (Edge edge : edges.keySet()) {
            weighedEdges.add(new WeighedEdge(edge.getSource(), edge.getDestination(), edges.get(edge)));
        }
        return weighedEdges;
    }

    @Override
    public List<WeighedEdge> getEdgeNeighbors(int vertex) {
        List<WeighedEdge> weighedEdges = new ArrayList<>();
        for (Edge edge : edges.keySet()) {
            if(edge.getSource() == vertex || edge.getDestination() == vertex) {
                weighedEdges.add(new WeighedEdge(edge.getSource(), edge.getDestination(), edges.get(edge)));
            }
        }
        return weighedEdges;
    }

    @Override
    public int getWeight(int source, int destination) {
        if (source > destination) {
            int temp = source;
            source = destination;
            destination = temp;
        }
        Edge edge = new Edge(source, destination);
        return edges.getOrDefault(edge, 0);
    }

    @Override
    public void printGraph() {
        for (Edge edge : edges.keySet()) {
            System.out.println("Edge: " + edge.toString() + ", Weight: " + edges.get(edge));
        }
    }

    public static void main(String[] args) {
        EdgeList graph = new EdgeList();

        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 4, 8);
        graph.addEdge(3, 5, 4);
        graph.addEdge(4, 5, 5);

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
        System.out.println("Weight of edge(4, 5): " + graph.getWeight(4, 5));
    }
}

