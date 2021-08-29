import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PresentChecking {
    static boolean duplicate(int[] arr, int n){
        boolean check = true;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > n || arr[i] < 1){
                check = false;
            }
        }
        return check;
    }
    static boolean contains(int[] arr){
        boolean thing = true;
        Set<Integer> ok = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            ok.add(arr[i]);
        }
        if(ok.size() != arr.length) thing = false;
        return thing;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[]arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }
        if(duplicate(arr, n) && contains(arr)) System.out.println("YES");
        else System.out.println("NO");


    }
}
