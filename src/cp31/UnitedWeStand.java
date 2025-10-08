package cp31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnitedWeStand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int min =Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                if(arr[i]<min){
                    min=arr[i];
                }
            }
            int ctmin=0;
            for(int a:arr){
                if(a==min){
                    ctmin++;
                }
            }
            if(ctmin==n){
                out.println(-1);
                continue;
            }
            out.println(ctmin+" "+(n-ctmin));
            for(int i=0;i<ctmin;i++){
                out.print(min);
                if(i<ctmin-1){
                    out.print(" ");
                }
            }
            out.println();
            for(int i=0;i<n;i++){
                if(arr[i]!=min){
                    out.print(arr[i]);
                    if(i<n-1){
                        out.print(" ");
                    }
                }

            }
            out.println();

        }
        out.flush();
    }
}
