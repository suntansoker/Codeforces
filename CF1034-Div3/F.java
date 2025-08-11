import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F {
    public static int largestDivisor(int n){
        int i=1;
        int ans = 1;
        while(i*i<=n){
            if(n % i == 0){
                ans = n/i;
            }
            i++;
        }

        return ans;
    }
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = i+1;
            }

            for(int i=n-1; i>=0; i--){
                int pos1 = i+1;
                int pos2 = largestDivisor(pos1);
                if(pos2 == 1)
                    continue;
                int temp = arr[i];
                arr[i] = arr[pos2-1];
                arr[pos2-1] = temp;

            }

            for(int a: arr)
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
