import java.io.*;
import java.util.*;

public class CountValley {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        char[] chars = s.toCharArray();
        
        int count = 0;
        boolean flag = false;
        int valleys = 0;

        for (int i = 0; i < n; i++) {
            count = chars[i] == 'U' ? ++ count: -- count;
            if (count == 0) {
                if (flag) {
                    valleys ++;
                }

                if ( i+1 < n) {
                    if (chars[i+1] == 'D') {
                        flag = true;
                    }
                }
            }
        }
        return valleys;
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = "DDDUDDUUDUDUUUUDUDUDDDDDDUDUDUDDUDUDDUDDUDUDUUDDDDUDUUUUDDDUUDDDUUDUDDDUDUDDUUDDUUDDUDUDDUDUUUUDDDDDUUUUUUDDUUDDDDDUUDUUDUUUDDDDDUUDDUUUDUUDUUDUDDUDDUDUUUUDUDDUDDUUUDUDUUUUUUDDUUUUDDUUDDUDDUDUDUDUDDDDUDUDDDDDDDDUDUDDUUUUDUUDDDDUDUUUUUDUDUDUDUDUUUDDDDDDDDDDDUUDUUDDUDDUDDUDDUUUUDDUUDDUDDUDDDUDDDUUUDUDUDDUUDUDDUDUUUUUUUDUDDDDDDDDDUUUDUDDDDUUDUUUDUUDUUUUUUDDDUDUUDDDDUUUUDDDUDDDUDDDDUDDUUUDUUDDUDDDUUUDUUDUUUDDUDDDDUUUUUDUDDUDDDUUDDUDUUDDDUUUDDDUUDDDDUDDUDDDUDDUUUUDUUUUUDDUDDDDUUDUUDUUUUDDDDUDUUDDUDDUDDDDUUUDDDDUDUDUDUUUDUUDDDDUUDUUUUDDUUDDUDDUUUUDUUDUDUUDDDUUUDUDUUUUDUDDUUDDUUUUDUUUDUDUUUUDDDDUUDUUDUUUDUDUUDDUUUDDDDUUDUDUUDUUDDUDUDUDUUUUUDDDUUUUDUDUDUUDDDDDUDUUDDUDDUDDDDUUDUDUDUUUUUUUDUUUUUUUDUUUUUUUDDDDUUDUUUUDUUDUDUUUDUUDUUDUDDDUUDUDDUDUDDDUDDUUUUDDUDDDDDUDUDDDDUUDUDUUDDDUDDDDUUUUUDDUUDDDDUDDDDDDUUDUUDUUUUDUUUUDUUUDUDDDUDUUUDUUUUDUUUUUUUUUDDDUDDUUUDUDUDDDUDDUUUUDUUDDDUDDUDUDDDUUDDUUUUUUUUUDDDDUUUUDDDUDDDUUUDUDDDDUUUUDUUDUDUUDDUUDDDUDDUUDDUUUUDDDDDUUUUUUDDUUUDDDUDDDUUUUUDDDUDUDDDDDDUUDUDUUDUDUUUUDUUUUUUUU";

        int result = countingValleys(n, s);

        System.out.println(result);

        scanner.close();
    }
}