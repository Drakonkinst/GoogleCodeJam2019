import java.util.Scanner;

public class AlphabetCake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int ti = 0; ti < t; ti++) {
            int r = in.nextInt();
            int c = in.nextInt();
            in.nextLine();
            
            String[] map = new String[r];

            for(int i = 0; i < r; i++) {
                map[i] = in.nextLine();
            }



            System.out.println("Case #" + t + ":");
            for(int i = 0; i < r; i++) {
                System.out.println(map[i]);
            }
        }

        in.close();
    }
}

/*
tc = int(input())

for i in range(1, tc+1):
    print("Case #%d:" % i)
    r, c = map(int, input().split())
    ll = []
    for _ in range(r):
        ll.append(input().strip())
    z = 0
    while ll[z] == "?" * c:
        z += 1
    last = ll[z]
    for i in range(r):
        if ll[i] == "?" * c:
            ls = last
        else:
            ls = ll[i]
        last = ls
        y = 0
        while ls[y] == "?": y += 1
        lc = ls[y]
        tt = []
        for cc in ls:
            if cc == "?":
                print(lc, end = "")
            else:
                print(cc, end = "")
                lc = cc
        print()
*/

/*
Fittingly enough for a problem about cake, there is a simple divide-and-conquer strategy for the Large dataset. If the cake has only one letter on it, we can fill it up with that letter. Otherwise, we can make a horizontal or vertical cut that divides the cake into two sub-cakes, such that each part has at least one letter on it; this creates two more instances of the same problem. It is always possible to do this if there are at least two letters on the cake; one surefire way is to make a dividing cut that includes the right border of the leftmost of a pair of letters, or, if they are in the same column, the bottom border of the topmost of the pair.
*/