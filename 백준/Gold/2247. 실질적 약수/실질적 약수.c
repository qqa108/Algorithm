#include <stdio.h>

int main()
{
    long n;
    long sum=0;
    int i;

    scanf("%ld",&n);

    for(i=1; i<=n; i++)
    {
        sum=sum+(n/i)*i;
    }

    sum=sum-((n+1)*n/2 +n-1);
    
    printf("%ld",sum%1000000);

    return 0;
}