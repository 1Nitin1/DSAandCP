package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class ExtremelyRound {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            Deque<Integer> q = new ArrayDeque<>();
            int n = Integer.parseInt(br.readLine());
            for(int i=1;i<10;i++){
                q.add(i);
            }
            int ans = 0;
            while(q.peek()<=n){
                ans++;
                q.add(q.poll()*10);
            }
            out.println(ans);
        }
        out.flush();
    }
}
