package Codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class OnlyOneDigit {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            int ans=9;
            while(n>0){
                int k=n%10;
                if(k<ans){
                    ans=k;
                }
                n/=10;
            }
            out.println(ans);
        }
        out.flush();
    }
}
