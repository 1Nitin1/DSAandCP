package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Coins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            if(x%2==0){
                out.println("yes");
            }else if(x%2==1 && k%2==0){
                out.println("no");
            }else if(x%2==1 && k>x){
                out.println("no");
            }else{
                out.println("yes");
            }
        }
        out.flush();
    }
}
