package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BalancedRound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            int max=0;
            int cur=0;
            Arrays.sort(arr);
            for(int i=1;i<n;i++){
                if(arr[i]-arr[i-1]<=k){
                    cur++;
                }else{
                    max=Math.max(max,cur);
                    cur=0;
                }
            }
            if(cur>max){
                max=cur;
            }
            out.println(n-max-1);
        }
        out.flush();
    }
}
