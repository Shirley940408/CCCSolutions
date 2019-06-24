package com.CCC;
import java.util.Scanner;
public class S5 {
    private static int traversePoint(int height, String[][] box, int y, int x){
        int max = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j <= i; j++){
                int value = Integer.parseInt(box[i + y][j + x]);
                if(value > max){
                    max = value;
                }
            }
        }
        return max;
    }
    private static int traverseTriangle(int triangle, int sub, String[][] box){
        int sum = 0;
        for(int i = 0; i <= triangle - sub; i++){
            for(int j = 0; j <= i; j++){
                sum += traversePoint(sub, box, i, j);
                // i and j is the maximum moving distance of sub-triangle in the large one.
            }
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        String[] triAndSubtriangle = s.nextLine().split(" ");
        int triHeight = Integer.parseInt(triAndSubtriangle[0]);
        int subHeight = Integer.parseInt(triAndSubtriangle[1]);
        String[][] box = new String[triHeight][];
        System.out.println(box.length);
        for(int i = 0; i < box.length; i++){
            box[i] = s.nextLine().split(" ");
        }
        int sum = traverseTriangle(triHeight, subHeight, box);
        System.out.println("Output");
        System.out.println(sum);
    }
}
