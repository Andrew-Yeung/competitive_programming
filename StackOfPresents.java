import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StackOfPresentes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        Integer[] arr = new Integer[n];
        for(int i =0;i<n;i++){
            arr[i] = s.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        int sdoasd = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= sdoasd){
                sum++;
                sdoasd+=arr[i];
            }
        }
        System.out.println(sum);

    }
}
