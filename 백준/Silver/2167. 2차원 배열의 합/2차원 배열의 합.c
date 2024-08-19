#include <stdio.h>
#include <stdlib.h>

int sum_matrix(int **matrix, int a, int b, int x, int y)
{
	int i, j;
	int sum = 0;

	for (i = a; i <= x; i++)
		for (j = b; j <= y; j++)
			sum = sum + matrix[i][j];

	return sum;
}

int main()
{
	int **num;
	int n, m;
	int i, j, h;
	int k;
	int a, b, x, y;

	scanf(" %d%d", &n, &m);

	num = (int**)malloc(sizeof(int*)*n);

	for (i = 0; i < n; i++)
		num[i] = (int*)malloc(sizeof(int)*m);

	for (i = 0; i < n; i++)
	{
		for (j = 0; j < m; j++)
		{
			scanf(" %d", &num[i][j]);
		}
	}

	scanf(" %d", &k);
	for (h = 0; h < k; h++)
	{
		scanf(" %d%d%d%d", &a, &b, &x, &y);
		printf("%d\n", sum_matrix(num, a - 1, b - 1, x - 1, y - 1));
	}
	
	for (i = 0; i < n; i++)
		free(num[i]);
	free(num);
	
	return 0;
}