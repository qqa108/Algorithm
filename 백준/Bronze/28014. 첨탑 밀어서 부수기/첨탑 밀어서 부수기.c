#include <stdio.h>
#include <stdlib.h>

int main()
{
    int* arr;
    int n;
    int i;
    int count=0;

    scanf("%d", &n);

    arr = (int*)malloc(sizeof(int)*(n+1));

    arr[0]=0;

    for(i=1; i<n+1; i++)
    {
        scanf("%d", &arr[i]);

        if(arr[i-1] <= arr[i])
        {
            count++;
        }
    }

    printf("%d", count);

    free(arr);

    return 0;
}