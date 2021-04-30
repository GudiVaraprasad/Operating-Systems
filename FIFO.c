// C Program for First in First Out Page Replacement Algorithm.
#include <stdio.h>

int main()
{
    int i, j, n, ref_str[50], frame[10], no, k, avail, fcount = 0;

    printf("\n ENTER THE NUMBER OF PAGES : ");
    scanf("%d", &n);

    printf("\n ENTER THE PAGE NUMBER : \n");
    for (i = 1; i <= n; i++)
        scanf("%d", &ref_str[i]);

    printf("\n ENTER THE NUMBER OF FRAMES : ");
    scanf("%d", &no);
    for (i = 0; i < no; i++)
        frame[i] = -1;
    j = 0;

    printf("Reference String \tPage Frames Structure \t Hit/Fault \n");
    printf("------------------------------------------------------------ \n");
    for (i = 1; i <= n; i++) 
    {
        printf("%d\t\t", ref_str[i]);
        avail = 0;
        for (k = 0; k < no; k++)
            if (frame[k] == ref_str[i]) 
            {
                avail = 1;
                for (k = 0; k < no; k++)
                    printf("%d\t", frame[k]);
                printf("\tPage Hit");
            }

        if (avail == 0) 
        {
            frame[j] = ref_str[i];
            j = (j + 1) % no;
            fcount++;
            for (k = 0; k < no; k++)
                printf("%d\t", frame[k]);
            printf("\tPage Fault");
        }
        printf("\n");
    }
    printf("\n");
    printf("No. of Page Faults = %d", fcount);
    printf("\n");
    return 0;
}

// Code Contributed by Gudi Varaprasad - 19BCE7048