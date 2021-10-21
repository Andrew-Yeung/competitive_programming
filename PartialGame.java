import java.util.Scanner;

public class thingyyy {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        double odd = 0, even = 0;
        for(int i=0;i<n;i++){
            int a = s.nextInt();
            if(a % 2 == 0){
                even += (double)(a/2);
            }
            else odd += (double) ((a + 1)/2);
        }
        if(odd >= even) System.out.println("Alice");
        else{
            System.out.println("Duke");
        }
    }
}
