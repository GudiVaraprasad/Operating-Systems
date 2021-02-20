import java.util.*;
import java.io.*;
import java.lang.*;

class MemoryManagement
{ 
	static void firstFit(int blockSize[], int m, int processSize[], int n) 
	{ 
		int allocation[] = new int[n]; 
		for (int i = 0; i < allocation.length; i++) 
			allocation[i] = -1; 
	
		for (int i = 0; i < n; i++) 
		{ 
			for (int j = 0; j < m; j++) 
			{ 
				if (blockSize[j] >= processSize[i]) 
				{ 
					allocation[i] = j;  
					blockSize[j] -= processSize[i]; 
					break; 
				} 
			} 
		} 
	
		System.out.println("\nProcess No.\tProcess Size\tAllocated Partition no."); 
		for (int i = 0; i < n; i++) 
		{ 
			System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t"); 
			if (allocation[i] != -1) 
				System.out.print(allocation[i] + 1); 
			else
				System.out.print("Not Allocated"); 
			System.out.println(); 
		} 
	} 

	static void bestFit(int blockSize2[], int m, int processSize2[], int n) 
    {  
        int allocation2[] = new int[n]; 
       
        for (int i = 0; i < allocation2.length; i++) 
            allocation2[i] = -1;  
        for (int i=0; i<n; i++) 
        { 
            int bestIdx2 = -1; 
            for (int j=0; j<m; j++) 
            { 
                if (blockSize2[j] >= processSize2[i]) 
                { 
                    if (bestIdx2 == -1) 
                        bestIdx2 = j; 
                    else if (blockSize2[bestIdx2] > blockSize2[j]) 
                        bestIdx2 = j; 
                } 
            } 
       
            if (bestIdx2 != -1) 
            { 
                allocation2[i] = bestIdx2; 
                blockSize2[bestIdx2] -= processSize2[i]; 
            } 
        } 
       
        System.out.println("\nProcess No.\tProcess Size\tAllocated Partition no."); 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print("   " + (i+1) + "\t\t" + processSize2[i] + "\t\t"); 
            if (allocation2[i] != -1) 
                System.out.print(allocation2[i] + 1); 
            else
                System.out.print("Not Allocated"); 
            System.out.println(); 
        }
    }

	public static void main(String args[]) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println();

		System.out.print("Enter the total size of Primary Memory = ");
		int memorySize = in.nextInt();
		System.out.println();

		System.out.print("Enter number of partitions = ");
		int m = in.nextInt();
		System.out.println();

		int[] blockSize = new int[m];
		int[] blockSize2 = new int[m];
		for(int i=0;i<m;i++)
		{
			System.out.print("Enter the size of " + (i+1) + " partition = ");
			blockSize[i] = in.nextInt();
			System.out.println();
			blockSize2[i] = blockSize[i];
		}

		System.out.print("Enter number of process = ");
		int n = in.nextInt();
		System.out.println();

		int[] processSize = new int[n];
		int[] processSize2 = new int[n];
		for(int i=0;i<n;i++)
		{
			System.out.print("Enter the size of " + (i+1) + " process = ");
			processSize[i] = in.nextInt();
			System.out.println();
			processSize2[i] = processSize[i];
		} 
		
		System.out.println("Applying FIRST FIT Policy : ");
		firstFit(blockSize, m, processSize, n);

		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println();

		System.out.println("Applying BEST FIT Policy : ");
		bestFit(blockSize2, m, processSize2, n);
		System.out.println();
	} 
} 
