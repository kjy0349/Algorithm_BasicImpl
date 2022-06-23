// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
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
    static int answer;
    static boolean[] visited;
    public static void make_sol(int S, int target, int sub_sum) {
        if (S == target) answer = sub_sum;
        else {
            int min_value = 2147483647;
            int index = 0;
            ArrayList<ArrayList<Integer>> arr = r_adj.get(S);
            for (int i = 0; i < arr.size(); i++) {
                if (!visited[arr.get(i).get(0)] && arr.get(i).get(1) < min_value) {
                    min_value = arr.get(i).get(1);
                    index = arr.get(i).get(0);
                    if (arr.get(i).get(0) == target) break;
                }
            }
            visited[index] = true;
            make_sol(index, target, sub_sum + min_value);
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        r_adj = adj;
        int[] ret_arr = new int[V];
        for (int i = 0; i < ret_arr.length; i++) {
            answer = 0;
            visited = new boolean[V];
            visited[S] = true;
            make_sol(S, i, 0);
            ret_arr[i] = answer;
        }
        return ret_arr;
    }
}