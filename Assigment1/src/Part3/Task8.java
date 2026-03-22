package Part3;

import java.util.Scanner;

public class Task8 {
    public static boolean ALLdigit(String s, int index){
        if (index == s.length()){
            return true;
        }
        char c = s.charAt(index);
        if (c < '0' || c > '9'){
            return false;
        }
        return ALLdigit(s, index+1);
    }
    public static void main(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (ALLdigit(s, 0)){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
