package algorithm.toposort;

import datastructure.unweighedgraph.directedgraph.AdjacencyList;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSMethod {
    private AdjacencyList graph;
    private boolean[] visited;

    public DFSMethod(AdjacencyList graph) {
        this.graph = graph;
        this.visited = new boolean[graph.getNumberOfVertices()];
    }

    public List<Integer> performTopologicalSort() {
        Stack<Integer> stack = new Stack<>();
        List<Integer> topologicalOrder = new ArrayList<>();

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            if (!visited[i]) {
                dfs(i, stack);
            }
        }
        while (!stack.isEmpty()) {
            topologicalOrder.add(stack.pop());
        }
        return topologicalOrder;
    }

    private void dfs(int vertex, Stack<Integer> stack) {
        visited[vertex] = true;

        List<Integer> neighbors = graph.getVertexNeighbors(vertex);
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(neighbor, stack);
            }
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        AdjacencyList graph = new AdjacencyList();
        for (int i = 0; i <= 5; i++) {
            graph.addVertex(i);
        }
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(3, 1);
        graph.addEdge(2, 3);

        DFSMethod dfsMethod = new DFSMethod(graph);
        List<Integer> topologicalOrder = dfsMethod.performTopologicalSort();
        System.out.println("Topological Order: " + topologicalOrder);
    }
}
