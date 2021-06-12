import java.util.Scanner;

public class yoda {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/wc15c2j2
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        Integer max = s.nextInt();
        int counter = 0;
        for(int i = 0; i < n; i++){
            Integer a = s.nextInt();
            if(a <= max){
                counter += a;
            }
        }
        System.out.println(counter);
    }
}
