package Leetcode.Easy;

import java.util.*;

public class LCFindXSumofAllKLongSubarraysI {
    class Node implements Comparable<Node>{
        int e;
        int f;
        public int compareTo(Node a){
            if(this.f==a.f){
                return a.e-this.e;
            }else{
                return a.f-this.f;
            }
        }
        Node(int a,int b){
            e=a;
            f=b;
        }
    }
    public int[] findXSum(int[] nums, int k, int x) {
        int[] fre = new int[51];
        int[] ans=new int[nums.length-k+1];
        int a=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int m=0;
        for(int i=0;i<nums.length;i++){
            fre[nums[i]]++;
            if(i>k-1){
                fre[nums[m++]]--;
            }
            if(i>=k-1){
                for(int s=0;s<51;s++){
                    if(fre[s]>0){
                        pq.add(new Node(s,fre[s]));
                    }
                }
                int b=x;
                int sum=0;
                while(b-->0 && !pq.isEmpty()){
                    Node t = pq.poll();
                    sum+=t.e*t.f;
                }
                ans[a++]=sum;
                pq.clear();
            }

        }
        return ans;
    }
}
