import java.util.Scanner;

public class Buka {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer a = s.nextInt();

        for(int i = 1; i < a; i++){
            if(a % i == 0){
                System.out.println(i);
            }
        }
        System.out.println(a);
    }
}
