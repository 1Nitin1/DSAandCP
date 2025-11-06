package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NotDividing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            long n = Long.parseLong(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            long[] arr = new long[(int)n];
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            if(arr[0]==1){
                arr[0]++;
            }
            for(int i=1;i<n;i++){
                if(arr[i]==1){
                    arr[i]++;
                }
                if(arr[i]%arr[i-1]==0){
                    arr[i]++;
                }
            }
            for(long a : arr){
                out.print(a+" ");
            }
            out.println();
        }
        out.flush();
    }
}
