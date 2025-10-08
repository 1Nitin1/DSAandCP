package cp31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AmbitiousKid {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        StringTokenizer s = new StringTokenizer(br.readLine());
        while(n-->0){
            min = Math.min(min,Math.abs(Integer.parseInt(s.nextToken())));
        }
        out.println(min);
        out.flush();
    }
}
