package com.CCC;

import java.util.Scanner;

public class S2 {
    private static boolean isPrime(int num){
        if(num < 2){
            return false;
        }else{
            for(int i = 2; i < num; i++){
                if(num % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
    private static void solution(int [] nums){
        for(int i = 0 ; i < nums.length; i++){
            for(int j = 2; j < nums[i]; j++){
                if(isPrime(j) && isPrime(nums[i]- j)){
                    System.out.println(j + " " + (nums[i] - j));
                    break;
                }
            }
        }
    }
    public static void main(String[] args){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i]= s.nextInt() * 2;
        }
        System.out.println("Output");
        solution(array);
    }
}
