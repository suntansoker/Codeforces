import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static int solve(int[][] arr, int n, int k){
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        // int max = 0;
        for(int i=0; i<n; i++){
            if(k>=arr[i][0] && k<=arr[i][1])
                k = Math.max(k, arr[i][2]);
                // k = max;
        }

        return k;
    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        // PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[][] arr = new int[n][];
            for(int i=0; i<n; i++){
                arr[i] = fs.readArray(3);
            }
            System.out.println(solve(arr, n, k));
            
            t--;
        }
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
