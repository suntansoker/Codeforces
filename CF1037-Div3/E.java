import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {
    public static long gcd(long a, long b){
        if(a % b == 0)
            return b;
        return gcd(b, a%b);
    }
    public static int solve(int n, int[] pref, int[] suff){
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            arr[i] = (long)(pref[i] * suff[i]) / gcd(pref[i], suff[i]);
        }

        long[] arr2 = new long[n];
        for(int i=0; i<n; i++)
            arr2[i] = arr[i];

        long g = arr[0];
        for(int i=0; i<n; i++){
            g = gcd(g, arr[i]);
            if(g != pref[i])
                return 0;
        }

        long g2 = arr[n-1];
        for(int i=n-1; i>=0; i--){
            g2 = gcd(g2, arr2[i]);
            if(g2 != suff[i])
                return 0;
        }

        return 1;
    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int[] pref = fs.readArray(n);
            int[] suff = fs.readArray(n);

            int ans = solve(n, pref, suff);
            if(ans==1)
                out.println("YES");
            else
                out.println("NO");
            
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
