#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char num[8]={0};
    int n; 
    int count_1, count_2, count_3;
    int count=0;
    int j;
    int i;

    scanf("%d", &n);
    
    for(j=0; j<n; j++)
    {
        count_1=0;
        count_2=0;
        count_3=0;

        sprintf(num, "%d", j+1);

        for(i=0; i<8; i++)
        {   
            if(num[i]=='2')
            {
                count_1++;
            }
            if(num[i]=='0' && count_1 != 0)
            {
                count_2++;
            }
            if(num[i]=='2' && count_2 != 0)
            {
                count_3++;
            }
            if(num[i]=='3' && count_3 != 0)
            {
                count++;
                break;
            }
        }
    }

    printf("%d", count);

    return 0;
}