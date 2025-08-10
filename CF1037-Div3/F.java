import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class F{
    public static void dfs(int node, int par, ArrayList<int[]>[] adj, int[] parent, int[] cost){
        parent[node] = par;
        for(int[] a: adj[node]){
            int it = a[0], w = a[1];
            if(it != par){
                cost[it] = w;
                dfs(it, node, adj, parent, cost);
            }
        }
    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int q = fs.nextInt();
            int[] color = fs.readArray(n);
            ArrayList<int[]>[] adj = new ArrayList[n];
            Map<Integer, Long>[] childColor = new HashMap[n];
            for(int i=0; i<n; i++){
                adj[i] = new ArrayList<>();
                childColor[i] = new HashMap<>();
            }

            long ans = 0;
            for(int i=0; i<n-1; i++){
                int a = fs.nextInt()-1;
                int b = fs.nextInt()-1;
                int w = fs.nextInt();
                adj[a].add(new int[]{b, w});
                adj[b].add(new int[]{a, w});
                if(color[a] != color[b]) ans += w;
            }

            int[] parent = new int[n];
            int[] cost = new int[n];

            dfs(0, 0, adj, parent, cost);

            // Build a map for the child nodes {color : total cost}
            for(int v=1; v<n; v++){
                long prevCost = childColor[parent[v]].getOrDefault(color[v], (long)0);
                childColor[parent[v]].put(color[v], prevCost+cost[v]);
            }


            for(int i=0; i<q; i++){
                int v = fs.nextInt()-1;
                int x = fs.nextInt();
                int prevColor = color[v];
                ans += childColor[v].getOrDefault(prevColor, (long)0);
                ans -= childColor[v].getOrDefault(x,(long)0);
                if(v != 0){
                    int par = parent[v];
                    if(color[par] != color[v]) 
                        ans -= (long)cost[v];
                    childColor[par].put(color[v], childColor[par].getOrDefault(color[v], (long)0) - cost[v]);
                    color[v] = x;
                    if(color[par] != color[v]) 
                        ans += (long)cost[v];
                    childColor[par].put(color[v], childColor[par].getOrDefault(color[v], (long)0) + cost[v]);
                } else
                    color[v] = x;
                
                out.println(ans);
            }

            
            t--;
        }
        out.flush();
        
    }
    static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}
}
