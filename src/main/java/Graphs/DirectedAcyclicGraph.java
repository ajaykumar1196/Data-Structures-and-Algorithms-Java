package Graphs;

import java.util.Arrays;
import java.util.List;

public class DirectedAcyclicGraph {

    private static int DFS(Graph graph, int u, boolean[] discovered, int[] departureTime, int time){
        discovered[u] = true;
        ++time; // Arrival Time
        for(int v : graph.getAdjList().get(u)){
            if(!discovered[v]){
                time = DFS(graph, v, discovered, departureTime, time);
            }
        }
        departureTime[u] = ++time;

        return time;
    }

    private static boolean isDAG(Graph graph, int n) {
        boolean[] discovered = new boolean[n];
        int[] departure = new int[n];
        int time = -1;
        for(int i = 0; i < n; i++){
            if(!discovered[i]){
                time = DFS(graph, i, discovered, departure, time);
            }
        }

        for(int u = 0; u < n; u++){
            for(int v : graph.getAdjList().get(u)){
                if(departure[u] <= departure[v]) {
                    return false;
                }
            }
        }

        return true;

    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 3), new Edge(1, 2),
                new Edge(1, 3), new Edge(3, 2), new Edge(3, 4),
                new Edge(3, 0), new Edge(5, 6), new Edge(6, 3)
        );



        // total number of nodes in the graph
        final int N = 7;

        // build a graph from the given edges
        Graph graph = new Graph(edges, N, true);

        // check if the given directed graph is DAG or not
        if (isDAG(graph, N)) {
            System.out.println("The graph is a DAG");
        } else {
            System.out.println("The graph is not a DAG");
        }
    }


}
