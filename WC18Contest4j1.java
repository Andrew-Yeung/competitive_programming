import java.util.Scanner;

public class Quarters {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/wc18c4j1
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        Integer a = s.nextInt();

        double amount = a*0.25;

        double yes = (n-amount)/0.25;
        int printer = (int) yes;

        if(printer <= 0){
            System.out.println(0);
        }else{
            System.out.println(printer);
        }


    }
}
