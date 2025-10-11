package cp31.pt_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class DoremysPoint3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int l = n;
            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer,Integer> map = new HashMap<>();
            while(l-->0){
                int num = Integer.parseInt(st.nextToken());
                map.put(num,map.getOrDefault(num,0)+1);
            }
            boolean done=false;
            if(map.size()==1) {
                out.println("yes");
                done=true;
            }else if(map.size()>2){
                out.println("no");
                done=true;
            }else if(map.size()==2) {
                int a = n / 2;
                for (int b : map.keySet()) {
                    if (map.get(b) == a) {
                        out.println("yes");
                        done=true;
                        break;
                    } else if (map.get(b)==a+1 && n%2==1) {
                        out.println("yes");
                        done=true;
                        break;
                    }
                }
            }
            if(!done){
                out.println("no");
            }
        }
        out.flush();
    }
}
