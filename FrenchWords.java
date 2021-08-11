import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FrenchWords{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        Set<String> one = new HashSet();
        Set<String> two = new HashSet();
        for(int i = 0; i < n; i++){
            String a = s.next();
            one.add(a);
        }
        int count = 0;
        for(int i = 0; i < m; i++){
            String a = s.next();
            two.add(a);
        }
        count = 0;
        for(String temp : one) {
            if(two.contains(temp)){
                count++;
            }
        }
        System.out.println(count);
    }
}
