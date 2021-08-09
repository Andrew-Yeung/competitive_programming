import java.util.*;
public class MonkeyPotatoV2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer length = s.nextInt();
        Integer n = s.nextInt();

        ArrayList<Integer> hi = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            Integer a = s.nextInt();
            hi.add(a);
        }
        int check = 0;
        for(int i = 0; i < hi.size(); i++){
            if(hi.get(i) == 0){
                check++;
            }
        }
        if(check == hi.size()){
            System.out.println(-1);
        }else{
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < hi.size(); i++){
                if(hi.get(i) < min){
                    min = hi.get(i);
                }
            }
            if(min == 0){
                int newmin = Integer.MAX_VALUE;
                for(int i = 0; i < hi.size(); i++){
                    if(hi.get(i) < newmin && hi.get(i) != 0){
                        newmin = hi.get(i);
                    }
                }
                if(length > 2){
                    String print = String.valueOf(newmin);
                    for(int i = 0; i < length - 2; i++){
                        print += "0";
                    }
                    print += String.valueOf(newmin);
                    System.out.println(print);
                }
                if(length <= 2){
                    String print = "";
                    for(int i = 0; i < length; i++){
                        print += String.valueOf(newmin);
                    }
                    if(Integer.parseInt(print) == 0){
                        System.out.println(newmin);
                    }else {
                        System.out.println(print);
                    }
                }

            }else{

                String print = "";
                for(int i = 0; i < length; i++){
                    print += min;
                }
                System.out.println(print);
            }
        }
        //it Aced

    }
}
