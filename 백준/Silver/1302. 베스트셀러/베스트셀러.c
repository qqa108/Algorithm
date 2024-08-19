#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void insertion_sort(char **list, int n)
{
	int i, j;
	char key[50];

	for (i = 1; i < n; i++)
	{
		strcpy(key, list[i]);
		
		for (j = i - 1; j >= 0 && strcmp(list[j], key) > 0; j--)
			strcpy(list[j + 1], list[j]);
		strcpy(list[j + 1], key);
	}
}

int main()
{
	char **name;
	int n;
	int i;
	int count = 0;
	int tmp = 0;
	int j;

	scanf("%d", &n);

	name = (int**)malloc(sizeof(int*)*n);

	for (i = 0; i < n; i++)
	{
		name[i] = (char*)malloc(sizeof(char) * 50);
	}

	for (i = 0; i < n; i++)
	{
		scanf("%s", name[i]);
	}

	insertion_sort(name, n);

	for (i = 0; i < n - 1; i++)
	{
		if (tmp < count)
		{
			tmp = count;
			j = i;
		}

		if (strcmp(name[i + 1], name[i]) == 0)
			count++;
		else
			count = 0;
	}
	printf("%s", name[j]);

	return 0;
}