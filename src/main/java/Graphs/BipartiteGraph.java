package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph {

    private static boolean isBipartiteBFS(Graph graph, int vertex, int N) {

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] discovered = new boolean[N];
        int[] level = new int[N];

        discovered[vertex] = true;
        queue.add(vertex);
        level[vertex] = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int v: graph.getAdjList().get(current)){
                if(!discovered[v]){
                    queue.add(v);
                    discovered[v] = true;
                    level[v] = level[current] + 1;
                }else if(level[v] == level[current]){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(2, 3), new Edge(2, 8),
                new Edge(3, 4), new Edge(4, 6), new Edge(5, 7),
                new Edge(5, 9), new Edge(8, 9)
//                , new Edge(2, 4)
                // if we add edge `2 —> 4`, the graph becomes non-bipartite
        );

        // total number of nodes in the graph
        final int N = 10;

        // build a graph from the given edges
        Graph graph = new Graph(edges, N);
        boolean res = isBipartiteBFS(graph, 1, N);
        if(!res){
            System.out.println("The graph is not bipartite");
        }else {
            System.out.println("The graph is bipartite");
        }
    }


}
