import java.util.Scanner;

public class Uncrackable {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();
        boolean flag = true;
        int low = 0, up = 0, num = 0;
        for(int i =0;i<a.length();i++){
            if(!Character.isUpperCase(a.charAt(i)) && !Character.isLowerCase(a.charAt(i)) &&
            !Character.isDigit(a.charAt(i))){
                flag = false;
            }

            if(Character.isUpperCase(a.charAt(i))) up++;
            else if(Character.isLowerCase(a.charAt(i)))low++;
            if(Character.isDigit(a.charAt(i))) num++;

        }
        if(a.length() <= 12 && a.length() >= 8 && (flag == true) && (low >= 3 && up >= 2 && num >= 1)){
            System.out.println("Valid");
        }else System.out.println("Invalid");
    }
}
