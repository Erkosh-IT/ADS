package Part1;
import java.util.Scanner;
public class Task1 {
    public static void PrintNUM(int n) {
        if (n < 10) {
            System.out.println(n);
            return;
        }
        PrintNUM(n / 10);
        System.out.println(n % 10);
    }
    public static void main() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PrintNUM(n);
    }
}