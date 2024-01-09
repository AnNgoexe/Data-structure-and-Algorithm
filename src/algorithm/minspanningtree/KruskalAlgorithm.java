package algorithm.minspanningtree;

import datastructure.weighedgraph.WeighedEdge;
import datastructure.weighedgraph.undirectedgraph.EdgeList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    public static List<WeighedEdge> findMinimumSpanningTree(EdgeList graph) {
        List<WeighedEdge> minimumSpanningTree = new ArrayList<>();
        List<WeighedEdge> allEdges = graph.getEdges();

        Collections.sort(allEdges);
        DisjointSetUnion disjointSet = new DisjointSetUnion(graph.getNumberOfVertices());
        for (WeighedEdge edge : allEdges) {
            int sourceParent = disjointSet.find(edge.getSource());
            int destinationParent = disjointSet.find(edge.getDestination());
            if (sourceParent != destinationParent) {
                minimumSpanningTree.add(edge);
                disjointSet.unite(sourceParent, destinationParent);
            }
        }
        return minimumSpanningTree;
    }

    public static void main(String[] args) {
        EdgeList graph = new EdgeList();
        System.out.println("Graph:");
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

        List<WeighedEdge> minimumSpanningTree = findMinimumSpanningTree(graph);
        System.out.println("\nMinimum Spanning Tree:");
        for (WeighedEdge edge : minimumSpanningTree) {
            System.out.println(edge.toString());
        }
    }
}
