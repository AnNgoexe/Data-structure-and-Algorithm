package algorithm.graphsearch;

import datastructure.unweighedgraph.undirectedgraph.AdjacencyList;
import java.util.HashSet;
import java.util.Set;

public class DepthFirstSearch {
    public static void dfs(AdjacencyList graph, int startVertex) {
        if (!graph.isValidVertex(startVertex)) {
            System.out.println("Invalid starting vertex.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        System.out.println("Depth-First Search starting from vertex " + startVertex + ":");
        dfsRecursive(graph, startVertex, visited);
        System.out.println();
    }

    private static void dfsRecursive(AdjacencyList graph, int currentVertex, Set<Integer> visited) {
        System.out.print(currentVertex + " ");
        visited.add(currentVertex);

        for (int neighbor : graph.getVertexNeighbors(currentVertex)) {
            if (!visited.contains(neighbor)) {
                dfsRecursive(graph, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();
        for (int i = 1; i <= 6; i++) {
            graph.addVertex(i);
        }

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(1, 6);

        dfs(graph, 1);
    }
}
