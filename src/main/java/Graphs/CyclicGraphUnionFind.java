package Graphs;

import java.util.Arrays;
import java.util.List;

public class CyclicGraphUnionFind {

    private static boolean findCycle(Graph graph, int n) {
        DisjointSet disjointSet = new DisjointSet();
        int[] universe = new int[n];
        for(int i = 1; i < n; i++){
            universe[i-1] = i;
        }
        disjointSet.makeSet(universe);

        for(int u = 1; u < n; u++){
            for(int v: graph.getAdjList().get(u)){
                int a = disjointSet.find(u);
                int b = disjointSet.find(v);
                if(a == b){
                    return true;
                }else{
                    disjointSet.union(a, b);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
                new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
                new Edge(9, 10), new Edge(9, 11)
                // edge (11, 12) introduces a cycle in the graph
        );

        // total number of nodes in the graph
        final int N = 13;

        // construct graph
        Graph graph = new Graph(edges, N,true);

        if (findCycle(graph, N)) {
            System.out.println("Cycle Found");
        }
        else {
            System.out.println("No Cycle is Found");
        }
    }


}
