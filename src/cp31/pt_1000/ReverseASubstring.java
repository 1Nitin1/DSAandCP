package cp31.pt_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReverseASubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int[][] arr = new int[26][2];
        int i=1;
        for(int a : s.toCharArray()){
            arr[a-97][1]= i;
            if(arr[a-97][0]==0){
                arr[a-97][0]= i;
            }
            i++;
        }
        boolean found=false;
        outerloop:
        for(int j=25;j>0;j--){
            if(arr[j][0]==0){
                continue;
            }else{
                int a = arr[j][0];
                for(int k=j-1;k>=0;k--){
                    if(arr[k][1]>a){
                        out.println("Yes");
                        out.println(a+" "+arr[k][1]);
                        found=true;
                        break outerloop;
                    }
                }
            }
        }
        if(!found){
            out.println("no");
        }
        out.flush();

    }
}
