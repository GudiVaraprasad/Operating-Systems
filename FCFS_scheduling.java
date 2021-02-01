// Java program for implementation of FCFS scheduling 

import java.util.*;
import java.io.*;
import java.lang.*; 

class FCFS_scheduling 
{
	static void findavgTime(int at[], int bt[], int n)
	{
		System.out.print("Arrival time : ");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(at[i] + " ");
		} 
		System.out.println();
		System.out.println();

		System.out.print("Burst time : ");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(bt[i] + " ");
		} 
		System.out.println();
		System.out.println();


		int ct[] = new int[n];

		// Completion Time[n] = Burst time[n] + Burst time[n-1];

		ct[0] = bt[0];
		for (int i = 1; i < n; i++)
		{
			ct[i] = ct[i-1] + bt[i];
		}

		System.out.print("Completion Time : ");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(ct[i] + " ");
		} 
		System.out.println();
		System.out.println();
	

		int tat[] = new int[n];

		// Turn Around Time = Completion Time – Arrival Time
		for (int i = 0; i < n; i++)
		{ 
			tat[i] = ct[i] - at[i]; 
		}

		System.out.print("Turn around time :");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(tat[i] + " "); 
		}

		int total_tat = 0;
		for (int i = 0; i < n; i++) 
		{ 
			total_tat = total_tat + tat[i];
		}

		System.out.println();
		System.out.println();
		float avgtat = (float)total_tat /(float) n; 
		System.out.println("Average turn around time = " + avgtat);
		System.out.println();
	

		int wt[] = new int[n];

		// Waiting Time = Turn Around Time – Burst Time
		for (int i = 1; i < n; i++) 
		{ 
			wt[i] = tat[i] - bt[i]; 
		}

		System.out.print("Waiting time :");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(wt[i] + " "); 
		}

		int total_wt = 0;
		for (int i = 0; i < n; i++) 
		{
			total_wt = total_wt + wt[i];
		}

		System.out.println();
		System.out.println();
		float avgwt = (float)total_wt /(float) n;
		System.out.println("Average waiting time = " + avgwt); 
		System.out.println();
	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of processes : ");
		int n = in.nextInt();

		int at[] = new int[n];
		System.out.print("Enter arrival times : ");
		for (int i = 0; i < n; i++) 
		{ 
			at[i] = in.nextInt(); 
		}

		int bt[] = new int[n];
		System.out.print("Enter burst times : ");
		for (int i = 0; i < n; i++) 
		{ 
			bt[i] = in.nextInt(); 
		}
		
		System.out.println();
		findavgTime(at, bt, n);
	} 
}

// This code is contributed by Gudi Varaprasad - 19BCE7048
