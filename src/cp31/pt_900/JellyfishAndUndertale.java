package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JellyfishAndUndertale {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            int n = Integer.parseInt(st1.nextToken());
            long ans = 0;
            ans+=b-1;
            b=1;
            while(st2.hasMoreTokens()){
                ans+=Math.min(a-1,Integer.parseInt(st2.nextToken()));
            }
            out.println(++ans);
        }
        out.flush();
    }
}
