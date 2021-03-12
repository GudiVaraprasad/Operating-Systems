import java.util.*;
import java.io.*;
import java.lang.*;

public class SFA 
{
    public static void main(String args[]) 
    {
        int[] f = null;
        int st = 0;
        int len = 0;
        int j = 0;
        int c = 0;
        int count = 0;

        System.out.print("\nEnter the number of blocks : ");
        int n = in .nextInt();

        final int posX = 1;
        for (int pos = 0; true;) switch (pos) {
            default: f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = 0;
            }
            System.out.println("\nInitially all the blocks are free...");
            case posX:
                    count = 0;
                System.out.print("\nEnter starting block and length of files : ");
                st = in .nextInt();
                len = in .nextInt();
                for (int k = st; k < st + len; k++) {
                    if (f[k] == 0) {
                        count++;
                    }
                }
                if (len == count) {
                    for (j = st; j < st + len; j++) {
                        if (f[j] == 0) {
                            f[j] = 1;
                            System.out.println(j + " ---> " + f[j]);
                        }
                    }
                    if (j != st + len - 1) {
                        System.out.print("\nThe file is allocated to disk...\n");
                    }
                } else {
                    System.out.print("\nThe file is not allocated !!");
                }
                System.out.print("\nDo you want to enter more file ?\nPress 1 for YES \nPress 0 for NO\nChoose : ");
                c = in .nextInt();
                if (c == 1) {
                    pos = posX;
                    continue;
                } else {
                    System.out.print("\nProgram Terminated!");
                    System.exit(0);
                }
                return;
        }
    }

    public final static Scanner in = new Scanner(System.in);
}