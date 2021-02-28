import java.util.*;
public class MemoryManagement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println();

        System.out.print("Enter the total size of Primary Memory = ");
        int memorySize = in .nextInt();
        System.out.println();

        System.out.print("Enter number of partitions = ");
        int n = in.nextInt();
        System.out.println();

        int[] blockSize = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the size of " + (i + 1) + " partition = ");
            blockSize[i] = in.nextInt();
            System.out.println();
        }

        System.out.print("Enter number of process = ");
        int m = in.nextInt();
        System.out.println();

        int[] processSize = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.print("Enter the size of " + (i + 1) + " process = ");
            processSize[i] = in.nextInt();
            System.out.println();
        }

        // First-Fit

        int firstFit[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (processSize[i] < blockSize[j] && firstFit[j] == 0) {
                    firstFit[j] = i + 1;
                    i++;
                    j = 0;
                    if (i >= m)
                        break;

                }
            }
        }
        System.out.println();
        System.out.println("\n FIRST FIT ALGORITHM \n");

        for (int i = 0; i < n; i++)

            System.out.print((i + 1) + "\t");
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (firstFit[i] == 0)
                System.out.print("\t");
            else
                System.out.print("P" + firstFit[i] + "\t");
        }

        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(blockSize[i] + "\t");

        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        // Next-Fit

        int nextFit[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (processSize[i] < blockSize[j] && nextFit[j] == 0) {
                    nextFit[j] = i + 1;
                    i++;

                    if (i >= m)
                        break;

                }
            }
        }

        System.out.println("\n NEXT FIT ALGORITHM \n");
        for (int i = 0; i < n; i++)
            System.out.print((i + 1) + "\t");
        System.out.println();
        for (int i = 0; i < n; i++) {
            if (nextFit[i] == 0)
                System.out.print("\t");
            else
                System.out.print("P" + nextFit[i] + "\t");
        }
        System.out.println();
        for (int i = 0; i < n; i++)
            System.out.print(blockSize[i] + "\t");

        System.out.println();
    }

}