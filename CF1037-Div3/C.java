import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) {
        FastScanner fs = new FastScanner();
        // PrintWriter out = new PrintWriter(System.out);
        int t = fs.nextInt();
        while(t>0){
            int n = fs.nextInt();
            int k = fs.nextInt();
            int[] arr = fs.readArray(n);
            List<Integer> lst = new ArrayList<>();
            for(int a: arr) lst.add(a);
            Collections.sort(lst);
            String ans = "YES";
            int waterHeight = 1;
            int prev = arr[k-1];
            for(int i=0; i<n; i++){
                if(lst.get(i)<=arr[k-1])
                    continue;
                int availableTime = prev - waterHeight + 1;
                int nextHeightTime = lst.get(i) - prev;
                if(availableTime >= nextHeightTime){
                    prev = lst.get(i);
                    waterHeight += nextHeightTime;
                }else{
                   ans = "No";
                   break;
                }
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
