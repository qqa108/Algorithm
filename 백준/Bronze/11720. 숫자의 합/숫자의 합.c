#include <stdio.h>

int main()
{
	char *num;
	int n;
	int i;
	int sum = 0;

	scanf(" %d", &n);

	num = (char*)malloc(sizeof(char)*n);

	for (i = 0; i < n; i++) 
	{
		scanf(" %c", &num[i]);
		sum = sum + (num[i] - 48);
	}
	printf("%d\n", sum);

	return 0;
}