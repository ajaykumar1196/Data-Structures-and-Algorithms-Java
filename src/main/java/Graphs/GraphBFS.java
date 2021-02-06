package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class GraphBFS {
    public static void BFSRecursive(Graph graph, Queue<Integer> queue, boolean[] discovered){
        if(queue.isEmpty()){
            return;
        }

        int current =  queue.poll();
        System.out.print(current + "-->");
        for(int vertex : graph.getAdjList().get(current)){
            if(!discovered[vertex]){
                discovered[vertex] = true;
                queue.add(vertex);
            }
        }

        BFSRecursive(graph, queue, discovered);
    }

    public static void BFS(Graph graph, int vertex, boolean[] discovered){

        Queue<Integer> queue = new ArrayDeque<>();

        discovered[vertex] = true;
        queue.add(vertex);
        while(!queue.isEmpty()){
            Integer current = queue.poll();
            System.out.print(current + "-->");
            for (int v: graph.getAdjList().get(current)){
                if (!discovered[v]){
                    discovered[v] = true;
                    queue.add(v);
                }
            }
        }

    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                new Edge(7, 11), new Edge(7, 12)
                // vertex 0, 13, and 14 are single nodes
        );

        final int N = 15;
        boolean[] discovered = new boolean[N];
        Graph graph = new Graph(edges, N);

        // Iterative Approach
        for(int i = 0; i < N; i++){
            if(!discovered[i]){
                BFS(graph, i, discovered);
            }
        }

        // Recursive Approach
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            if(!discovered[i]){
                queue.add(i);
                discovered[i] = true;
                BFSRecursive(graph, queue, discovered);
            }
        }

    }
}
