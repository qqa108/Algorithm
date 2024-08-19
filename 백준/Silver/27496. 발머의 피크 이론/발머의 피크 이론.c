#include <stdio.h>
#include <stdlib.h>

int main()
{
    int N;
    int L;
    int* ach;
    int* sch; 
    int time;
    int i;
    int count=0;

    scanf("%d %d", &N, &L);

    ach = (int*)malloc(sizeof(int)*N);
    sch = (int*)malloc(sizeof(int)*N);

    for(i=0; i<N; i++)
    {
        scanf("%d", &time);
        ach[i] = time;
        sch[i] = 0;
    }

    sch[0] = ach[0];
    if(sch[0] >= 129 && sch[0] <= 138)
    {
        count++;
    }

    for(i=1; i<N; i++)
    {
        sch[i] = sch[i-1] + ach[i];
        if(L<=i)
        {
            sch[i] = sch[i] - ach[i-L];
        }
        if(sch[i] >= 129 && sch[i] <= 138)
        {
            count++;
        }
    }

    printf("%d", count);

    free(ach);
    free(sch);

    return 0;
}