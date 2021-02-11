package Graphs;

import java.util.Arrays;
import java.util.List;

public class TopologicalSort {

    private static int DFS(Graph graph, int vertex, boolean[] discovered, int[] departure, int time) {
        discovered[vertex] = true;
        ++time;

        for(int i : graph.getAdjList().get(vertex)){
            if(!discovered[i]){
                time = DFS(graph, i, discovered, departure, time);
            }
        }
        departure[++time] = vertex;

        return time;
    }

    private static void topologicalSort(Graph graph, int n) {
        boolean[] discovered = new boolean[n];
        int[] departure = new int[2 * n];

        Arrays.fill(departure, -1);

        int time = -1;

        for(int i = 0; i < n; i++){
            if(!discovered[i]){
                time = DFS(graph, i, discovered, departure, time);
            }
        }

        for (int i = 2*n - 1; i >= 0; i--) {
            if (departure[i] != -1) {
                System.out.print(departure[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );

        final int N = 8;

        Graph graph = new Graph(edges, N, true);

        topologicalSort(graph, N);
    }


}
