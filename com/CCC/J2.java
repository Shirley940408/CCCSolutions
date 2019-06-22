package com.CCC;
import java.util.Arrays;
import java.util.Scanner;
public class J2 {
    public static void solution(){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String sum ="";
        for(int i = 0; i < n; i++){
            String temp[] = s.nextLine().split(" ");
            int len = Integer.parseInt(temp[0]);
            for(int k = 0; k < len; k++){
                sum += temp[1];
            }
            sum +="\r\n";
        }
        System.out.println(sum);
    }
    public static void main(String[] args){
        solution();
    }
}
