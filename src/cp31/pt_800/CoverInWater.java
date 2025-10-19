package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class CoverInWater {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            int ans = 0;
            int num = 0;
            int max = 0;

            for(char a : s.toCharArray()){
                if(a=='#'){
                    max=Math.max(max,num);
                    ans+=num;
                    num=0;
                }else{
                    num++;
                }
            }
            max=Math.max(max,num);
            ans+=num;
            if(max>2){
                out.println(2);
            }else{
                out.println(ans);
            }
        }
        out.flush();
    }
}
