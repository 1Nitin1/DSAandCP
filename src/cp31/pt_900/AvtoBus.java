package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AvtoBus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            long n = Long.parseLong(br.readLine());
            long min = 0;
            long max = 0;
            if(n<4){
                out.println(-1);
                continue;
            }
            if(n%4==0 || n%4==2){
                max=n/4;
            }else{
                max=-1;
            }
            if(n%6==0){
                min=n/6;
            }else if(n%6==4){
                min=n/6+1;
            }else if(n%6==2){
                min=n/6+1;
            }else{
                min=-1;
            }
            if(max==-1||min==-1){
                out.println(-1);
            }else{
                out.println(min+" "+max);
            }
        }
        out.flush();
    }
}
