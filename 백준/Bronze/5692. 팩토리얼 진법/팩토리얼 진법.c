#include <stdio.h>

int change_number(int num)
{
	int a, b, c, d, e;
	int sum = 0;
	
	a = num / 10000;
	num = num - a * 10000;
	sum = sum + a * 5 * 4 * 3 * 2;

	b = num / 1000;
	num = num - b * 1000;
	sum = sum + b * 4 * 3 * 2;

	c = num / 100;
	num = num - c * 100;
	sum = sum + c * 3 * 2;

	d = num / 10;
	sum = sum + d * 2;

	e = num % 10;
	sum = sum + e;

	return sum;
}
int main()
{
	int i;
	int num;

	while (1)
	{
		scanf("%d", &num);

		if (num == 0)
			break;

		printf("%d\n", change_number(num));
	}

	return 0;
}