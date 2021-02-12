package Graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


class NodeWithDepth
{
    int v, depth;

    NodeWithDepth(int v, int depth) {
        this.v = v;
        this.depth = depth;
    }
}

public class GraphPath {

    private static int modifiedBFS(Graph graph, int src, int dest, int m) {
        Queue<NodeWithDepth> queue = new ArrayDeque<>();
        queue.add(new NodeWithDepth(src, 0));
        int count = 0;
        while (!queue.isEmpty()){
            NodeWithDepth node = queue.poll();

            if(node.depth == m && dest == node.v){
                count++;
            }

            if(node.depth > m){
                break;
            }

            for(int v : graph.getAdjList().get(node.v)){
                queue.add(new NodeWithDepth(v, node.depth + 1));
            }
        }

        return  count;

    }

    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 6), new Edge(0, 1), new Edge(1, 6),
                new Edge(1, 5), new Edge(1, 2), new Edge(2, 3),
                new Edge(3, 4), new Edge(5, 2), new Edge(5, 3),
                new Edge(5, 4), new Edge(6, 5), new Edge(7, 6),
                new Edge(7, 1)
        );

        final int N = 8;

        Graph g = new Graph(edges, N, true);

        int src = 0, dest = 3, m = 4;

        // Do modified BFS traversal from the source vertex src
        System.out.println(modifiedBFS(g, src, dest, m));
    }
}
