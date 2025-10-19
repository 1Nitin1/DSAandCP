package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DontTryToCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            StringBuilder str = new StringBuilder(br.readLine());
            String s = br.readLine();
            int ans= 0;
            while(!str.toString().contains(s)){

                if(str.length()>2*s.length() && ans>0){
                    ans=-1;
                    break;
                }
                str.append(str);
                ans++;
            }
            out.println(ans);
        }
        out.flush();
    }
}
