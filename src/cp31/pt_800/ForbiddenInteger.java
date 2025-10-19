package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ForbiddenInteger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(x!=1){
                out.println("YES");
                out.println(n);
                for(int i=0;i<n;i++){
                    out.print(1);
                    out.print(" ");
                }
                out.println();
            }else{
                if(k==1){
                    out.println("NO");
                }else if(k==2){
                    if(n%2==1){
                        out.println("NO");
                    }else{
                        out.println("YES");
                        out.println(n/2);
                        for(int i=0;i<n/2;i++){
                            out.print(2);
                            out.print(" ");
                        }
                        out.println();
                    }

                }else{
                    if(n%2==0){
                        out.println("YES");
                        out.println(n/2);
                        for(int i=0;i<n/2;i++){
                            out.print(2);
                            out.print(" ");
                        }
                        out.println();
                    }else{
                        out.println("YES");
                        out.println(1+(n-3)/2);
                        out.println(3);
                        for(int i=0;i<(n-3)/2;i++){
                            out.print(2);
                            out.print(" ");
                        }
                        out.println();
                    }
                }
            }
        }
        out.flush();
    }
}
