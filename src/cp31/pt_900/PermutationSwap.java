package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PermutationSwap {
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
            int a=0;
            for(int i=0;i<n;i++){
                a=gcd(a,Math.abs(arr[i]-i-1));
            }
            out.println(a);
        }
        out.flush();
    }
    public static int gcd(int a,int b){
        while(b>0){
            int t=a;
            a=b;
            b=t%b;
        }
        return a;
    }
}
