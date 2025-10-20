package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class VasilijeInCacak {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Long n = Long.parseLong(st.nextToken());
            Long k = Long.parseLong(st.nextToken());
            Long x = Long.parseLong(st.nextToken());
            long min=(k*(k+1))/2;
            long max=(k*(n+n-k+1))/2;
            if(x>=min && x<=max){
                out.println("Yes");
            }else{
                out.println("No");
            }
        }
        out.flush();
    }
}
