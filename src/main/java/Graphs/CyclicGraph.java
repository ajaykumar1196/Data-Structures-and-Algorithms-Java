package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class Node
{
    int v, parent;

    Node(int v, int parent) {
        this.v = v;
        this.parent = parent;
    }
}

public class CyclicGraph {

    private static boolean containsCycleBFS(Graph graph, int i, int n) {
        boolean[] discovered = new boolean[n];

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(i, -1));
        discovered[i] = true;

        while(!queue.isEmpty()){
            Node current = queue.poll();

            for(int vertex : graph.getAdjList().get(current.v)){
                if(!discovered[vertex]){
                    queue.add(new Node(vertex, current.v));
                    discovered[vertex] = true;
                }else if(vertex != current.parent){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean containsCycleDFS(Graph graph, int vertex, boolean[] discovered, int parent) {

        discovered[vertex] = true;
        for(int v: graph.getAdjList().get(vertex)){
            if(!discovered[v]){
                if(containsCycleDFS(graph, v, discovered, vertex)){
                    return true;
                }
            }else if(v != parent){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args)
    {

        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 7),
                new Edge(1, 8), new Edge(2, 3),
                new Edge(2, 6), new Edge(3, 4),
                new Edge(3, 5), new Edge(8, 9),
                new Edge(8, 12), new Edge(9, 10),
                new Edge(9, 11), new Edge(11, 12)
                // edge `11 —> 12` introduces a cycle in the graph
        );

        final int N = 13;

        Graph graph = new Graph(edges, N);
//      Uncomment the below code to check BFS approach
//      if(containsCycleBFS(graph, 1, N)){
//          System.out.println("The graph contains a cycle");
//      } else {
//          System.out.println("The graph doesn't contain any cycle");
//      }
        boolean[] discovered = new boolean[N];
        if(containsCycleDFS(graph, 1, discovered, -1)){
            System.out.println("The graph contains a cycle");
        } else {
            System.out.println("The graph doesn't contain any cycle");
        }
    }


}
