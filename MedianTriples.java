import java.util.Arrays;
import java.util.Scanner;

public class MedianTriples{
    public static void main(String[] args) {
        Scanner s  = new Scanner(System.in);
        int n = s.nextInt();
        int target = s.nextInt();
        int[] arr = new int[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                for(int k = j + 1; k < arr.length; k++){
                    int[] orz = new int[3];
                    orz[0] = arr[i]; orz[1] = arr[j]; orz[2] = arr[k];
                    Arrays.sort(orz);
                    if(orz[1] == target){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);


    }
}
