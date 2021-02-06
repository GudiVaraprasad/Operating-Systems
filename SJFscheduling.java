import java.util.*;
public class SJFscheduling {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of processes : ");
        int n = in .nextInt();
        int pID[] = new int[n];
        int at[] = new int[n];
        int bt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        int wt[] = new int[n];
        int f[] = new int[n];

        int st = 0, tot = 0;
        float avgwt = 0, avgtat = 0;

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter process " + (i + 1) + " Arrival time : ");
            at[i] = in .nextInt();
            System.out.println();

            System.out.print("Enter process " + (i + 1) + " Burst time : ");
            bt[i] = in .nextInt();
            System.out.println();
            pID[i] = i + 1;
            f[i] = 0;
        }

        System.out.println("--------------------------------------");
        System.out.println();

        System.out.print("Processor ID : ");
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        System.out.println();

        System.out.print("Arrival time : ");
        for (int i = 0; i < n; i++) {
            System.out.print(at[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.print("Burst time : ");
        for (int i = 0; i < n; i++) {
            System.out.print(bt[i] + " ");
        }
        System.out.println();
        System.out.println();

        while (true) {
            int c = n, min = 999;
            if (tot == n)
                break;
            for (int i = 0; i < n; i++) {
                if ((at[i] <= st) && (f[i] == 0) && (bt[i] < min)) {
                    min = bt[i];
                    c = i;
                }
            }
            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                tat[c] = ct[c] - at[c];
                wt[c] = tat[c] - bt[c];
                f[c] = 1;
                tot++;
            }
        }

        System.out.print("Completion Time : ");
        for (int i = 0; i < n; i++) {
            System.out.print(ct[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.print("Turn around time : ");
        for (int i = 0; i < n; i++) {
            System.out.print(tat[i] + " ");
        }
        System.out.println();
        System.out.println();

        System.out.print("Waiting time : ");
        for (int i = 0; i < n; i++) {
            System.out.print(wt[i] + " ");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgtat += tat[i];
        }
        System.out.println("\nAverage turn around time = " + (float)(avgtat / n));
        System.out.println("Average waiting time = " + (float)(avgwt / n));

    }
}