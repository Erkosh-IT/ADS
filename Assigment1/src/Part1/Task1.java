package Part1;
import java.util.Scanner;
public class Task1 {
    public static void print(int n) {
        n = Math.abs(n);
        if (n < 10) {
            System.out.println(n);
        } else {
            print(n / 10);
            System.out.println(n % 10);
        }
    }
    public  static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        print(number);
    }
}