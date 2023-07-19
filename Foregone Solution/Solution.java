import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();

        for(int i = 1; i < numCases + 1; i++) {
            int input = in.nextInt();
            int A = input;
            int B = 0;

            while(getFirstFour(A) > -1 || getFirstFour(B) > -1) {
                int orderA = getFirstFour(A);
                int multA = (int) Math.pow(10, orderA);
                A -= multA;
                B += multA;
            }

            int order = getFirstFour(input);
            System.out.println("Case #" + i + ": " + A + " " + B);
        }
        in.close();
    }

    private static int getFirstFour(int num) {
        int order = 0;
        while(num > 0) {
            if(num % 10 == 4) {
                return order;
            }
            num /= 10;
            order++;
        }
        return -1;
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
    

}