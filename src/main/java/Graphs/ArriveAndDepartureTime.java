package Graphs;

import java.util.Arrays;
import java.util.List;

public class ArriveAndDepartureTime {

    private static int DFS(Graph graph, int vertex, boolean[] discovered, int[] arriveTime, int[] departureTime, int time) {
        discovered[vertex] = true;
        arriveTime[vertex] = ++time;
        for(int v: graph.getAdjList().get(vertex)){
            if(!discovered[v]){
                time = DFS(graph, v, discovered, arriveTime, departureTime, time);
            }
        }
        departureTime[vertex] = ++time;
        return time;
    }

    public static void main(String[] args) {

        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(2, 3),
                new Edge(2, 4), new Edge(3, 1), new Edge(3, 5),
                new Edge(4, 5), new Edge(6, 7)
        );

        final int N = 8;

        Graph graph = new Graph(edges, N, true);

        int[] arriveTime = new int[N];
        int[] departureTime = new int[N];
        boolean[] discovered = new boolean[N];
        int time = -1;
        for (int i = 0; i < N; i++) {
            if (!discovered[i]) {
                time = DFS(graph, i, discovered, arriveTime, departureTime, time);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println("Vertex " + i + " Time -> (" + arriveTime[i]
                    + ", " + departureTime[i] + ")");
        }

    }
}
