# README
*This is the solutions for Canadian Computing Competition*
## junior1
#### This question is easy.
```java
import java.util.Scanner;
public class J1 {
    public static void solution(){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        int ThreePointA = s.nextInt();
        int TwoPointA = s.nextInt();
        int OnePointA = s.nextInt();
        int ThreePointB = s.nextInt();
        int TwoPointB = s.nextInt();
        int OnePointB = s.nextInt();

        int scoreA = ThreePointA*3 + TwoPointA*2 + OnePointA;
        int scoreB = ThreePointB*3 + TwoPointB*2 + OnePointB;
        System.out.println("Output");
        if(scoreA > scoreB){
            System.out.println("A");
        }
        else if(scoreA < scoreB){
            System.out.println("B");
        }
        else{
            System.out.println("T");
        }
    }
    public static void main(String[] args){
        solution();
    }
}
```
## junior2
#### The point is how to get the num and the symbol. Using the `string.split(" ")` is a good way to avoid the space effectively and get the next move easily.
```java
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
```
## Junior 3
#### The point is to distint the first element in the input string of each line and the changing element during looping this string. Using the value of the first element to initial each bit, and push them into the result when it changed. And, do not forget the last element, for it still need to be pushed into the result when the looping stoped
```java
import java.util.Scanner;
public class J3 {
    public static void solution(){
        System.out.println("Input");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String result = "";
        for(int i = 0; i < n; i++){
            String temp = s.nextLine();
            char bit = temp.charAt(0);
            int sum = 1;
            for(int j = 1; j < temp.length(); j++){
                if(temp.charAt(j) == bit){
                    sum++;
                }
                else{
                    result += sum+" "+bit+" ";
                    sum = 1;
                }
                bit = temp.charAt(j);
            }
            result += sum+" "+bit+"\r\n";
        }
        System.out.println("Output");
        System.out.println(result);
    }
    public static void main(String[] args){
        solution();
    }
}

```
## Junior 4/ Senior 1
#### The point is to separate each concept into a sub-function, that could simplify this problem.
```java
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
```