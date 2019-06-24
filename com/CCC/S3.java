package com.CCC;

import java.util.Scanner;

public class S3 {
    private static String[] getColumn(String[][] array, int index){
        String[] column = new String[array.length];
        for(int i = 0; i < array.length; i++){
            column[i] = array[i][index];
        }
        return column;
    }
    private static int[] controller(String [][] box, int[][] result){
        int counter = 0;
        int max = -1000000001;
        int[] counterAndMax = new int[2];
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box.length; j++){
               if(!box[i][j].equals("X")){
                   result[i][j] = Integer.parseInt(box[i][j]);
                   if(result[i][j] > max){
                       max = result[i][j];
                   }
                   counter++;
               }
            }
        }
        counterAndMax[0] = counter;
        counterAndMax[1] = max;
        return counterAndMax;
    }
    private static void solution(String [][] box, int[][] result){
        int num = controller(box, result)[0];
        int max = controller(box, result)[1];
        if(num == 0){
            return;
        }
        else if(num <= 3){
            for(int i = 0; i < result.length; i++){
                for(int j = 0 ; j < result.length; j++){
                    if(result[i][j] == max){
                        if(numOfX(box[i]) == 2 ){
                           result[i][0] = max;
                           result[i][1] = max;
                           result[i][2] = max;
                        }else if(numOfX(getColumn(box,j)) == 2){
                           result[0][j] = max;
                           result[1][j] = max;
                           result[2][j] = max;
                        }
                    }
                }
            }
        }

    }
    private static int numOfX(String[] array){
        int counter = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i].equals("X")){
                counter++;
            }
        }
        return counter;
    }
    public static void main(String[] args){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        String[][] box = new String[3][3];
        int[][] result = new int[3][3];
        box[0] = s.nextLine().split(" ");
        box[1] = s.nextLine().split(" ");
        box[2] = s.nextLine().split(" ");

    }
}
