import java.util.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int output = countBar(x);
        System.out.println(output);
    }

    public static int countBar(int x) {
        int output = 0;
        int barSize = 64;
        while(barSize > 0) {
            if ((x & barSize) != 0) {
                output++;
            }
            barSize >>= 1;
        }
        return output;
    }
}
