import java.lang.*;
import java.util.*;
import java.io.*;
public class shortestPathBFS {
    public static void addEdge (ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    public static void printGraph (ArrayList<ArrayList<Integer>> adj) {
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
    public static void bfsAlgo(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visted,int[] dist){
        Queue<Integer> q = new LinkedList<Integer>();
        visted[s] = true;
        q.add(s);
        while(q.isEmpty() == false){
            int temp = q.poll();
            //System.out.print(temp+" ");
            for(int x: adj.get(temp)){
                if(visted[x] == false){
                    dist[x] = dist[temp] + 1;
                    visted[x] = true;
                    q.add(x);
                }
            }
        }
        
    }
    public static void bfsAlgoMain(ArrayList<ArrayList<Integer>> adj){
        boolean[] visted = new boolean[adj.size()+1];
        int[] dist = new int[adj.size()+1];
        for(int i=0;i<adj.size();i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0] = 0;
        for(int i=0;i<adj.size();i++){
            if(visted[i] == false){
                bfsAlgo(adj,i,visted,dist);
            }
        }
        System.out.println("\nShortest Path from source : [0]");
        for(int i=0;i<adj.size();i++){
            System.out.print(dist[i]+" ");
        }
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
        System.out.println("BFS Algo : ");
        //System.out.println(bfsAlgoMain(arr));
        bfsAlgoMain(arr);
    }
}