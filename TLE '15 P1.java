import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class POWERRATINGS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		Integer n = s.nextInt();
		Integer power = s.nextInt();
		ArrayList<String> names = new ArrayList<String>();
		
		for(int i = 0; i < n; i++) {
			String a = s.next();
			names.add(a);
		}
		int[][] arr = new int[power][n];
		for(int i = 0; i < power; i++) {
			for(int j = 0; j < n; j++) {
				Integer a = s.nextInt();
				arr[i][j] = a;
			}
		}
		//[0,3]
		//[1,3]
		//[2,3]
		//3 4 2 1 0
		//1 3 4 2 0
		//5 1 7 4 0
		ArrayList<Integer> hi = new ArrayList<Integer>();
		int current = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < power; j++) {
				current += arr[j][i];
			}
			hi.add(current);
			current = 0;			
			
		}
		boolean check = true;
		int counter = 0;
		int index = 0;
		int highest = 0;
		while(check == true) {
			counter++;
			for(int i = 0; i < hi.size(); i++){
				if(hi.get(i) > highest) {
					highest = hi.get(i);
					index = i;
				}
			}
			System.out.println((counter + 2) + ". " + names.get(index));
			hi.remove(index);
			names.remove(index);
			if(hi.size() == 0) {
				break;
			}
			index = 0;
			highest = 0;
			
		}
	}	

}
