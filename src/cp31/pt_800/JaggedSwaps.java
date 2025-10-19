package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JaggedSwaps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int min=Integer.parseInt(st.nextToken());
            int a = min;
            while(n-->1){
                min=Math.min(min,Integer.parseInt(st.nextToken()));
            }
            if(min==a){
                out.println("yes");
            }else{
                out.println("no");
            }
        }
        out.flush();
    }
}
