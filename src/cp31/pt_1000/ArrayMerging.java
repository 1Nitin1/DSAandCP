import java.io.*;
import java.util.*;
public class ArrayMerging {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            int[] b = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) a[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) b[i] = Integer.parseInt(st.nextToken());
            HashMap<Integer,Integer> ma = new HashMap<>();
            HashMap<Integer,Integer> mb = new HashMap<>();
            int cnt = 1;
            for(int i=1;i<=n;i++){
                if(i<n && a[i]==a[i-1]) cnt++;
                else{
                    ma.put(a[i-1],Math.max(ma.getOrDefault(a[i-1],0),cnt));
                    cnt=1;
                }
            }
            cnt=1;
            for(int i=1;i<=n;i++){
                if(i<n && b[i]==b[i-1]) cnt++;
                else{
                    mb.put(b[i-1],Math.max(mb.getOrDefault(b[i-1],0),cnt));
                    cnt=1;
                }
            }
            int ans=0;
            for(int x:ma.keySet()){
                ans=Math.max(ans,ma.get(x)+mb.getOrDefault(x,0));
            }
            for(int x:mb.keySet()){
                ans=Math.max(ans,mb.get(x)+ma.getOrDefault(x,0));
            }
            out.println(ans);
        }
        out.flush();
    }
}
