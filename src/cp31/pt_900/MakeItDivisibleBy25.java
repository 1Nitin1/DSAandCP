package cp31.pt_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MakeItDivisibleBy25 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            Long n = Long.parseLong(br.readLine());
            int ans = 20;
            int a00 = 0;
            boolean a00a=false;
            long num=n;
            int i=0;
            while(num!=0){
                int k = (int) (num%10);
                num/=10;
                if(a00==0 && k==0){
                    a00++;
                }else if(a00==1 && k==0){
                    a00a=true;
                    a00=i;
                    break;
                }
                i++;
            }
            if(a00a){
                ans=Math.min(ans,a00-1);
            }
            int a25 = 0;
            boolean a25a=false;
            num=n;
            i=0;
            while(num!=0){
                int k = (int) (num%10);
                num/=10;
                if(a25==0 && k==5){
                    a25++;
                }else if(a25==1 && k==2){
                    a25a=true;
                    a25=i;
                    break;
                }
                i++;
            }
            if(a25a){
                ans=Math.min(ans,a25-1);
            }
            int a50 = 0;
            boolean a50a=false;
            num=n;
            i=0;
            while(num!=0){
                int k = (int) (num%10);
                num/=10;
                if(a50==0 && k==0){
                    a50++;
                }else if(a50==1 && k==5){
                    a50a=true;
                    a50=i;
                    break;
                }
                i++;
            }
            if(a50a){
                ans=Math.min(ans,a50-1);
            }
            int a75 = 0;
            boolean a75a=false;
            num=n;
            i=0;
            while(num!=0){
                int k = (int) (num%10);
                num/=10;
                if(a75==0 && k==5){
                    a75++;
                }else if(a75==1 && k==7){
                    a75a=true;
                    a75=i;
                    break;
                }
                i++;
            }
            if(a75a){
                ans=Math.min(ans,a75-1);
            }

            out.println(ans);
        }
        out.flush();
    }

}
