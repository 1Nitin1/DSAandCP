package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OddGrasshopper {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            int k = (int) (n%4);
            if(x%2==0){
                if(k==0){
                    out.println(x);
                }else if(k==1){
                    out.println(x-n);
                }else if(k==2){
                    out.println(x+1);
                }else{
                    out.println(x+n+1);
                }
            }else{
                if(k==0){
                    out.println(x);
                }else if(k==1){
                    out.println(x+n);
                }else if(k==2){
                    out.println(x-1);
                }else{
                    out.println(x-n-1);
                }
            }
        }
        out.flush();
    }
}
