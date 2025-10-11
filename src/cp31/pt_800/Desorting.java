package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Desorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int min = Integer.MAX_VALUE;
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for(int i=0;i<n-1;i++){
                int b = Integer.parseInt(st.nextToken());
                min=Math.min(min,b-a);
                a=b;
            }
            if(min<0){
                out.println(0);
            }else{
                out.println(min/2+1);
            }
        }
        out.flush();
    }
}
