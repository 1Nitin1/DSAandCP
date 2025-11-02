package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SumOfMedians {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int k = Integer.parseInt(st1.nextToken());
            long ans =0;
            int[] arr = new int[n*k];
            for(int i=0;i<n*k;i++){
                arr[i]=Integer.parseInt(st2.nextToken());
            }
            int l = n-(n-1)/2;
            int ct=0;
            for(int i=n*k-l;i>=0;i-=l){
                ct++;
                ans+=arr[i];
                if(ct==k){
                    break;
                }
            }
            out.println(ans);
        }
        out.flush();
    }
}
