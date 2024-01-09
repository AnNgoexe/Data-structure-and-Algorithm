package datastructure.weighedgraph.undirectedgraph;

import datastructure.weighedgraph.WeighedEdge;
import datastructure.weighedgraph.WeighedGraph;

import java.util.List;
import java.util.ArrayList;

public class AdjacencyMatrix implements WeighedGraph {
    private List<List<Integer>> matrix;

    private int vertices;

    public AdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        this.matrix = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            List<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < vertices; j++) {
                neighbors.add(0);
            }
            this.matrix.add(neighbors);
        }
    }

    public List<List<Integer>> getMatrixEdges() {
        return this.matrix;
    }

    @Override
    public boolean isValidVertex(int vertex) {
        return vertex >= 0 && vertex < this.vertices;
    }

    @Override
    public void addVertex(int vertex) {
        if(vertex < this.vertices) {
            System.out.println("Not valid vertex");
            return;
        }
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            this.matrix.get(i).add(0);
            neighbors.add(0);
        }
        neighbors.add(0);
        this.matrix.add(neighbors);
        this.vertices++;
    }

    @Override
    public void deleteVertex(int vertex) {
        if (this.isValidVertex(vertex)) {
            this.matrix.remove(vertex);
            this.vertices--;
            for (List<Integer> neighbors : this.matrix) {
                neighbors.remove(vertex);
            }
        } else {
            System.out.println("Invalid vertex. Vertex not deleted.");
        }
    }

    @Override
    public int getNumberOfVertices() {
        return this.vertices;
    }

    @Override
    public int getDegreeOfVertex(int vertex) {
        if (this.isValidVertex(vertex)) {
            int degree = 0;
            for (int neighbor : this.matrix.get(vertex)) {
                degree += neighbor;
            }
            return degree;
        } else {
            System.out.println("Invalid vertex.");
            return -1;
        }
    }

    @Override
    public List<Integer> getVertexNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        if (isValidVertex(vertex)) {
            for (int i = 0; i < this.vertices; i++) {
                if (this.matrix.get(vertex).get(i) != 0) {
                    neighbors.add(i);
                }
            }
        } else {
            System.out.println("Invalid vertex.");
        }
        return neighbors;
    }

    @Override
    public List<Integer> getVertices() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            list.add(i);
        }
        return list;
    }

    @Override
    public boolean isValidEdge(int source, int destination) {
        return this.isValidVertex(source) && this.isValidVertex(destination)
                && this.matrix.get(source).get(destination) != 0;
    }

    @Override
    public void addEdge(int source, int destination, int weight) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            this.matrix.get(source).set(destination, weight);
            this.matrix.get(destination).set(source, weight);
        } else {
            System.out.println("Invalid vertices. Edge not added.");
        }
    }

    @Override
    public void deleteEdge(int source, int destination) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            this.matrix.get(source).set(destination, 0);
            this.matrix.get(destination).set(source, 0);
        } else {
            System.out.println("Invalid vertices. Edge not deleted.");
        }
    }

    @Override
    public int getNumberOfEdges() {
        int count = 0;
        for (int i = 0; i < this.vertices; i++) {
            for (int j = i + 1; j < this.vertices; j++) {
                if (this.matrix.get(i).get(j) != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public List<WeighedEdge> getEdges() {
        List<WeighedEdge> edges = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            for (int j = i + 1; j < this.vertices; j++) {
                if (this.matrix.get(i).get(j) != 0) {
                    edges.add(new WeighedEdge(i, j, this.matrix.get(i).get(j)));
                }
            }
        }
        return edges;
    }

    @Override
    public List<WeighedEdge> getEdgeNeighbors(int vertex) {
        List<WeighedEdge> edgeNeighbors = new ArrayList<>();
        if (isValidVertex(vertex)) {
            for (int i = 0; i < this.vertices; i++) {
                int weight = this.matrix.get(vertex).get(i);
                if (weight != 0) {
                    edgeNeighbors.add(new WeighedEdge(vertex, i, weight));
                }
            }
        } else {
            System.out.println("Invalid vertex.");
        }
        return edgeNeighbors;
    }

    @Override
    public int getWeight(int source, int destination) {
        return this.matrix.get(source).get(destination);
    }

    @Override
    public void printGraph() {
        for (List<Integer> neighbors : this.matrix) {
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 6);
        System.out.println("The initial graph:");
        graph.printGraph();
        System.out.println("The weight of edge (1, 3): " + graph.getWeight(3, 1));

        graph.addVertex(5);
        graph.addEdge(1, 5, 10);
        System.out.println("The graph after adding a vertex and an edge");
        graph.printGraph();

        System.out.println("Number of vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of edges: " + graph.getNumberOfEdges());
        System.out.println("Degree of vertex 1: " + graph.getDegreeOfVertex(1));

        int source = 0;
        int destination = 2;
        System.out.println("Is edge between " + source + " and " + destination + "? " + graph.isValidEdge(source, destination));

        graph.deleteEdge(source, destination);
        System.out.println("After deleting edge (" + source + ", " + destination + "):");
        graph.printGraph();

        int vertexToDelete = 5;
        System.out.println("Is vertex " + vertexToDelete + "? " + graph.isValidVertex(vertexToDelete));

        graph.deleteVertex(vertexToDelete);
        System.out.println("After deleting vertex " + vertexToDelete + ":");
        graph.printGraph();
    }
}
