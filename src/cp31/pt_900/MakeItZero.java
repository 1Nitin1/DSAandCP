package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MakeItZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[n];
            int[][] ans = new int[9][2];
            boolean isZero=true;
            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
                if(arr[i]!=0){
                    isZero=false;
                }
            }
            int k=0;
            if(isZero){
                out.println(k);
                continue;
            }
            if(n%2==0){
                out.println(2);
                out.println(1+" "+n);
                out.println(1+" "+n);
            }else{
                out.println(4);
                out.println(1+" "+n);
                out.println(1+" "+2);
                out.println(2+" "+n);
                out.println(2+" "+n);
            }


        }
        out.flush();
    }
}
