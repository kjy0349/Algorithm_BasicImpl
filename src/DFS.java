// { Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                    new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            DFS obj = new DFS();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class DFS {
    // Function to return a list containing the DFS traversal of the graph.
    static boolean[] visited;
    static ArrayList<Integer> ret_arr;
    static ArrayList<ArrayList<Integer>> r_adj;

    public static void dfs(int vertex) {
        if (!visited[vertex]) {
            visited[vertex] = true;
            ret_arr.add(vertex);
            for (int elem : r_adj.get(vertex)) {
                dfs(elem);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        r_adj = adj;
        ret_arr = new ArrayList<>();
        dfs(0);
        return ret_arr;
    }
}