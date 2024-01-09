package algorithm.shortestpath;

import datastructure.weighedgraph.WeighedEdge;
import datastructure.weighedgraph.directedgraph.EdgeList;
import java.util.HashMap;
import java.util.Map;

public class BellmanFordAlgorithm {
    public Map<Integer, Integer> findShortestDistances(EdgeList graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        int vertices = graph.getNumberOfVertices();
        for (int i = 1; i < vertices; i++) {
            for (WeighedEdge edge : graph.getEdges()) {
                int src = edge.getSource();
                int destination = edge.getDestination();
                int weight = edge.getWeight();
                if (distances.get(src) != Integer.MAX_VALUE
                        && distances.get(src) + weight < distances.get(destination)) {
                    distances.put(destination, distances.get(src) + weight);
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        EdgeList graph = new EdgeList();

        graph.addEdge(0, 1, -1);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 4, 2);
        graph.addEdge(3, 2, 5);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 3, -3);

        System.out.println("Initial Graph:");
        graph.printGraph();
        System.out.println("Number of Vertices: " + graph.getNumberOfVertices());
        System.out.println("Number of Edges: " + graph.getNumberOfEdges());

        BellmanFordAlgorithm bellmanFordAlgorithm = new BellmanFordAlgorithm();
        Map<Integer, Integer> shortestDistances = bellmanFordAlgorithm.findShortestDistances(graph, 0);

        if (shortestDistances != null) {
            System.out.println("\nShortest Distances from Vertex 0:");
            for (Map.Entry<Integer, Integer> entry : shortestDistances.entrySet()) {
                System.out.println("To Vertex " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
