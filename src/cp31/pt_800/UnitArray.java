package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UnitArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int pos=0;
            int neg=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                int a = Integer.parseInt(st.nextToken());
                if(a==-1) {
                    neg++;
                }else{
                    pos++;
                }
            }
            int ans = 0;
            if(pos<neg){
                ans+=(neg-pos+1)/2;
                pos+=ans;
                neg-=ans;
            }
            if((neg&1)==1){
                out.println(ans+1);
            }else{
                out.println(ans);
            }

        }
        out.flush();
    }
}
