package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayCloningTechnique {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int ct=1;
            int max=1;
            for(int i=0;i<n-1;i++){
                if(arr[i]==arr[i+1]){
                    max++;
                }else{
                    ct=Math.max(ct,max);
                    max=1;
                }
            }
            if(max>ct){
                ct=max;
            }
            int ans = 0;
            int a=0;
            while(ct!=n){
                a=ct;
                ans++;
                ans+=Math.min(a,n-ct);
                ct+=Math.min(a,n-ct);
            }
            out.println(ans);
        }
        out.flush();
    }
}
