package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DaytonaCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            StringTokenizer s = new StringTokenizer(br.readLine());
            boolean contains = false;
            while(n-->0){
                if(Integer.parseInt(s.nextToken())==k){
                    contains=true;
                }
            }
            if(contains){
                out.println("yes");
            }else{
                out.println("no");
            }
        }
        out.flush();
    }
}
