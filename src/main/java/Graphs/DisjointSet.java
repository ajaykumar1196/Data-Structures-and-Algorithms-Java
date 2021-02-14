package Graphs;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    private Map<Integer, Integer> parent = new HashMap<>();
    private Map<Integer, Integer> rank = new HashMap<>();

    public void makeSet(int[] universe){
        for(int vertex : universe){
            parent.put(vertex, vertex);
            rank.put(vertex, 0);
        }
    }

    public int find(int vertex){
        // Using path compression
        if(parent.get(vertex) != vertex){
            parent.put(vertex, find(parent.get(vertex)));
        }
        return parent.get(vertex);
    }

    public void union(int a, int b){
        // Using union by rank
        int x = find(a);
        int y = find(b);

        if (x == y){
            return;
        }

        if(rank.get(x) > rank.get(y)){
            parent.put(y, x);
        }else if(rank.get(x) < rank.get(y)){
            parent.put(x, y);
        }else {
            parent.put(x, y);
            rank.put(y, rank.get(y) + 1);
        }
    }

    public Map<Integer, Integer> getParent() {
        return parent;
    }

    public Map<Integer, Integer> getRank() {
        return rank;
    }

    public static void printSets(int[] universe, DisjointSet ds)
    {
        for (int i: universe) {
            System.out.print(ds.find(i) + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] universe = { 1, 2, 3, 4, 5 };

        DisjointSet ds = new DisjointSet();

        // create a singleton set for each element of the universe
        ds.makeSet(universe);
        printSets(universe, ds);

        ds.union(4, 3); // 4 and 3 are in the same set
        printSets(universe, ds);

        ds.union(2, 1); // 1 and 2 are in the same set
        printSets(universe, ds);

        ds.union(1, 3); // 1, 2, 3, 4 are in the same set
        printSets(universe, ds);

        ds.union(5, 3); // 1, 2, 3, 4 are in the same set
        printSets(universe, ds);

    }
}
