// Java program for implementation of RR scheduling. 

import java.util.*;
import java.io.*;
import java.lang.*;

public class RRscheduling 
{ 
	static void findWaitingTime(int processes[], int n,int bt[], int wt[], int quantum) 
	{
		int btTemp[] = new int[n]; 
		for (int i = 0 ; i < n ; i++)
		{
			btTemp[i] = bt[i]; 
		}
	
		int t = 0;

		while(true) 
		{ 
			boolean finish = true; 

			for (int i = 0 ; i < n; i++) 
			{ 
				if (btTemp[i] > 0) 
				{ 
					finish = false;
	
					if (btTemp[i] > quantum) 
					{
						t += quantum; 

						btTemp[i] -= quantum; 
					} 
					else
					{ 
						t = t + btTemp[i];
						wt[i] = t - bt[i]; 
						btTemp[i] = 0; 
					} 
				} 
			} 

			if (finish == true)
			{ 
				break; 
			}
		} 
	} 
	
	static void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) 
	{ 
		for (int i = 0; i < n ; i++)
		{
			tat[i] = bt[i] + wt[i]; 
		}
	} 

	static void findavgTime(int processes[], int n, int at[], int bt[], int quantum) 
	{ 
		int wt[] = new int[n], tat[] = new int[n]; 
		int total_wt = 0, total_tat = 0; 
	 
		findWaitingTime(processes, n, bt, wt, quantum); 
	
		findTurnAroundTime(processes, n, bt, wt, tat); 
	
		System.out.print("Process ID : ");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(processes[i] + " ");
		}

		System.out.println();
		System.out.println(); 
	
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
	
		System.out.print("Turn Around time : ");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(tat[i] + " ");
		} 
		System.out.println();
		System.out.println();

		System.out.print("Waiting time : ");
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(wt[i] + " ");
		} 
		System.out.println();
		System.out.println();

		for (int i=0; i<n; i++)
		{
			total_tat = total_tat + tat[i];
			total_wt = total_wt + wt[i];
    }
 
		System.out.println("Average turn around time = " + (float)total_tat / (float)n);
		System.out.println("Average waiting time = " + (float)total_wt / (float)n);
	} 
	
	public static void main(String[] args) 
	{ 	
		Scanner in = new Scanner(System.in);
		System.out.print("Enter number of processes : ");
		int n = in.nextInt(); // 6
		
		System.out.print("Enter value of Time quantum : ");
		int quantum = in.nextInt(); // 2

		int processes[] = new int[n];
		for (int i = 0; i < n; i++) 
		{ 
			processes[i] = i+1; 
		}

		// 0 0 0 0 0 0
		int arrival_time[] = new int[n];
		System.out.print("Enter arrival times : ");
		for (int i = 0; i < n; i++) 
		{ 
			arrival_time[i] = in.nextInt(); 
		}

		// 4 5 2 1 6 3
		int burst_time[] = new int[n];
		System.out.print("Enter burst times : ");
		for (int i = 0; i < n; i++) 
		{ 
			burst_time[i] = in.nextInt(); 
		} 
		
		System.out.println();
		findavgTime(processes, n, arrival_time, burst_time, quantum); 
	} 
} 
