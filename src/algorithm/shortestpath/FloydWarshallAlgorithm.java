package algorithm.shortestpath;

import datastructure.weighedgraph.undirectedgraph.AdjacencyMatrix;

import java.util.List;

public class FloydWarshallAlgorithm {
    public int[][] findShortestDistances(AdjacencyMatrix graph) {
        int n = graph.getNumberOfVertices();
        int[][] distances = new int[n][n];

        List<List<Integer>> matrixEdges = graph.getMatrixEdges();

        for(int i = 0; i < distances.length; i++) {
            for(int j = 0; j < distances.length; j++) {
                if(i == j) {
                    distances[i][j] = 0;
                } else {
                    if(matrixEdges.get(i).get(j) != 0) {
                        distances[i][j] = matrixEdges.get(i).get(j);
                    } else {
                        distances[i][j] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][k] != Integer.MAX_VALUE && distances[k][j] != Integer.MAX_VALUE
                            && distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                    }
                }
            }
        }


        return distances;
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(9);

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

        FloydWarshallAlgorithm floydWarshallAlgorithm = new FloydWarshallAlgorithm();
        int[][] shortestDistances = floydWarshallAlgorithm.findShortestDistances(g);

        System.out.println("\nShortest Distances Matrix:");
        for (int[] shortestDistance : shortestDistances) {
            for (int i : shortestDistance) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
