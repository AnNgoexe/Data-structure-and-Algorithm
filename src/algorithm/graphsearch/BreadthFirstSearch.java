package algorithm.graphsearch;

import datastructure.unweighedgraph.undirectedgraph.AdjacencyList;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {
    public static void bfs(AdjacencyList graph, int startVertex) {
        if (!graph.isValidVertex(startVertex)) {
            System.out.println("Invalid starting vertex.");
            return;
        }
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startVertex);
        visited.add(startVertex);
        System.out.println("Breadth-First Search starting from vertex " + startVertex + ":");

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : graph.getVertexNeighbors(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        System.out.println();
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

        bfs(graph, 1);
    }
}
