import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        // PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] arr = fs.readArray(n);
            List<Integer> lst= new ArrayList<>();
            lst.add(-1);
            for(int i=0; i<n; i++){
                if(arr[i] == 1){
                    lst.add(i);
                }
            }
            lst.add(n);
            int ans = 0;
            for(int i=1; i<lst.size(); i++){
                if((lst.get(i) - lst.get(i-1) >k))
                    ans+=(lst.get(i) - lst.get(i-1))/(k+1);
            }
            System.out.println(ans);
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
