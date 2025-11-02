package cp31.pt_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MEXorMixup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int xor=0;
            int n = (a-1)%4;
            if(a==1){
                xor=0;
            }else if(n==0){
                xor=a-1;
            }else if(n==1){
                xor=1;
            }else if(n==2){
                xor=a;
            }else{
                xor=0;
            }

            if(a==b){
                if(xor==b){
                    out.println(a);
                }else if(xor==0){
                    out.println(a+2);
                }else{
                    out.println(a+1);
                }
            }else{
                if(xor==b){
                    out.println(a);
                }else if(xor==0){
                    out.println(a+1);
                }else{
                    if((xor^a)==b){
                        out.println(a+2);
                    }else{
                        out.println(a+1);
                    }
                }
            }
        }
        out.flush();
    }
}
