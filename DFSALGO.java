import java.lang.*;
import java.util.*;
import java.io.*;
public class DFSALGO {
    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        System.out.println("Directed Graph : ");
        for (int i = 0; i < adj.size(); i++) {
    	    System.out.println("For [" + i + "] Node : \n");
    	    System.out.print("Adjacent list : ");
    	    for (int j = 0; j < adj.get(i).size(); j++) {
    	        System.out.print(adj.get(i).get(j) + " ");
    	    }
    	    System.out.println("\n");
        }
    }
    
    
    public static void dfsAlgo(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visted){
        visted[s] = true;
        System.out.print(s+" ");
        for(int x: adj.get(s)){
            if(visted[x] == false){
                visted[x] = true;
                dfsAlgo(adj,x,visted);
            }
        }
    }
    public static void dfsAlgoMain(ArrayList<ArrayList<Integer>> adj){
        boolean[] visted = new boolean[adj.size()+1];
        dfsAlgo(adj,0,visted);
    }
    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; i++) {
    	    arr.add(new ArrayList<Integer>());
        }
        addEdge(arr, 0, 1);
        addEdge(arr, 0, 2);
        addEdge(arr, 1, 2);
        addEdge(arr, 2, 3);
        printGraph(arr);
        System.out.println("DFS Algo : ");
        // System.out.println("\nTotal island : "+dfsAlgoMain(arr));
        dfsAlgoMain(arr);
    }
}
