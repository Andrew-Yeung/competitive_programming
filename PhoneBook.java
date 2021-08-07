import java.util.*;

public class PhoneBoook {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        //just make 3 arrays and do not sort because you will screw up indexes
        String[] names = new String[n];
        int[] numbers = new int[n];
        int[] freq = new int[n]; //counts frequency for each person
        for(int i = 0; i < n; i++){
            String name = s.next();
            int number = s.nextInt();
            names[i] = name;
            numbers[i] = number;
        }
        int calls = s.nextInt();
        for(int i = 0; i < calls; i++){
            Integer num = s.nextInt();
            for(int j = 0; j < numbers.length; j++){
                if(numbers[j] == num){
                    freq[j]++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > max){
                max = freq[i];
                index = i;
            }
        }
        ArrayList<Integer> hi = new ArrayList<Integer>();
        ArrayList<String> names2 = new ArrayList<String>();

        //there could be 2 max
        for(int i = 0; i < freq.length; i++){
            if(freq[i] == max){
                hi.add(numbers[i]);
                names2.add(names[i]);
            }
        }
        //find smallest of hi
        int min = Integer.MAX_VALUE; int index2 = 0;
        for(int i = 0; i < hi.size(); i++){
            if(hi.get(i) < min){
                min = hi.get(i);
                index2 = i;
            }
        }
        System.out.println(names2.get(index2));
    }
}
