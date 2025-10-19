import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Forked {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> setx = new HashSet<>();
            Set<Integer> sety = new HashSet<>();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int xk=Integer.parseInt(st.nextToken());
            int yk=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            int xq=Integer.parseInt(st.nextToken());
            int yq=Integer.parseInt(st.nextToken());
            int[] dx = {a,a,-a,-a,b,b,-b,-b};
            int[] dy = {b,-b,b,-b,a,-a,a,-a};
            int ans = 0;
            for(int i=0;i<8;i++){
                if(queen(a,b,xk+dx[i],yk+dy[i],xq,yq)){
                    
                    if(!(setx.contains(xk+dx[i]) && sety.contains(yk+dy[i]))){
                        ans++;
                        setx.add(xk+dx[i]);
                        sety.add(yk+dy[i]);

                    }
                }
            }
            out.println(ans);

        }
        out.flush();

    }
    public static boolean queen(int a,int b,int x,int y,int xq,int yq){
        if((x+a==xq || x-a==xq) && (y+b==yq || y-b==yq)){
            return true;
        }else if((y+a==yq || y-a==yq) && (x+b==xq || x-b==xq)){
            return true;
        }
        return false;
    }

}
