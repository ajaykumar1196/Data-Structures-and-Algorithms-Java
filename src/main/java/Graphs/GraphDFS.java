package Graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GraphDFS {

    public static void DFSRecursive(Graph graph, int vertex, boolean[] discovered){
        System.out.print(vertex + "-->");
        discovered[vertex] = true;
        for(int v : graph.getAdjList().get(vertex)){
            if(!discovered[v]){
                DFSRecursive(graph, v, discovered);
            }
        }
    }

    public static void DFS(Graph graph, int vertex, boolean[] discovered){
        Stack<Integer> stack = new Stack<>();
        stack.push(vertex);
        while(!stack.isEmpty()){
            int current = stack.pop();

            if(discovered[current])
                continue;

            discovered[current] = true;
            System.out.print(current + " ");
            List<Integer> adj = graph.getAdjList().get(current);
            for(int i = adj.size() - 1; i>=0 ; i--){
                int v = adj.get(i);
                if(!discovered[v]){
                    stack.push(v);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
                new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
                new Edge(9, 10), new Edge(9, 11)
        );

        final int N = 13;
        Graph graph = new Graph(edges, N);
        boolean[] discovered = new boolean[N];

        for(int i = 0; i < N; i++){
            if(!discovered[i]){
                DFS(graph, i, discovered);
            }
        }

        for(int i = 0; i < N; i++){
            if(!discovered[i]){
                DFSRecursive(graph, i, discovered);
            }
        }

    }
}
