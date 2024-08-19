#include <stdio.h>
#include <string.h>

int stack[100000];
int top = 0;

void push(int n)
{
	stack[++top] = n;
}
int pop()
{
	return stack[top--];
}
int top_()
{
	return stack[top];
}

int main()
{
	int i;
	int j = 1;
	int n;
	int num;
	char s[200001] = { NULL };
	int k = 0;
	int tmp = 0;

	scanf(" %d", &n);

	for (i = 0; i < n; i++)
	{
		scanf(" %d", &num);

		while (1)
		{
			if (tmp == 1)
				break;
			if (num == top_())
			{
				pop();
				s[k++] = '-';
				break;
			}
			if (num > top_())
			{
				s[k++] = '+';
				push(j);
				j++;
			}
			if (num < top_())
			{
				tmp = 1;
				break;
			}

		}
	}
	if (tmp == 1)
	{
		s[0] = NULL;
	}

	k = 0;

	if (tmp == 1)
		printf("NO\n");
	else
		while (s[k] != NULL)
		{
			printf("%c\n", s[k]);
			k++;
		}

	return 0;
}