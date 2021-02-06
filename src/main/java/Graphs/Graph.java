package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Edge{
    int src, dest;

    Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
    }
}

public class Graph{
    private List<List<Integer>> adjList;

    Graph(List<Edge> edges, int N, boolean isDirected){
        adjList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            adjList.add(i, new ArrayList<>());
        }

        for(Edge edge: edges){
            adjList.get(edge.src).add(edge.dest);
            if(!isDirected){
                adjList.get(edge.dest).add(edge.src);
            }

        }
    }

    Graph(List<Edge> edges, int N){
        this(edges, N, false);
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }

    public void printGraph(){
        int src = 0;
        int n = this.adjList.size();

        while (src < n)
        {
            for (int dest: this.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }

    public static void main (String[] args)
    {
        // Input: List of edges in a digraph (as per the above diagram)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1),new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));

        // construct a graph from the given list of edges
        Graph graph = new Graph(edges, 6);

        // print adjacency list representation of the graph
        graph.printGraph();
    }
}