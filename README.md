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