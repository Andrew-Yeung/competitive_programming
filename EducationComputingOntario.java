import java.util.Scanner;

public class Ecoo_Contest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer t = s.nextInt();
        //https://dmoj.ca/problem/ecooqual2018p2
        int e = 0;
        int c = 0;
        int os = 0;

        for(int i = 0; i < t; i++){
            String a = s.next();
            for(int j = 0; j < a.length(); j++){
                if(a.charAt(j) == 'E') {
                    e += 1;
                }
                if(a.charAt(j) == 'C'){
                    c += 1;
                }

                if(a.charAt(j) == 'O') {
                    os += 1;
                }


            }
            if(os % 2 == 1){ //if odd
                os = os - 1; //make it even by subtracting, not adding because then we would miscount by 1
            }

            for(int p = 0; p < e; p++){
                if(p == 0){
                    System.out.print("Educational");
                }else {
                    System.out.print(" Educational");
                }//add space
            }
            System.out.print(" Computing");
            for(int w = 0; w < (os/2); w++){
                System.out.print(" Organization of Ontario"); //we have to keep the loops inside
            }
            //reset the variables for the next loop rotation
            e = e-e;
            c = c-c;
            os = os-os;

            System.out.println("");

        }



    }

}
