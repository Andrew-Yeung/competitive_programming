import java.util.Scanner;

public class TripleFatLadies {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/a3
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        long current = 0;
        for(int i = 0; i < n; i++){
            Integer a = s.nextInt();
            for(long j = a+1; j < 1000000000; j++){
                current = j*j*j;
                String yes = String.valueOf(current);
                if(yes.length() >= 3 && yes.charAt(yes.length()-1) == '8' && yes.charAt(yes.length()-2) == '8' && yes.charAt(yes.length()-3) == '8'){
                    System.out.println(j);
                    break;
                }

            }
        }
    }
}
