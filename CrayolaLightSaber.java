import java.util.Scanner;

public class CrayolaMarkers {
    public static void main(String[] args) {
        //https://dmoj.ca/problem/bfs17p2/editorial
        Scanner s = new Scanner(System.in);
        Integer n = s.nextInt();
        //find the most frequent marker
        //find the difference between size and frequency
        //use variables to find the frequency
        int red = 0; int orange = 0; int yellow = 0;
        int green = 0; int blue = 0; int black = 0;
        for(int i = 0; i < n; i++){
            String a = s.next();
            // red orange yellow green blue black
            switch(a){
                case "red":
                    red++;
                    break;
                case "orange":
                    orange++;
                    break;
                case "yellow":
                    yellow++;
                    break;
                case "green":
                    green++;
                    break;
                case "blue":
                    blue++;
                    break;
                case "black":
                    black++;
                    break;
            }
        }
        int[] arr = new int[6];
        arr[0] = red;
        arr[1] = orange;
        arr[2] = yellow;
        arr[3] = green;
        arr[4] = blue;
        arr[5] = black;

        int frequency = 0;
        //loop to find the highest frequency
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >  frequency){
                frequency = arr[i];
            }
        }
        //we now have the frequency and we can use formula to find the max.
        //the formula is - min(frequency, total - frequency) + (total - frequency)
        System.out.println(Math.min(frequency, (n-frequency) + 1) + (n - frequency));


    }
}
