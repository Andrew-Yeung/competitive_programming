import java.util.Scanner;

public class StanelyCUp {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/wc17c1j3
        Scanner s = new Scanner(System.in);
        int aa = 0;
        int bb = 0;
        while(aa < 4 && bb < 4){
            Integer a = s.nextInt();
            Integer b = s.nextInt();
            if(a > b){
                aa++;
            }
            if(b > a){
                bb++;
            }
        }
        System.out.println(aa + " " + bb);
    }
}
