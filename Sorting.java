import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		Scanner s = new Scanner(System.in);
		Integer N = s.nextInt();
		
		for(int i = 0; i < N; i++) {
			Integer T = s.nextInt();
			arr.add(T);
		}
		Collections.sort(arr);
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
