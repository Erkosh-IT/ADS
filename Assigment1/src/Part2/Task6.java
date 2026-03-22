package Part2;
import java.util.Scanner;
public class Task6 {
    public static int POWER(int a, int n) {
        if (n == 0) {
            return 1;
        } else {
            return a * POWER(a, n - 1);
        }
    }
    public static void main(){
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int n = sc.nextInt();
    System.out.println(POWER(a, n));
    }
}
