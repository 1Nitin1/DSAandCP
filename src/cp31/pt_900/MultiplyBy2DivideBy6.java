package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MultiplyBy2DivideBy6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int d2=0;
            int d3=0;
            while(n%2==0){
                d2++;
                n/=2;
            }
            while(n%3==0){
                d3++;
                n/=3;
            }
            if(n>1 || d2>d3){
                out.println(-1);
            }else{
                out.println(d2+(d3-d2)*2);
            }
        }
        out.flush();
    }
}
