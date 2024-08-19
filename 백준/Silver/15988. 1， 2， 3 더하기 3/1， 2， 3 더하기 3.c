#include <stdio.h>

int main()
{
	int n, i;
	int tmp;
	long long num[1000001] = { 0 };
	
	scanf(" %d", &n);

	num[1] = 1, num[2] = 2, num[3] = 4;
	
	for (i = 4; i <= 1000000; i++)
	{
		num[i] = (num[i - 1] + num[i - 2] + num[i - 3]) % 1000000009;
	}

	for (i = 0; i < n; i++)
	{
		scanf(" %d", &tmp);
		printf("%d\n", num[tmp]);
	}
	
	return 0;
}