package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WeNeedTheZero {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xor=0;
            for(int i=0;i<n;i++){
                xor^=Integer.parseInt(st.nextToken());
            }
            if(xor==0){
                out.println(0);
            }else if(xor>0 && n%2==1){
                out.println(xor);
            }else{
                out.println(-1);
            }
        }
        out.flush();
    }
}
