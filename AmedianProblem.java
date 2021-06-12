import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class medianofmedian {
    ///https://dmoj.ca/problem/nccc3j4s2
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        ArrayList<Integer> hi = new ArrayList<Integer>();
        ArrayList<Integer> hi2 = new ArrayList<Integer>();

        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                Integer a = s.nextInt();
                hi.add(a);
            }
            Collections.sort(hi);
            int p = (n + 1)/2; //index of the array
            hi2.add(hi.get(p-1));
            hi.clear();
        }

        Collections.sort(hi2);
        System.out.println(hi2.get((n+1)/2 - 1));
    }


}
