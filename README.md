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
## Junior 5
#### This problem has some difficulties. For the beginning the tester would like to know whether the students could figure out how to record the position of each step. In this case I used `str.contains(string)` to get true or false and `str.indexOf(string)` to get the first appeared position. Another point is to abstract the duplicated-form code patterns, otherwise the debug processing will be a mass.
```java
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
```
## Senior 1
*Please review the result of Junior 4*

## Senior 2
#### The idea is easy to get, the point is System.in need to be record first and then start to out put, otherwise the output will be shown immediately once the program received one of the input.
```java
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
```
## Senior 3
#### I believe this is the most challenageable problems in this test.
##### first, to reduce the dimensional, we need to divide the problem into subfunctions : the "X" in rare and the "X" is enough.
- when X is rare, we should fit them at least an row or a column.
- when X is enough, we need to figure what is the difference among different rows and columns.
##### In this problem, I used the arrays to restore difference of rows and columns. And using String[][] box to restore the original input and using int[][] result to calculate the answer with the same volume. Then figure out the difference between rows and columns. It could be simplified in forms.
```java
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
```
## Senior 4
#### The idea of this problem is not hard to find. A mistake has been realized that only linkedList had implemented the Queue interface (not  ArrayList), so using linkedList is an easier way unless you would like to override Queue interface yourself. Another point is to manipulate the queue based on the same reference in each situation, thus, we need to write `queue.offer()` frist when the situation has changed. Otherwise, the NullPointerException will show up.
```java
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
```
## Senior 5
### The problem is not hard. Just divide it into two part, that is how to traverse a single triangle with a constant height and how to move a sub-triagle in a large one.

```java
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
```