package algorithm.toposort;

import datastructure.unweighedgraph.directedgraph.AdjacencyList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DefinitionMethod {
    private AdjacencyList graph;

    public DefinitionMethod(AdjacencyList graph) {
        this.graph = graph;
    }

    public List<Integer> performTopologicalSort() {
        List<Integer> topologicalOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegrees = new int[graph.getNumberOfVertices()];
        for (int vertex : graph.getVertices()) {
            for (int neighbor : graph.getVertexNeighbors(vertex)) {
                inDegrees[neighbor]++;
            }
        }
        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            topologicalOrder.add(currentVertex);
            for (int neighbor : graph.getVertexNeighbors(currentVertex)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (topologicalOrder.size() != graph.getNumberOfVertices()) {
            System.out.println("Graph contains a cycle. Topological sort not possible.");
            return new ArrayList<>();
        }
        return topologicalOrder;
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();
        for (int i = 0; i <= 4; i++) {
            graph.addVertex(i);
        }
        graph.addEdge(0, 1);
        graph.addEdge(2, 0);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        DefinitionMethod topologicalSort = new DefinitionMethod(graph);
        List<Integer> result = topologicalSort.performTopologicalSort();

        System.out.println("Topological Sort Order: " + result);
    }
}
