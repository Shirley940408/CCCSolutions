package com.CCC;

import java.util.Arrays;
import java.util.Scanner;

public class J5 {
    private static int controller(String[] rules, int rulesNum, int point, String[] lenStartEnd){
        int prev = point;
        int newPoint = prev + rules[0].length();
        String result = lenStartEnd[1].substring(0, prev) + rules[1] + lenStartEnd[1].substring(newPoint);
        System.out.println(rulesNum + " " + ( prev + 1 )+ " " + result);
        String temp = lenStartEnd[1];
        lenStartEnd[1] = result;
        if(temp.substring(newPoint).equals("")){
            return prev;
        }
        return prev + rules[1].length();
    }
    private static void solution(String[] ruleOne, String[] ruleTwo, String[] ruleThree, String[] lenStartEnd){
        System.out.println("Output");
        // for ruleOne to ruleThree, the first element([0]) is the part that need to be changed,
        // the second element([1]) is the changed result.
        // lenStartEnd[0] is the num of steps, lenStartEnd[1] is the starting point, and lenStartEnd[2] is the end point.
        int point = 0;
        String result;
        for(int i = 0; i < Integer.parseInt(lenStartEnd[0]); i++){
            if(lenStartEnd[1].substring(point).contains(ruleOne[0])){
                point += lenStartEnd[1].substring(point).indexOf(ruleOne[0]);
                point = controller(ruleOne, 1, point, lenStartEnd);
            }
            else if(lenStartEnd[1].substring(point).contains(ruleTwo[0])){
                point += lenStartEnd[1].substring(point).indexOf(ruleTwo[0]);
                point = controller(ruleTwo, 2, point, lenStartEnd);
            }
            else if(lenStartEnd[1].substring(point).contains(ruleThree[0])){
                point += lenStartEnd[1].substring(point).indexOf(ruleThree[0]);
                point = controller(ruleThree, 3, point, lenStartEnd);
            }
        }
    }
    public static void main(String[] args){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        String[] ruleOne = s.nextLine().split(" ");
        String[] ruleTwo = s.nextLine().split(" ");
        String[] ruleThree = s.nextLine().split(" ");
        String[] lenStartEnd = s.nextLine().split(" ");
        solution(ruleOne, ruleTwo, ruleThree, lenStartEnd);
    }
}
