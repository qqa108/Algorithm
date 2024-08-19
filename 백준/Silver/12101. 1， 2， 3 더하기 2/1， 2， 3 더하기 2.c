#include <stdio.h>

long long num[1000001];

void rec(int n, int k)
{
	if (n == 0)
		return 0;
	if (k <= num[n - 1])
	{
		if(n-1==0)
			printf("1");
		else
			printf("1+");
		rec(n - 1, k);
	}
	else if (k <= num[n - 1] + num[n - 2]) 
	{
		k = k - (num[n - 1]);
		if (n - 2 == 0)
			printf("2");
		else
			printf("2+");
		rec(n - 2, k);
	}
	else
	{
		k = k - (num[n - 1] + num[n - 2]);
		if (n - 3 == 0)
			printf("3");
		else
			printf("3+");
		rec(n - 3, k);	
	}
}

int main()
{
	int n, k, i;
	
	scanf(" %d%d", &n,&k);

	num[0] = 1, num[1] = 1, num[2] = 2, num[3] = 4;
	
	for (i = 4; i <= 1000000; i++)
	{
		num[i] = (num[i - 1] + num[i - 2] + num[i - 3]) % 1000000009;
	}

	if (num[n] < k)
		printf("-1");
	else
		rec(n, k);

	return 0;
}