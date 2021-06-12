import java.util.ArrayList;
import java.util.Scanner;

public class task {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/dmopc19c5p1
        //add the items into the item list
        //for every iteration of the task loop, store the requirements in a temporary array
        //for every index of the requirements array, check if the main array has it
        //if it does, then a counter is increased by 1
        //if this counter is equal to the array's size, this means that it contains everything
        //this is because the size is the number of items you want
        //if it contains everything, increase final counter
        //reset
        //print counter
        Scanner s = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<String>();
        Integer n = s.nextInt();
        Integer m = s.nextInt();

        for(int i = 0; i < n; i++){
            String a = s.next();
            items.add(a);
        }
        int count = 0;
        ArrayList<String> check = new ArrayList<String>(); //temp array
        for(int i = 0; i < m; i++){
            Integer a = s.nextInt();
            for(int j = 0; j < a; j++){
                String b = s.next();
                check.add(b);
            }
            int temp = 0;

            for(int w = 0; w < check.size(); w++){
                if(items.contains(check.get(w))){
                    temp++;
                }

            }
            if(temp == check.size()){
                count++;
            }
            temp = 0;
            check.clear();
        }
        System.out.println(count);

    }
}
