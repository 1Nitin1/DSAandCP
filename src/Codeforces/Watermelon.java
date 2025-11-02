package Codeforces;

import java.util.Scanner;

public class Watermelon{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if(input==2 || input%2==1){
            System.out.print("no");
        }else{
            System.out.print("yes");
        }
    }
}
