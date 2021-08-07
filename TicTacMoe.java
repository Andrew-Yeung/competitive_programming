//efficiency over 9000
import java.util.Scanner;

public class TICTAK {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char[][] hi = new char[3][3];
        String a = s.next();
        String b = s.next();
        String c = s.next();
        for(int i = 0; i < a.length(); i++){
            hi[0][i] = a.charAt(i);
        }
        for(int i = 0; i < b.length(); i++){
            hi[1][i] = b.charAt(i);
        }
        for(int i = 0; i < c.length(); i++){
            hi[2][i] = c.charAt(i);
        }
        boolean griffycounter = false;
        boolean timmycounter = false;
        if(hi[0][0] == 'O' && hi[1][1] == 'O' && hi[2][2] == 'O'){

            griffycounter = true;
        }

        if(hi[0][0] == 'X' && hi[1][1] == 'X' && hi[2][2] == 'X'){
            timmycounter = true;
        }

        //yeyey
        if(hi[0][2] == 'O' && hi[1][1] == 'O' && hi[2][0] == 'O'){

            griffycounter = true;
        }
        if(hi[0][2] == 'X' && hi[1][1] == 'X' && hi[2][0] == 'X'){
            timmycounter = true;
        }

        //lines
        if(hi[0][0] == 'O' && hi[0][1] == 'O' && hi[0][2] == 'O'){

            griffycounter = true;
        }
        if(hi[1][0] == 'O' && hi[1][1] == 'O' && hi[1][2] == 'O'){

            griffycounter = true;
        }
        if(hi[2][0] == 'O' && hi[2][1] == 'O' && hi[2][2] == 'O'){

            griffycounter = true;

        }

        if(hi[0][0] == 'X' && hi[0][1] == 'X' && hi[0][2] == 'X'){
            timmycounter = true;
        }
        if(hi[1][0] == 'X' && hi[1][1] == 'X' && hi[1][2] == 'X'){
            timmycounter=true;
        }
        if(hi[2][0] == 'X' && hi[2][1] == 'X' && hi[2][2] == 'X'){
            timmycounter=true;

        }


        //col
        if(hi[0][0] == 'O' && hi[1][0] == 'O' && hi[2][0] == 'O'){

            griffycounter=true;
        }
        if(hi[0][1] == 'O' && hi[1][1] == 'O' && hi[2][1] == 'O'){

            griffycounter=true;
        }
        if(hi[0][2] == 'O' && hi[1][2] == 'O' && hi[2][2] == 'O'){

            griffycounter=true;
        }

        //
        if(hi[0][0] == 'X' && hi[1][0] == 'X' && hi[2][0] == 'X'){
            timmycounter=true;
        }
        if(hi[0][1] == 'X' && hi[1][1] == 'X' && hi[2][1] == 'X'){
            timmycounter=true;
        }
        if(hi[0][2] == 'X' && hi[1][2] == 'X' && hi[2][2] == 'X'){
            timmycounter=true;
        }
        //final
        if(timmycounter == true && griffycounter == true){
            System.out.println("Error, redo");
        }
        else if(griffycounter == true){
            System.out.println("Griffy");
        }
        else if(timmycounter == true){
            System.out.println("Timothy");
        }else{
            System.out.println("Tie");
        }

    }
}
