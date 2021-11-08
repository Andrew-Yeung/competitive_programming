import java.util.Scanner;
import java.util.Stack;

public class practicetest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n =s.nextInt();
        for(int i=0;i<n;i++){
            String a = s.next();
            Stack<String> thing = new Stack();
            boolean check = true;
            for(int j=0;j<a.length();j++){
                if(a.charAt(j)=='(') thing.push(Character.toString(a.charAt(j)));
                else if(a.charAt(j)==')' && !thing.isEmpty()) {
                    thing.pop();
                }else{
                    if(a.charAt(j)==')'&& thing.isEmpty())check=false;
                }
            }
            System.out.println(thing.isEmpty() && check==true?"YES":"NO");
        }
    }
}
