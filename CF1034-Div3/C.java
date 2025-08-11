import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

    // Cases
    // --------a----------
    // a < leftmin and a < rightmax
    // a > rightmax and a > leftmin
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int[] arr = fs.readArray(n);
            int[] minPref = new int[n];
            int[] maxSuff = new int[n];
            minPref[0] = arr[0];
            maxSuff[n-1] = arr[n-1];

            for(int i=1; i<n; i++){
                minPref[i] = Math.min(minPref[i-1], arr[i]);
                maxSuff[n-i-1] = Math.max(maxSuff[n-i], arr[n-i-1]);
            }

            StringBuilder sb = new StringBuilder();

            for(int i=0; i<n; i++){
                if(arr[i] == minPref[i] || arr[i] == maxSuff[i]){
                    sb.append(1);
                }
                else{
                    if((arr[i] < minPref[i-1] && arr[i] < maxSuff[i+1]) || 
                    (arr[i] > minPref[i-1] && arr[i] > maxSuff[i+1]))
                        sb.append(1);
                    else
                        sb.append(0);
                }
            }

            out.println(sb.toString());

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
