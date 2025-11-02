package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThreeIndices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        outerloop:
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            for(int i=1;i<arr.length-1;i++){
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                    out.println("Yes");
                    out.println(i+" "+(i+1)+" "+(i+2));
                    continue outerloop;
                }
            }
            out.println("No");
        }
        out.flush();
    }
}
