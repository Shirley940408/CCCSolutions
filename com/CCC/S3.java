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
        int infinity = -1000000001;
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
               }else{
                   result[i][j] = infinity;
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
        resultMatrix(result);
    }
    private static void resultMatrix(int[][] result){
        int inf = -1000000001;
        int[] diffOfRow = new int[6];
        int[] diffOfCol = new int[6];
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result.length; j++){
                if(result[i][j] != inf){
                    if(result[i][0] != inf && j != 0){
                        diffOfCol[i] = (result[i][j] - result[i][0])/(j - 0);
                        result[i][1] = result[i][0] + diffOfCol[i];
                        result[i][2] = result[i][0] + 2 * diffOfCol[i];
                    }
                    else if(result[i][1] != inf && j != 1){
                        diffOfCol[i] = (result[i][j] - result[i][1])/(j - 1);
                        result[i][0] = result[i][1] - diffOfCol[i];
                        result[i][2] = result[i][1] + diffOfCol[i];
                    }
                    else if(result[i][2] != inf && j != 2){
                        diffOfCol[i] = (result[i][j] - result[i][2])/(j - 2);
                        result[i][1] = result[i][2] - diffOfCol[i];
                        result[i][0] = result[i][2] - 2 * diffOfCol[i];
                    }
                    if(result[0][j] != inf && i != 0){
                        diffOfRow[j] = (result[i][j] - result[0][j])/(i - 0);
                        result[1][j] = result[0][j] + diffOfRow[j];
                        result[2][j] = result[0][j] + 2 * diffOfRow[j];
                    }
                    else if(result[1][j] != inf && i != 1){
                        diffOfRow[j] = (result[i][j] - result[1][j])/(i - 1);
                        result[0][j] = result[1][j] - diffOfRow[j];
                        result[2][j] = result[1][j] + diffOfRow[j];
                    }
                    else if(result[2][j] != inf && i != 2){
                        diffOfRow[j] = (result[i][j] - result[2][j])/(i - 2);
                        result[0][j] = result[2][j] - 2 * diffOfRow[j];
                        result[1][j] = result[2][j] - diffOfRow[j];
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
        solution(box, result);
        for(int m = 0; m < result.length; m++){
            for(int n = 0; n < result.length; n++){
                System.out.print(result[m][n] + " ");
            }
            System.out.println();
        }
    }
}
