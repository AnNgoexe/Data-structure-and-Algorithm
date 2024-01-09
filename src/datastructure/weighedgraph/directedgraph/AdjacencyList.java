package datastructure.weighedgraph.directedgraph;

import datastructure.weighedgraph.WeighedEdge;
import datastructure.weighedgraph.WeighedGraph;
import java.util.*;

public class AdjacencyList implements WeighedGraph {
    private Map<Integer, List<WeighedEdge>> weightedAdjacencyList;

    public AdjacencyList() {
        this.weightedAdjacencyList = new HashMap<>();
    }

    public Map<Integer, List<WeighedEdge>> getWeightedAdjacencyListEdges() {
        return this.weightedAdjacencyList;
    }

    @Override
    public boolean isValidVertex(int vertex) {
        return this.weightedAdjacencyList.containsKey(vertex);
    }

    @Override
    public void addVertex(int vertex) {
        if (!isValidVertex(vertex)) {
            this.weightedAdjacencyList.put(vertex, new ArrayList<>());
        } else {
            System.out.println("Vertex " + vertex + " already exists in the list.");
        }
    }

    @Override
    public void deleteVertex(int vertex) {
        if (isValidVertex(vertex)) {
            this.weightedAdjacencyList.remove(vertex);
            for (List<WeighedEdge> neighbors : this.weightedAdjacencyList.values()) {
                neighbors.removeIf(neighbor -> neighbor.getDestination() == vertex);
            }
        } else {
            System.out.println("Invalid vertex. Vertex not deleted.");
        }
    }

    @Override
    public int getNumberOfVertices() {
        return this.weightedAdjacencyList.size();
    }

    public int getInDegree(int vertex) {
        int inDegree = 0;
        for (List<WeighedEdge> neighbors : this.weightedAdjacencyList.values()) {
            for (WeighedEdge edge : neighbors) {
                if (edge.getDestination() == vertex) {
                    inDegree++;
                }
            }
        }
        return inDegree;
    }

    public int getOutDegree(int vertex) {
        if (isValidVertex(vertex)) {
            return weightedAdjacencyList.get(vertex).size();
        } else {
            System.out.println("Invalid vertex.");
            return 0;
        }
    }

    @Override
    public int getDegreeOfVertex(int vertex) {
        return this.getInDegree(vertex) + this.getOutDegree(vertex);
    }

    @Override
    public List<Integer> getVertexNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        if (isValidVertex(vertex)) {
            for (WeighedEdge edge : weightedAdjacencyList.get(vertex)) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    @Override
    public List<Integer> getVertices() {
        List<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, List<WeighedEdge>> entry : this.weightedAdjacencyList.entrySet()) {
            answer.add(entry.getKey());
        }
        return answer;
    }

    @Override
    public boolean isValidEdge(int source, int destination) {
        return isValidVertex(source) && isValidVertex(destination)
                && this.weightedAdjacencyList.get(source).stream().anyMatch(edge -> edge.getDestination() == destination);
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            WeighedEdge edge = new WeighedEdge(source, destination, weight);
            this.weightedAdjacencyList.get(source).add(edge);
        } else {
            System.out.println("Invalid vertices. Edge not added.");
        }
    }

    @Override
    public void deleteEdge(int source, int destination) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            this.weightedAdjacencyList.get(source).removeIf(neighbor -> neighbor.getDestination() == destination);
        } else {
            System.out.println("Invalid vertices. Edge not deleted.");
        }
    }

    @Override
    public int getNumberOfEdges() {
        int count = 0;
        for (List<WeighedEdge> neighbors : weightedAdjacencyList.values()) {
            count += neighbors.size();
        }
        return count;
    }

    @Override
    public List<WeighedEdge> getEdges() {
        List<WeighedEdge> edges = new ArrayList<>();
        for (Map.Entry<Integer, List<WeighedEdge>> entry : this.weightedAdjacencyList.entrySet()) {
            int source = entry.getKey();
            for (WeighedEdge neighbor : entry.getValue()) {
                WeighedEdge edge = new WeighedEdge(source, neighbor.getDestination(), neighbor.getWeight());
                edges.add(edge);
            }
        }
        return edges;
    }

    @Override
    public List<WeighedEdge> getEdgeNeighbors(int vertex) {
        List<WeighedEdge> edgeNeighbors = new ArrayList<>();
        if (isValidVertex(vertex)) {
            edgeNeighbors.addAll(weightedAdjacencyList.get(vertex));
        } else {
            System.out.println("Invalid vertex.");
        }
        return edgeNeighbors;
    }

    @Override
    public int getWeight(int source, int destination) {
        if (isValidEdge(source, destination)) {
            for (WeighedEdge edge : weightedAdjacencyList.get(source)) {
                if (edge.getDestination() == destination) {
                    return edge.getWeight();
                }
            }
        }
        return 0;
    }

    @Override
    public void printGraph() {
        for (Map.Entry<Integer, List<WeighedEdge>> entry : this.weightedAdjacencyList.entrySet()) {
            System.out.print("Vertex " + entry.getKey() + ": ");
            for (WeighedEdge neighbor : entry.getValue()) {
                System.out.print("(" + neighbor.getDestination() + ", " + neighbor.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();
        for (int i = 1; i <= 5; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 5, 9);
        graph.addEdge(4, 5, 10);
        System.out.println("Graph after adding vertices and edges:");
        graph.printGraph();


        graph.deleteVertex(3);
        System.out.println("\nGraph after deleting vertex 3:");
        graph.printGraph();

        System.out.println("\nNumber of vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of edges: " + graph.getNumberOfEdges());
        System.out.println("The weight of edge (1, 2): " + graph.getWeight(1, 2));
    }
}
