package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class LineTrip {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int ans = 2;
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int x = Integer.parseInt(st1.nextToken());
            int[] arr = new int[n];
            arr[0]=Integer.parseInt(st2.nextToken());
            ans=Math.max(ans,arr[0]);
            for(int i=1;i<n;i++){

                arr[i]=Integer.parseInt(st2.nextToken());
                ans=Math.max(ans,arr[i]-arr[i-1]);
            }
            ans=Math.max(ans,2*(x-arr[n-1]));
            out.println(ans);
        }
        out.flush();
    }
}
