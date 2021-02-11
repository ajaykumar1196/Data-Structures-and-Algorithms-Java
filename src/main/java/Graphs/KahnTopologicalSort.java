package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KahnTopologicalSort {

    private static List<Integer> doTopologicalSort(Graph graph, int n) {
        int[] inDegrees = new int[n];
        for(int u = 0; u < n; u++){
            for (int v : graph.getAdjList().get(u)){
                inDegrees[v] += 1;
            }
        }

        Stack<Integer> stack = new Stack<>();
        for (int vertex = 0; vertex < n; vertex++){
            if(inDegrees[vertex] == 0){
                stack.push(vertex);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()){
            int u = stack.pop();
            result.add(u);
            for(int v: graph.getAdjList().get(u)){
                inDegrees[v] -= 1;
                if(inDegrees[v] == 0){
                    stack.push(v);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] != 0) {
                return null;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(1, 2), new Edge(1, 4),
                new Edge(1, 6), new Edge(3, 0), new Edge(3, 4),
                new Edge(5, 1), new Edge(7, 0), new Edge(7, 1)
        );

        final int N = 8;

        Graph graph = new Graph(edges, N, true);

        List<Integer> L = doTopologicalSort(graph, N);

        if (L != null) {
            System.out.print(L);    // print topological order
        } else {
            System.out.println("Graph has at least one cycle. " +
                    "Topological sorting is not possible");
        }
    }


}
