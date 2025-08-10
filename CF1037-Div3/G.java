import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class G {
    public static int solve(int[] arr, int n){
        int ans = 0;
        for(int med=1; med<=100; med++){
            int[] greater = new int[n];
            for(int j=0; j<n; j++){
                if(arr[j] >= med)
                    greater[j] = 1;
                else
                    greater[j] = -1;
            }
            for(int j=1; j<n; j++)
                greater[j] += greater[j-1];
            int[] prefMin = new int[n];
            int[] suffMax = new int[n];
            prefMin[0] = greater[0];
            suffMax[n-1] = greater[n-1];

            for(int i=1; i<n; i++)
                prefMin[i] = Math.min(greater[i], prefMin[i-1]);

            for(int i=n-2; i>=0; i--)
                suffMax[i] = Math.max(greater[i], suffMax[i+1]);

            for(int j=0; j<n; j++){
                if(((j-1)>=0 && prefMin[j-1]<=greater[j]) || ((j-1)>=0 && greater[j-1]<=suffMax[j]) || (suffMax[j]>=0) || (greater[j]>=0)
                || ((j-1>=0 && (j+1)<n && prefMin[j-1]<=suffMax[j+1]))){
                    ans = Math.max(ans, med - arr[j]);
                    
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int[] arr = fs.readArray(n);
            out.println(solve(arr, n));
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
