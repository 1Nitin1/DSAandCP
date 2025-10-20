package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LongestDivisorsInterval {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            Long n = Long.parseLong(br.readLine());
            int ans=0;
            for(int i=1;i<300;i++){
                if(n%i==0){
                    ans++;
                }else{
                    break;
                }
            }
            out.println(ans);
        }
        out.flush();
    }
}
