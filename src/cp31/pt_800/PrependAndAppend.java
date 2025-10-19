package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class PrependAndAppend {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            int b = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int a = 0;
            for(int i=0;i<b/2;i++){
                if((s.charAt(i)=='1' && s.charAt(b-1-i)=='0') ||
                        (s.charAt(i)=='0' && s.charAt(b-1-i)=='1')){
                    a+=2;
                }else{
                    break;
                }
            }
            out.println(b-a);

        }
        out.flush();
    }
}
