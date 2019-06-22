# README
- This is a solution for Canadian Computing Competition
## junior1
### This question is easy.
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