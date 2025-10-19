package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GrasshopperOnALine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(x%k!=0){
                out.println(1);
                out.println(x);
            }else{
                out.println(2);
                out.print(x-1);
                out.print(" ");
                out.println(1);
            }

        }
        out.flush();
    }
}
