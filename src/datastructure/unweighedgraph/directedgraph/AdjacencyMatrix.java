package datastructure.unweighedgraph.directedgraph;

import datastructure.unweighedgraph.UnweighedGraph;
import datastructure.unweighedgraph.Edge;

import java.util.List;
import java.util.ArrayList;

public class AdjacencyMatrix implements UnweighedGraph {
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

    public int getInDegreeOfVertex(int vertex) {
        if (this.isValidVertex(vertex)) {
            int inDegree = 0;
            for (List<Integer> neighbors : this.matrix) {
                inDegree += neighbors.get(vertex);
            }
            return inDegree;
        } else {
            System.out.println("Invalid vertex.");
            return -1;
        }
    }

    public int getOutDegreeOfVertex(int vertex) {
        if (this.isValidVertex(vertex)) {
            int outDegree = 0;
            for (int neighbor : this.matrix.get(vertex)) {
                outDegree += neighbor;
            }
            return outDegree;
        } else {
            System.out.println("Invalid vertex.");
            return -1;
        }
    }

    @Override
    public int getDegreeOfVertex(int vertex) {
        if (isValidVertex(vertex)) {
            int inDegree = this.getInDegreeOfVertex(vertex);
            int outDegree = this.getOutDegreeOfVertex(vertex);
            return inDegree + outDegree;
        } else {
            System.out.println("Invalid vertex.");
            return -1;
        }
    }

    @Override
    public List<Integer> getVertexNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        if (this.isValidVertex(vertex)) {
            for (int j = 0; j < this.vertices; j++) {
                if (this.matrix.get(vertex).get(j) == 1) {
                    neighbors.add(j);
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
                && this.matrix.get(source).get(destination) == 1;
    }

    @Override
    public void addEdge(int source, int destination) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            this.matrix.get(source).set(destination, 1);
        } else {
            System.out.println("Invalid vertices. Edge not added.");
        }
    }

    @Override
    public void deleteEdge(int source, int destination) {
        if (this.isValidVertex(source) && this.isValidVertex(destination)) {
            this.matrix.get(source).set(destination, 0);
        } else {
            System.out.println("Invalid vertices. Edge not deleted.");
        }
    }

    @Override
    public int getNumberOfEdges() {
        int count = 0;
        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                if (this.matrix.get(i).get(j) == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public List<Edge> getEdgeNeighbors(int vertex) {
        List<Edge> edgeNeighbors = new ArrayList<>();
        if (isValidVertex(vertex)) {
            for (int i = 0; i < this.vertices; i++) {
                int weight = this.matrix.get(vertex).get(i);
                if (weight != 0) {
                    edgeNeighbors.add(new Edge(vertex, i));
                }
            }
        } else {
            System.out.println("Invalid vertex.");
        }
        return edgeNeighbors;
    }

    @Override
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < this.vertices; i++) {
            for (int j = 0; j < this.vertices; j++) {
                if (this.matrix.get(i).get(j) == 1) {
                    edges.add(new Edge(i, j));
                }
            }
        }
        return edges;
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
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        System.out.println("The initial graph:");
        graph.printGraph();

        graph.addVertex(5);
        graph.addEdge(1, 5);
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
