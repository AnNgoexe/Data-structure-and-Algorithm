package algorithm.minspanningtree;

import datastructure.weighedgraph.WeighedEdge;
import datastructure.weighedgraph.undirectedgraph.AdjacencyList;

import java.awt.desktop.SystemSleepEvent;
import java.util.*;

public class PrimAlgorithm {
    public static List<WeighedEdge> findMinimumSpanningTree(AdjacencyList graph) {
        List<WeighedEdge> minimumSpanningTree = new ArrayList<>();
        Set<Integer> visitedVertices = new HashSet<>();
        PriorityQueue<WeighedEdge> minHeap = new PriorityQueue<>(Comparator.comparingInt(WeighedEdge::getWeight));

        int startVertex = 0;
        visitedVertices.add(startVertex);

        minHeap.addAll(graph.getEdgeNeighbors(startVertex));
        while (visitedVertices.size() < graph.getNumberOfVertices()) {
            WeighedEdge currentEdge = minHeap.poll();
            int nextVertex = currentEdge.getDestination();
            if (!visitedVertices.contains(nextVertex)) {
                visitedVertices.add(nextVertex);
                minimumSpanningTree.add(currentEdge);
                minHeap.addAll(graph.getEdgeNeighbors(nextVertex));
            }
        }
        return minimumSpanningTree;
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();
        for(int i = 0; i < 9; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(7, 6, 1);
        graph.addEdge(8, 2, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(0, 1, 4);
        graph.addEdge(2, 5, 4);
        graph.addEdge(8, 6, 6);
        graph.addEdge(2, 3, 7);
        graph.addEdge(7, 8, 7);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(3, 4, 9);
        graph.addEdge(5, 4, 10);
        graph.addEdge(1, 7, 11);
        graph.addEdge(3, 5, 14);

        graph.printGraph();

        System.out.println("Minimum Spanning Tree:");
        List<WeighedEdge> minimumSpanningTree = findMinimumSpanningTree(graph);
        for (WeighedEdge edge : minimumSpanningTree) {
            System.out.println(edge);
        }
    }
}
