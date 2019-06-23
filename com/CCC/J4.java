package com.CCC;
import java.util.Arrays;
import java.util.Scanner;

public class J4 {
    private static int[] getColumn(int[][] array, int index){
        int[] column = new int[array.length];
        for(int i = 0; i < array.length; i++){
           column[i] = array[i][index];
        }
        return column;
    }
    private static void solution(int[][] box){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        String controller = s.nextLine();
        for(int i = 0; i < controller.length(); i++){
            if(controller.charAt(i) == 'H'){
                horizontal(box);
            }
            if(controller.charAt(i) == 'V'){
                vertical(box);
            }
        }
    }
    private static int[][] horizontal(int[][] array){
        int[] rowOne = array[0];
        int[] rowTwo = array[1];
        array[0] = rowTwo;
        array[1] = rowOne;
        return array;
    }
    private static int[][] vertical(int[][] array){
        int[] colOne = getColumn(array,0);
        int[] colTwo = getColumn(array, 1);
        array[0][0] = colTwo[0];
        array[0][1] = colOne[0];
        array[1][0] = colTwo[1];
        array[1][1] = colOne[1];
        return array;
    }
    public static void main(String[] args){
        int[][] box = {{1,2},{3,4}};
        solution(box);
        System.out.println("Output");
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box.length; j++){
                System.out.print(box[i][j]+" ");
            }
            System.out.println();
        }
    }
}
