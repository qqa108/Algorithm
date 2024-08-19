#include <stdio.h>

int memo[11];

void divi(int n, int index)
{
	int i;

	for (i = 1; i <= 3; i++)
	{
		if (n - i == 0)
		{
			memo[index]++;
		}
			
		if (n - i > 0)
			divi(n - i,index);
	}
}

int main()
{
	int n, i;
	int tmp;

	scanf("%d", &n);

	for (i = 0; i < n; i++)
	{
		scanf("%d", &tmp);
		divi(tmp, i);
	}

	for (i = 0; i < n; i++)
		printf("%d\n", memo[i]);

	return 0;
}