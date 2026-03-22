package Part1;
import java.util.Scanner;
public class Task2 {
    public static int Sum(Scanner sc, int n){
        if (n == 0){
            return 0;
        }
        return sc.nextInt() + Sum(sc, n-1);
    }
public static void main(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = Sum(sc, n);
        double avg = (double) sum / n;
        System.out.println(avg);
}
}