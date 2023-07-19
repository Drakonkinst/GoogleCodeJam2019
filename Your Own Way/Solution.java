import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();

        for(int i = 1; i < numCases + 1; i++) {
            int N = in.nextInt();
            String Lpath = in.next();
            String P = "";

            for(int j = 0; j < 2 * N - 2; j++) {
                if(Lpath.charAt(j) == 'E') {
                    P += "S";
                } else {
                    P += "E";
                }
            }

            
            
            System.out.println("Case #" + i + ": " + P);
        }
    
        in.close();
    }

    
}