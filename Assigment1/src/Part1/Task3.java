package Part1;
import java.util.Scanner;
public class Task3 {
    public static boolean Prime(int n, int div){
        if (n <= 1){
            return false;
        }
        if (div == 1){
            return true;
        }
        if (n % div == 0){
            return false;
        }
        return Prime(n, div - 1);
    }
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (Prime(n, n/2)){
            System.out.println("Prime");
        }
        else {
            System.out.println("Composite");
        }
    }
}
