package com.CCC;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S4 {
    private static int totalOfConstant(int start, int endSteps, int limit, Queue<Integer> score, int total){
        for(int j = start; j < endSteps; j++){
            int maxInEachStep = 0;
            for(int k = 0; k < limit; k++){
                int temp = score.poll();
//                System.out.println("temp: " + temp);
                if(temp > maxInEachStep){
                    maxInEachStep = temp;
                }
            }
            total += maxInEachStep;
        }
        return total;
    }
    private static void solution(int sum, int limit, String[] weights){
        Queue<Integer> score = new LinkedList<>();
        int steps;
        int total = 0;
        if(sum % limit == 0){
            steps = sum / limit;
            for(int i = 0; i < sum; i++){
                score.offer(Integer.parseInt(weights[i]));
            }
            total = totalOfConstant(0, steps, limit, score, total);
            System.out.println(total);
        }else{
            int maximum = 0;
            steps = sum / limit + 1;
            int diff = sum - (steps - 1) * limit;
            for(int l = 0; l < steps; l++){// l is the position where this different step showed up
                for(int i = 0; i < sum; i++){
                    score.offer(Integer.parseInt(weights[i]));
                }
                total = totalOfConstant(0, l, limit, score, 0);
//                System.out.println("total: " + total);
                total = totalOfConstant(l, l + 1, diff, score, total);
//                System.out.println("total: " + total);
                total = totalOfConstant(l + 1, steps, limit, score, total);
//                System.out.println("total: " + total);
                if(total > maximum){
                    maximum = total;
                }
            }
            System.out.println(maximum);
        }
    }
    public static void main(String[] args){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        String[] sumAndLimit = s.nextLine().split(" ");
        int sum = Integer.parseInt(sumAndLimit[0]);
        int limit = Integer.parseInt(sumAndLimit[1]);
        String[] weights = s.nextLine().split(" ");
        solution(sum, limit, weights);
    }
}
