import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numCases = in.nextInt();
        in.nextLine();

        for(int i = 1; i < numCases + 1; i++) {
            int max = in.nextInt();
            int len = in.nextInt();
            in.nextLine();
            String[] numStr = in.nextLine().split(" ");

            List<Integer> key = new ArrayList<>();
            int[] nums = new int[numStr.length];
            int[] numMsg = new int[len + 1];

            for(int j = 0; j < numStr.length; j++) {
                nums[j] = Integer.parseInt(numStr[j]);        
            }

            for(int j = 0; j < len; j++) {
                int n = nums[j];
                int lowest = getLowestPrimeFactor(n, max);
                int highest = n / lowest;

                if(!key.contains(lowest)) {
                    key.add(lowest);
                }

                if(!key.contains(highest)) {
                    key.add(highest);
                }

                
                if(j == 1 && (lowest == numMsg[j-1] || highest == numMsg[j-1])) {
                    int s = numMsg[j-1];
                    numMsg[j-1] = numMsg[j];
                    numMsg[j] = s;
                }
                if(j >= 1) {
                    if(lowest == numMsg[j]) {
                        numMsg[j+1] = highest;
                    } else {
                        numMsg[j+1] = lowest;
                    }
                } else {
                    numMsg[j] = lowest;
                    numMsg[j + 1] = highest;
                }
                
            }
            
            Collections.sort(key);
            //at this point letters are known
            String message = "";
            for(int k = 0; k < numMsg.length; k++) {
                message += letters.charAt(key.indexOf(numMsg[k]));
            }
            
            for(int x = 0; x < key.size(); x++) {
                System.out.println(letters.charAt(x) + ": " + key.get(x));
            }
            System.out.println("Case #" + i + ": " + message.trim());
        }
        in.close();
    }

    private static int getLowestPrimeFactor(int n, int max) {
        if(n % 2 == 0) {
            return 2;
        }

        double softMax = Math.sqrt(n);

        for(int i = 3; i <= softMax && i < max; i += 2) {
            if(n % i == 0) {
                return i;
            }
        }
        
        return n;
    }
}