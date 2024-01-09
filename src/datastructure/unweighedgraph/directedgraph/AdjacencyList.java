package datastructure.unweighedgraph.directedgraph;

import datastructure.unweighedgraph.UnweighedGraph;
import datastructure.unweighedgraph.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList implements UnweighedGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacencyList() {
        this.adjacencyList = new HashMap<>();
    }

    public Map<Integer, List<Integer>> getAdjacencyListEdges() {
        return this.adjacencyList;
    }

    @Override
    public boolean isValidVertex(int vertex) {
        return this.adjacencyList.containsKey(vertex);
    }

    @Override
    public void addVertex(int vertex) {
        if (!isValidVertex(vertex)) {
            this.adjacencyList.put(vertex, new ArrayList<>());
        } else {
            System.out.println("Vertex " + vertex + " already exists in the list.");
        }
    }

    @Override
    public void deleteVertex(int vertex) {
        if (isValidVertex(vertex)) {
            this.adjacencyList.remove(vertex);
            for (List<Integer> neighbors : this.adjacencyList.values()) {
                neighbors.removeIf(neighbor -> neighbor == vertex);
            }
        } else {
            System.out.println("Invalid vertex. Vertex not deleted.");
        }
    }

    @Override
    public int getNumberOfVertices() {
        return this.adjacencyList.size();
    }

    public int getInDegreeOfVertex(int vertex) {
        int inDegree = 0;
        for (List<Integer> neighbors : this.adjacencyList.values()) {
            inDegree += neighbors.contains(vertex) ? 1 : 0;
        }
        return inDegree;
    }

    public int getOutDegreeOfVertex(int vertex) {
        if (this.isValidVertex(vertex)) {
            return adjacencyList.get(vertex).size();
        } else {
            System.out.println("Invalid vertex.");
            return -1;
        }
    }

    @Override
    public int getDegreeOfVertex(int vertex) {
        return this.getInDegreeOfVertex(vertex) + this.getOutDegreeOfVertex(vertex);
    }

    @Override
    public List<Integer> getVertexNeighbors(int vertex) {
        if (this.isValidVertex(vertex)) {
            return new ArrayList<>(this.adjacencyList.get(vertex));
        } else {
            System.out.println("Invalid vertex.");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Integer> getVertices() {
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : this.adjacencyList.entrySet()) {
            answer.add(entry.getKey());
        }
        return answer;
    }

    @Override
    public boolean isValidEdge(int source, int destination) {
        return isValidVertex(source) && isValidVertex(destination)
                && this.adjacencyList.get(source).contains(destination);
    }

    @Override
    public void addEdge(int source, int destination) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            this.adjacencyList.get(source).add(destination);
        } else {
            System.out.println("Invalid vertices. Edge not added.");
        }
    }

    @Override
    public void deleteEdge(int source, int destination) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            this.adjacencyList.get(source).removeIf(neighbor -> neighbor == destination);
        } else {
            System.out.println("Invalid vertices. Edge not deleted.");
        }
    }

    @Override
    public int getNumberOfEdges() {
        int count = 0;
        for (List<Integer> neighbors : adjacencyList.values()) {
            count += neighbors.size();
        }
        return count;
    }

    @Override
    public List<Edge> getEdgeNeighbors(int vertex) {
        List<Edge> edgeNeighbors = new ArrayList<>();
        if (isValidVertex(vertex)) {
            for (int neighbor : adjacencyList.get(vertex)) {
                edgeNeighbors.add(new Edge(vertex, neighbor));
            }
        } else {
            System.out.println("Invalid vertex.");
        }
        return edgeNeighbors;
    }

    @Override
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : this.adjacencyList.entrySet()) {
            int source = entry.getKey();
            for (int destination : entry.getValue()) {
                Edge edge = new Edge(source, destination);
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : this.adjacencyList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + ": ");
            for (int neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();
        for (int i = 1; i <= 5; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(1, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        System.out.println("Graph after adding vertices and edges:");
        graph.printGraph();


        graph.deleteVertex(3);
        System.out.println("\nGraph after deleting vertex 3:");
        graph.printGraph();

        System.out.println("\nNumber of vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of edges: " + graph.getNumberOfEdges());

        int vertexToCheck = 2;
        System.out.println("\nIn-Degree of Vertex " + vertexToCheck + ": " + graph.getInDegreeOfVertex(vertexToCheck));
        System.out.println("Out-Degree of Vertex " + vertexToCheck + ": " + graph.getOutDegreeOfVertex(vertexToCheck));
        System.out.println("Total Degree of Vertex " + vertexToCheck + ": " + graph.getDegreeOfVertex(vertexToCheck));
    }
}
