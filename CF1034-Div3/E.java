import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class E {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int[] arr = fs.readArray(n);
            int[] ans = new int[n+1];
            TreeMap<Integer, Integer> map = new TreeMap<>();
            Map<Integer, Integer> freqMap = new HashMap<>();
            for(int i=0; i<n; i++)
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            int mex = 0;
            for(int a: map.keySet()){
                if(a==mex){
                    mex++;
                    int val = map.get(a);
                    freqMap.put(val, freqMap.getOrDefault(val, 0)+1);
                }

            }
            ans[n] = 1;
            for(int i=n-1; i>n-mex; i--){
                ans[i] = ans[i+1] + 1;
            }
            ans[0] = 1;
            for(int i=1; i<=n-mex; i++){
                // if(ans[i] != 0) break;
                ans[i] = ans[i-1] + freqMap.getOrDefault(i, 0);
            }

            for(int a: ans)
                out.print(a+" ");
            out.println();
            

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
