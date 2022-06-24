// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int S = Integer.parseInt(read.readLine());

            Dijkstra ob = new Dijkstra();

            int[] ptr = ob.dijkstra(V, adj, S);

            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Dijkstra
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static ArrayList<ArrayList<ArrayList<Integer>>> r_adj;
    static boolean[] visited;
    static int[] ret_arr;
    public static Comparator<ArrayList<Integer>> comp = Comparator.comparing(o -> o.get(1));
    public static void make_sol(int S) {
        PriorityQueue<ArrayList<Integer>> queue = new PriorityQueue<>(comp);
        for (ArrayList<Integer> elem : r_adj.get(S)) {
            queue.add(elem);
            ret_arr[elem.get(0)] = elem.get(1);
        }
        visited[S] = true;
        ret_arr[S] = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> edge = queue.poll();
            int vtx = edge.get(0);
            if (!visited[vtx]) {
                for (ArrayList<Integer> elem : r_adj.get(vtx)) {
                    int n_vtx = elem.get(0);
                    int dist = elem.get(1);
                    if (ret_arr[n_vtx] > ret_arr[vtx] + dist) {
                        ret_arr[n_vtx] = ret_arr[vtx] + dist;
                    }
                    if (!visited[n_vtx]) {
                        queue.add(new ArrayList<>((
                                Arrays.asList(n_vtx, ret_arr[n_vtx])
                                )));
                    }
                }
                visited[vtx] = true;
            }
        }
    }


    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        r_adj = adj;
        ret_arr = new int[V];
        Arrays.fill(ret_arr, Integer.MAX_VALUE);
        visited = new boolean[V];
        make_sol(S);
        return ret_arr;
    }
}