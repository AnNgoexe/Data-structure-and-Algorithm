package algorithm.shortestpath;

import datastructure.weighedgraph.undirectedgraph.AdjacencyList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {
    private class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    public Map<Integer, Integer> findShortestDistances(AdjacencyList graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        for (int vertex : graph.getVertices()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);

        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();

            if (current.distance > distances.get(current.vertex)) {
                continue;
            }
            for (Integer x : graph.getVertexNeighbors(current.vertex)) {
                int newDistance = distances.get(current.vertex) + graph.getWeight(current.vertex, x);
                if (newDistance < distances.get(x)) {
                    distances.put(x, newDistance);
                    minHeap.add(new Node(x, newDistance));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList();
        for(int i = 0; i < 9; i++) {
            g.addVertex(i);
        }

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 5, 4);
        g.addEdge(2, 8, 2);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
        Map<Integer, Integer> shortestPaths = dijkstraAlgorithm.findShortestDistances(g, 0);
        System.out.println("\nShortest Distances from Vertex " + 0 + ":");
        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To Vertex " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
